module ConfigUpdaterList where

import          Data.Text as Text 
import          System.Environment
import          Data.List as List
import          Data.IORef as IORef
import          Debug.Trace

main :: IO ()
main = do
    args <- getArgs
    if List.length args /= 1 then putStrLn "Usage: main <file_name>"
    else do
        src <- readFile $ List.head args
        --writeFile (List.head args ++ ".out") src
        let tsrc = pack src
        let lines_ = Text.splitOn (pack "\n") tsrc
        let props = parseProps lines_
        ref <- newIORef props
        run1 ref


parseProps :: [Text] -> [(Text, Text)]
parseProps []     = []
parseProps (x:xs) = makePair (Text.splitOn (pack "=") x) : (parseProps xs)

makePair :: [Text] -> (Text, Text)
makePair [a, b] = (a, b)


run1 :: IORef [(Text, Text)] -> IO ()
run1 ref = do
    putStrLn "Inforation of usage:"
    putStrLn " a <property> <value>: add new property"
    putStrLn " m <property> <value>: modify property"
    putStrLn " d <property>        : delete property"
    putStrLn " s <file_name>       : save changes"
    putStrLn " q                   : quit without saving"
    run ref

run :: IORef [(Text, Text)] -> IO ()
run ref = do
    putStrLn "Input command:"
    input <- getLine
    let input_ = pack input
    let (command, property, value) = parseCommand input_  
    case unpack command of
        "a" -> add ref property value
        "m" -> modify ref property value
        "d" -> del ref property
        "s" -> save ref property
        "q" -> quit
        _ -> putStrLn "Unexpected command" >> run1 ref

parseCommand :: Text -> (Text, Text, Text)
parseCommand text = let ptxt = Text.splitOn (pack " ") text
                    in case ptxt of 
                            [] -> (pack "", pack "", pack "")
                            [a] -> (a, pack "", pack "")
                            [a, b] -> (a, b, pack "") 
                            [a, b, c] -> (a, b, c)

quit :: IO ()
quit = return ()

add :: IORef [(Text, Text)] -> Text -> Text -> IO ()
add ref property value = do
    putStrLn "Adding:"
    props <- readIORef ref
    if elem property (List.map fst props) 
    then putStrLn $ "Property '" ++ unpack property ++ "' already exists"
    else do 
        let nprops = (property, value) : props 
        writeIORef ref nprops
        putStrLn $ "Property '" ++ unpack property ++ "' added"
    run ref

modify :: IORef [(Text, Text)] -> Text -> Text -> IO ()
modify ref property value = do
    putStrLn "Modify:"
    props <- readIORef ref
    if notElem property (List.map fst props) 
    then putStrLn $ "Property '" ++ unpack property ++ "' doesn't exist"
    else do 
        let nprops = modifyProps props property value 
        writeIORef ref nprops
        putStrLn $ "Property '" ++ unpack property ++ "' modified"
    run ref


modifyProps :: [(Text, Text)] -> Text -> Text -> [(Text, Text)]
modifyProps (x:xs) p v = if fst x == p
                         then (p, v) : xs
                         else x : (modifyProps xs p v)

del :: IORef [(Text, Text)] -> Text -> IO ()
del ref property = do
    putStrLn "Deletion:"
    props <- readIORef ref
    if notElem property (List.map fst props) 
    then putStrLn $ "Property '" ++ unpack property ++ "' doesn't exist"
    else do 
        let nprops = delProps props property 
        writeIORef ref nprops
        putStrLn $ "Property '" ++ unpack property ++ "' deleted"
    run ref


delProps :: [(Text, Text)] -> Text -> [(Text, Text)]
delProps (x:xs) p = if fst x == p
                    then xs
                    else x : (delProps xs p)


save :: IORef [(Text, Text)] -> Text -> IO ()
save ref filename = do
    putStrLn "Saving:"
    props <- readIORef ref
    let lines_ = List.map addEq props
    let tout = Text.unlines lines_
    writeFile (unpack filename) $ unpack tout
    putStrLn $ "All progress save to '" ++ unpack filename ++ "'"
    run ref

addEq :: (Text, Text) -> Text
addEq (l, r) = pack $ unpack l ++ "=" ++ unpack r

