import           System.Random (newStdGen, randomRs)

randomIntList :: Int -> Int -> Int -> IO [Int]
randomIntList n from to = take n . randomRs (from, to) <$> newStdGen

mergeSort :: [Int] -> [Int]
mergeSort l  
    | length l <= 1 = l
    | otherwise     = merge (mergeSort left) (mergeSort right)
    where 
        left  = take (length l `div` 2) l
        right = drop (length l `div` 2) l

merge :: [Int] -> [Int] -> [Int]
merge x [] = x
merge [] y = y
merge x@(xf:xs) y@(yf:ys)
    | (xf <= yf) = xf : (merge xs y)
    | otherwise  = yf : (merge x ys)

--example <- randomIntList 5 (-10) 10
--parse error on input '<-' :( Why?!
example = [2, 1, 0, 3, 10, 5]

ans = mergeSort example