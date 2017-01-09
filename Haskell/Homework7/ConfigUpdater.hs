{-# LANGUAGE OverloadedStrings #-}
module ConfigUpdater where

import           Data.IORef         (IORef (..), newIORef, readIORef, writeIORef)
import           Data.List          (head, length, map)
import           Data.Map.Lazy      (Map (..), delete, fromList, insert, member,
                                     notMember, toList)
import           Data.Text          (Text (..), append, pack, splitOn, unpack)
import qualified Data.Text          as Txt
import qualified Data.Text.IO       as TIO
import           Debug.Trace
import           System.Environment (getArgs)

main :: IO ()
main = do
    args <- getArgs
    if length args /= 1 then TIO.putStrLn "Usage: main <file_name>"
    else do
        tsrc <- TIO.readFile $ head args
        let lines_ = splitOn "\n" tsrc
        let props = parseProps lines_
        ref <- newIORef props
        run1 ref


parseProps :: [Text] -> Map Text Text
parseProps []     = fromList []
parseProps (x:xs) = insert k v $ parseProps xs
                    where (k, v) = makePair $ splitOn "=" x

makePair :: [Text] -> (Text, Text)
makePair [a, b] = (a, b)


run1 :: IORef (Map Text Text) -> IO ()
run1 ref = do
    TIO.putStrLn "Inforation of usage:"
    TIO.putStrLn " a <property> <value>: add new property"
    TIO.putStrLn " m <property> <value>: modify property"
    TIO.putStrLn " d <property>        : delete property"
    TIO.putStrLn " s <file_name>       : save changes"
    TIO.putStrLn " q                   : quit without saving"
    run ref

run :: IORef (Map Text Text) -> IO ()
run ref = do
    TIO.putStrLn "Input command:"
    input <- TIO.getLine
    let (command, property, value) = parseCommand input
    case command of
        "a" -> add ref property value
        "m" -> modify ref property value
        "d" -> del ref property
        "s" -> save ref property
        "q" -> quit
        _   -> TIO.putStrLn "Unexpected command" >> run1 ref

parseCommand :: Text -> (Text, Text, Text)
parseCommand text = let ptxt = splitOn " " text
                    in case ptxt of
                            []        -> ("", "", "")
                            [a]       -> (a, "", "")
                            [a, b]    -> (a, b, "")
                            [a, b, c] -> (a, b, c)

quit :: IO ()
quit = return ()

add :: IORef (Map Text Text) -> Text -> Text -> IO ()
add ref property value = do
    TIO.putStrLn "Adding:"
    props <- readIORef ref
    if member property props
    then TIO.putStrLn $ "Property '" `append` property `append` "' already exists"
    else do
        let nprops = insert property value props
        writeIORef ref nprops
        TIO.putStrLn $ "Property '" `append` property `append` "' added"
    run ref

modify :: IORef (Map Text Text) -> Text -> Text -> IO ()
modify ref property value = do
    TIO.putStrLn "Modify:"
    props <- readIORef ref
    if notMember property props
    then TIO.putStrLn $ "Property '" `append` property `append` "' doesn't exist"
    else do
        let nprops = insert property value props
        writeIORef ref nprops
        TIO.putStrLn $ "Property '" `append` property `append` "' modified"
    run ref

del :: IORef (Map Text Text) -> Text -> IO ()
del ref property = do
    TIO.putStrLn "Deletion:"
    props <- readIORef ref
    if notMember property props
    then TIO.putStrLn $ "Property '" `append` property `append` "' doesn't exist"
    else do
        let nprops = delete property props
        writeIORef ref nprops
        TIO.putStrLn $ "Property '" `append` property `append` "' deleted"
    run ref


save :: IORef (Map Text Text) -> Text -> IO ()
save ref filename = do
    TIO.putStrLn "Saving:"
    props <- readIORef ref
    let lines_ = map addEq $ toList props
    let tout = Txt.unlines lines_
    TIO.writeFile (unpack filename) tout
    TIO.putStrLn $ "All progress save to '" `append` filename `append` "'"
    run ref

addEq :: (Text, Text) -> Text
addEq (l, r) = l `append` "=" `append` r