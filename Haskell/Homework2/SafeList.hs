module SafeList where

safeTail :: [a] -> Either String [a]
safeTail (_:xs) = Right xs
safeTail []     = Left "List is empty"

unpack :: Either String [a] -> [a]
unpack (Right x) = x
unpack (Left _)  = [] 

safeInit :: [a] -> Either String [a]
safeInit []     = Left "List is empty"
safeInit (x:[]) = Right []
safeInit (x:xs) = Right (x : (unpack (safeInit xs)))

strip :: [a] -> [a]
strip l = unpack $ safeTail $ unpack $ safeInit l

strip2 :: [a] -> [a]
strip2 l = 
    let l1 = case (safeInit l) of (Left str) -> error str
                                  (Right x)  -> x
    in case (safeTail l1) of (Left _)  -> error "List length is just one"
                             (Right x) -> x
                                



