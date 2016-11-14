module Problem3 where

--Реализовать дек на двух списках

data Deque a = Deque { leftStack  :: [a] 
                     , rightStack :: [a]
                     } deriving Show

emptyDeque :: Deque a
emptyDeque = Deque [] []

size :: Deque a -> Int
size (Deque l r) = length l + length r

isEmpty :: Deque a -> Bool                
isEmpty (Deque l r) = null l && null r
 
pushBack :: Deque a -> a -> Deque a
pushBack (Deque l r) x = Deque (x:l) r

pushFront :: Deque a -> a -> Deque a
pushFront (Deque l r) x = Deque l (x:r)

popBack :: Deque a -> Deque a
popBack (Deque l r) = if not (null l) 
                      then Deque (tail l) r
                      else if not (null r) 
                           then let nr = take (length r `div` 2) r  
                                    nl = reverse $ drop (length r `div` 2) r  
                                in Deque (tail nl) nr
                           else emptyDeque
popFront :: Deque a -> Deque a
popFront (Deque l r) = if not (null r) 
                      then Deque l (tail r)
                      else if not (null l) 
                           then let nl = take (length l `div` 2) l  
                                    nr = reverse $ drop (length l `div` 2) l  
                                in Deque nl (tail nr)
                           else emptyDeque

test1 = pushBack emptyDeque 1
test2 = pushBack test1 2
test3 = pushBack test2 3
test4 = popBack test3
test5 = popFront test4
test6 = popBack test5


  

