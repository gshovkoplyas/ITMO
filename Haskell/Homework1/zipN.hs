import Data.List

zipN :: (a -> a -> a) -> [[a]] -> [a]
zipN f (x:y:l) 
    | null l    = zipWith f x y 
    | otherwise = zipN f ((zipWith f x y) : l)
ans = zipN (+) [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
