{-# LANGUAGE MultiParamTypeClasses, FlexibleInstances, FunctionalDependencies #-}
module SetToMap where

import           BST (see, delete, next)
import           TreePrinters (Tree (..))
import           MonoidFoldableTree
--data Tree a = Leaf | Node a (Tree a) (Tree a)
--   deriving Show

class (Monoid (t a), Foldable t) => Set t a where
    semptySet :: t a
    stoList   :: t a -> [a] 
    sfind     :: t a -> a -> Bool
    sinsert   :: t a -> a -> t a
    sdelete   :: t a -> a -> t a
    snext     :: t a -> a -> Maybe a 
    sfromList :: [a] -> t a

instance Ord a => Set Tree a where
    semptySet = mempty
    stoList t = reverse $ foldr (\x -> (++ [x])) [] t
    sfind t k = foldr (\x -> (|| (x == k))) False t
    sinsert t x = mappend t $ Node x Leaf Leaf 
    sdelete t x = BST.delete t x
    snext t x = BST.next t x
    sfromList l = foldr (\x -> (mappend (Node x Leaf Leaf))) mempty l

class (Monoid (t (k, v)), Foldable t, Set t k) => Map t k v where
    memptyMap :: t (k, v)
    mtoList   :: t (k, v) -> [(k, v)] 
    mfind     :: t (k, v) -> (k, v) -> Bool
    minsert   :: t (k, v) -> (k, v) -> t (k, v)
    mdelete   :: t (k, v) -> (k, v) -> t (k, v)
    mnext     :: t (k, v) -> (k, v) -> Maybe (k, v) 
    mfromList :: [(k, v)] -> t (k, v)

instance (Ord k, Ord v) => Map Tree k v where
    memptyMap        = semptySet 
    mtoList t        = stoList t
    mfind t (x, y)   = sfind t (x, y) 
    minsert t (x, y) = sinsert t (x, y)
    mdelete t (x, y) = sdelete t (x, y)
    mnext t (x, y)   = snext t (x, y)
    mfromList l      = sfromList l

testt :: Tree (Int, Int)
testt = mfromList [(1, 2), (2, 3), (3, 2)]
testt1 = mnext testt (2, 3)
testt2 = mtoList testt
