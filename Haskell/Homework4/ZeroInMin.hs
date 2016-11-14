module ZeroInMin where

manHeaps :: (Int, Int) -> [(Int, Int)]
manHeaps (a, b) = filter isCorrectHeaps [(a - 1, b), (a * 2, div b 2), (a, b - 1), (div a 2, b * 2)]
    where isCorrectHeaps (x, y) = x >= 0 && y >= 0

zeroIn3 :: (Int, Int) -> Bool
zeroIn3 h = any (\(a, b) -> a == 0 && b == 0) $ [h] >>= manHeaps >>= manHeaps >>= manHeaps

zeroInMin :: (Int, Int) -> Int
zeroInMin h = zeroInMin1 0 [h]

zeroInMin1 :: Int -> [(Int, Int)] -> Int
zeroInMin1 cnt hs = if any (\(a, b) -> a == 0 && b == 0) hs
                    then cnt
                    else zeroInMin1 (cnt + 1) $ hs >>= manHeaps
 

