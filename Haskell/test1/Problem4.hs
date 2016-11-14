module Problem4 where

import         Problem3
--Реализовать моноид для 3

toList :: Deque a -> [a]
toList (Deque l r) = (reverse r) ++ l

addList :: Deque a -> [a] -> Deque a
addList d [] = d
addList d (x:xs) = pushFront (addList d xs) x

instance Monoid (Deque a) where
    mempty      = emptyDeque
    mappend x y = if isEmpty x
                  then y
                  else if isEmpty y
                       then x
                       else addList x $ toList y

mtest1 = mappend mempty test3
mtest2 = mappend test3 test3                      


  

