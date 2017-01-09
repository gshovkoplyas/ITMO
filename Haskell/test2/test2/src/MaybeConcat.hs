module MaybeConcat where

maybeConcat :: [ Maybe [a] ] -> Maybe [a]
maybeConcat [] = Just []
maybeConcat l = case head l of Nothing -> maybeConcat (tail l)
                               Just _ -> maybeConcat (tail l) >>= (\x -> twoConcat (head l) x)
                               where twoConcat :: Maybe [a] -> [a] -> Maybe [a]
                                     twoConcat l1 l2 = l1 >>= (\y -> Just (y ++ l2)) 

