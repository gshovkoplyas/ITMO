module BST where

import           Control.Monad.Writer   (Writer (), writer, runWriterT)
import           Control.Monad.Identity (runIdentity)
 
data Tree a = Leaf | Node a (Tree a) (Tree a)
   deriving Show


find :: (Show a, Ord a) => Tree a -> a -> Writer String Bool
find Leaf x    = writer (False, "Tree hasn't key" ++ (show x))
find (Node key left right) x 
    | key == x = writer (True, "Key = " ++ (show x) ++ "found")
    | key > x  = find left x
    | key < x  = find right x 

insert :: (Show a, Ord a) => Tree a -> a -> Writer String (Tree a)
insert Leaf x  = writer (Node x Leaf Leaf, "New node created for key =" ++ (show x))
insert (Node key left right) x 
    | key > x  = insert left x >>= \y -> writer (Node key y right, "key > " ++ (show x)) 
    | key < x  = insert right x >>= \y -> writer (Node key left y, "key < " ++ (show x))
    | key == x = writer (Node key left right, "Node (key = " ++ (show x) ++ " ) already exist")

maxKey :: (Ord a) => Tree a -> a
maxKey (Node key _ Leaf)  = key
maxKey (Node key _ right) = maxKey right

deleteTop :: (Show a, Ord a) => Tree a -> Writer String (Tree a)
deleteTop (Node key Leaf right) = writer (right, "left son is leaf")
deleteTop (Node key left Leaf)  = writer (left, "right son is empty")
deleteTop (Node key left right) = 
    let mx = maxKey left
    in delete left mx >>= \y -> writer(Node mx y right, "Try to dell max key = " ++ (show mx) ++ "in left son") 

delete :: (Show a, Ord a) => Tree a -> a -> Writer String (Tree a)
delete Leaf x  = writer (Node x Leaf Leaf, "Tree hasn't key" ++ (show x)) 
delete (Node key left right) x 
    | key > x  = delete left x >>= \y -> writer (Node key y right, "key > " ++ (show x)) 
    | key < x  = delete right x >>= \y -> writer (Node key left y, "key < " ++ (show x)) 
    | key == x = deleteTop (Node key left right) >>= \y -> writer(y, "Delete node (key = " ++ (show x) ++ ")")

test = Node 3 (Node 1 Leaf Leaf) $ Node 123 (Node 4 Leaf Leaf) Leaf

--check = execWriter $ delete test 3

