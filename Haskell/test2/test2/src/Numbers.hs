module Numbers where

addNumbers :: IO()
addNumbers z = do
    putStrLn "Enter how many numbers:" 
    n <- getInt
    res <- readAndAdd n  
    print $ z + res               

readAndAdd :: Int -> IO Int
readAndAdd n = do
    a <- getInt
    if (n == 0) 
    then return 0      
    else do
        res <- readAndAdd (n - 1) 
        return $ if (a mod 2 == 0) 
                 then res + a
                 else res - a

