module Problem1 where

--Верните список, в котором все подряд идущие одинаковые элементы заменены на один

unique :: (Eq a) => [a] -> [a]
unique l = foldr (\y x -> if null x then [y] else if ((head x) == y) then x else y:x) [] l

test1 = unique [1, 1]
test2 = unique [1]
test3 = unique [1, 2, 3, 4, 5]
test4 = unique [1, 1, 2, 2, 5, 5, 1, 1]
test5 = unique [1, 2, 1, 2, 1, 2, 1]
test6 = unique [2, 2, 2, 2, 2, 5, 2, 2, 2, 2, 2, 2, 2]