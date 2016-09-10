import Data.List

zipN :: ([a] -> b) -> [[a]] -> [b]
zipN f [] = []
zipN f l@(x:xs) 
    | null x    = [] 
    | otherwise = f (map head l) : zipN f (map tail l)

ans = zipN sum [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
ans1 = take 5 $ zipN (take 3) $ repeat [0..]
ans2 = take 5 $ zipN (take 3) $ repeat [0..1]