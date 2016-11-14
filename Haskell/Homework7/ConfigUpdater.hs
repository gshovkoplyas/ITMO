module ConfigUpdater where

import qualified Data.Text as Txt
import           Data.Text          (splitOn, pack, unpack, Text (..))
import           System.Environment (getArgs)
import           Data.List          (head, map, length)
import           Data.IORef         (newIORef, readIORef, writeIORef, IORef (..))
import           Debug.Trace
import           Data.Map.Lazy      (insert, delete, member, notMember, Map (..), fromList, toList)

main :: IO ()
main = do
    args <- getArgs
    if length args /= 1 then putStrLn "Usage: main <file_name>"
    else do
        src <- readFile $ head args
        let tsrc = pack src
        let lines_ = splitOn (pack "\n") tsrc
        let props = parseProps lines_
        ref <- newIORef props
        run1 ref


parseProps :: [Text] -> Map Text Text
parseProps []     = fromList []
parseProps (x:xs) = insert k v $ parseProps xs
                    where (k, v) = makePair $ splitOn (pack "=") x

makePair :: [Text] -> (Text, Text)
makePair [a, b] = (a, b)


run1 :: IORef (Map Text Text) -> IO ()
run1 ref = do
    putStrLn "Inforation of usage:"
    putStrLn " a <property> <value>: add new property"
    putStrLn " m <property> <value>: modify property"
    putStrLn " d <property>        : delete property"
    putStrLn " s <file_name>       : save changes"
    putStrLn " q                   : quit without saving"
    run ref

run :: IORef (Map Text Text) -> IO ()
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
parseCommand text = let ptxt = splitOn (pack " ") text
                    in case ptxt of 
                            [] -> (pack "", pack "", pack "")
                            [a] -> (a, pack "", pack "")
                            [a, b] -> (a, b, pack "") 
                            [a, b, c] -> (a, b, c)
       
quit :: IO ()
quit = return ()

add :: IORef (Map Text Text) -> Text -> Text -> IO ()
add ref property value = do
    putStrLn "Adding:"
    props <- readIORef ref
    if member property props 
    then putStrLn $ "Property '" ++ unpack property ++ "' already exists"
    else do 
        let nprops = insert property value props 
        writeIORef ref nprops
        putStrLn $ "Property '" ++ unpack property ++ "' added"
    run ref

modify :: IORef (Map Text Text) -> Text -> Text -> IO ()
modify ref property value = do
    putStrLn "Modify:"
    props <- readIORef ref
    if notMember property props 
    then putStrLn $ "Property '" ++ unpack property ++ "' doesn't exist"
    else do 
        let nprops = insert property value props
        writeIORef ref nprops
        putStrLn $ "Property '" ++ unpack property ++ "' modified"
    run ref

del :: IORef (Map Text Text) -> Text -> IO ()
del ref property = do
    putStrLn "Deletion:"
    props <- readIORef ref
    if notMember property props 
    then putStrLn $ "Property '" ++ unpack property ++ "' doesn't exist"
    else do 
        let nprops = delete property props 
        writeIORef ref nprops
        putStrLn $ "Property '" ++ unpack property ++ "' deleted"
    run ref


save :: IORef (Map Text Text) -> Text -> IO ()
save ref filename = do
    putStrLn "Saving:"
    props <- readIORef ref
    let lines_ = map addEq $ toList props
    let tout = Txt.unlines lines_
    writeFile (unpack filename) $ unpack tout
    putStrLn $ "All progress save to '" ++ unpack filename ++ "'"
    run ref

addEq :: (Text, Text) -> Text
addEq (l, r) = pack $ unpack l ++ "=" ++ unpack r

