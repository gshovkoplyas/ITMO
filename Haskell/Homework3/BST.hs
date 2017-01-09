module BST where

import           Debug.Trace
import           TreePrinters    
--data Tree a = Leaf | Node a (Tree a) (Tree a)
--   deriving Show


find :: (Ord a) => Tree a -> a -> Bool
find Leaf x    = False
find (Node key left right) x 
    | key == x = True
    | key > x  = find left x
    | key < x  = find right x
 

insert :: (Ord a) => Tree a -> a -> Tree a
insert Leaf x  = Node x Leaf Leaf
insert (Node key left right) x 
    | key > x  = Node key (insert left x) right
    | key < x  = Node key left (insert right x) 
    | key == x = Node key left right

maxKey :: (Ord a) => Tree a -> a
maxKey (Node key _ Leaf)  = key
maxKey (Node key _ right) = maxKey right

deleteTop :: (Ord a) => Tree a -> Tree a
deleteTop (Node key Leaf right) = right
deleteTop (Node key left Leaf)  = left
deleteTop (Node key left right) = 
    let mx = maxKey left
    in Node mx (delete left mx) right 

delete :: (Ord a) => Tree a -> a -> Tree a
delete Leaf x  = Node x Leaf Leaf
delete (Node key left right) x 
    | key > x  = Node key (delete left x) right
    | key < x  = Node key left (delete right x) 
    | key == x = deleteTop $ Node key left right

toList :: Tree a -> [a]
toList Leaf = []
toList (Node key left right) = (toList left) ++ [key] ++ (toList right) 

fromList :: (Ord a) => [a] -> Tree a
fromList []     = Leaf
fromList (x:xs) = insert (fromList xs) x    

test = Node 3 (Node 1 Leaf Leaf) $ Node 123 (Node 4 Leaf Leaf) Leaf

see t = putStr $ verticalPrint t

next :: (Ord a) => Tree a -> a -> Maybe a 
next t x = next1 t x Nothing

next1 :: (Ord a) => Tree a -> a -> Maybe a -> Maybe a 
next1 Leaf _ ans = ans
next1 (Node key left right) x ans = if key > x  
                                    then next1 left x $ Just key
                                    else next1 right x ans 
