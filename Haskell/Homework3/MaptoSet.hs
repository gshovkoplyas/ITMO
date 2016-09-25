{-# LANGUAGE MultiParamTypeClasses, FlexibleInstances, FunctionalDependencies #-}
module MapToSet where

import           BST (see, delete, next)
import           TreePrinters (Tree (..))
import           MonoidFoldableTree
--data Tree a = Leaf | Node a (Tree a) (Tree a)
--   deriving Show

class (Monoid (t (k, v)), Foldable t) => Map t k v where
    memptyMap :: t (k, v)
    mtoList   :: t (k, v) -> [(k, v)] 
    mfind     :: t (k, v) -> (k, v) -> Bool
    minsert   :: t (k, v) -> (k, v) -> t (k, v)
    mdelete   :: t (k, v) -> (k, v) -> t (k, v)
    mnext     :: t (k, v) -> (k, v) -> Maybe (k, v) 
    mfromList :: [(k, v)] -> t (k, v)

instance (Ord k, Ord v) => Map Tree k v where
    memptyMap          = mempty
    mtoList   t        = reverse $ foldr (\x -> (++ [x])) [] t
    mfind     t (x, y) = foldr (\q -> (|| (q == (x, y)))) False t
    minsert   t (x, y) = mappend t $ Node (x, y) Leaf Leaf 
    mdelete   t (x, y) = BST.delete t (x, y)
    mnext     t (x, y) = BST.next t (x, y)
    mfromList l        = foldr (\x -> (mappend (Node x Leaf Leaf))) mempty l

class (Monoid (t a), Foldable t, Map t a a) => Set t a where
    semptySet :: t (a, a)
    stoList   :: t (a, a) -> [a] 
    sfind     :: t (a, a) -> a -> Bool
    sinsert   :: t (a, a) -> a -> t (a, a)
    sdelete   :: t (a, a) -> a -> t (a, a)
    snext     :: t (a, a) -> a -> Maybe a 
    sfromList :: [a] -> t (a, a)

instance Ord a => Set Tree a where
    semptySet     = memptyMap
    stoList   t   = map fst $ mtoList t
    sfind t   k   = mfind t (k, k)
    sinsert   t x = minsert t (x, x)
    sdelete   t x = mdelete t (x, x)
    snext     t x = 
        let ans = mnext t (x, x)
        in case ans of
                Nothing     -> Nothing
                Just (f, s) -> Just f
    sfromList l   = mfromList $ map (\x -> (x, x)) l

testt0 :: Tree (Int, Int)
testt0 = semptySet
testt :: Tree (Int, Int)
testt = sfromList [1, 2, 3]
testt1 = snext testt 2
testt2 = stoList testt