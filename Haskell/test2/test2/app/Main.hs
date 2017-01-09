module Main where

import           Lib
import           MaybeConcat



main :: IO ()
main = print  "testing maybeConcat:" >>
       print (map show tests) >> 
       return()


tests = [ maybeConcat [Nothing]
        , maybeConcat [Just []]
        , maybeConcat [Just [1, 2, 3]]
        , maybeConcat [Just [1, 2, 3], Just [], Just [4, 5, 6]]
        , maybeConcat [Nothing, Nothing, Just[], Just[], Nothing]
        , maybeConcat [Just[1], Just[2], Just [3], Just [10, 11], Just [4]]
        , maybeConcat [Just [1..10], Just [1, 3..9]]
        ]
