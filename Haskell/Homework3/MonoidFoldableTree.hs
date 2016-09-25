module MonoidFoldableTree where

import           BST (fromList, insert, see)
import           TreePrinters (Tree (..))
--data Tree a = Leaf | Node a (Tree a) (Tree a)
--   deriving Show

instance (Ord a) => Monoid (Tree a) where
    mempty      = Leaf
    mappend x Leaf = x
    mappend Leaf y = y
    mappend t (Node k l r) = mappend (mappend (insert t k) l) r

instance Foldable Tree where
    foldr f z Leaf = z
    foldr f z (Node k l r) = foldr f (f k (foldr f z r)) l

t1 = BST.fromList [1, 5, 2, 4, 3]
t2 = BST.fromList $ map negate [1, 5, 2, 4, 3]
test = foldr (+) 0 $ mappend t1 t2

