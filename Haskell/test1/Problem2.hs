module Problem2 where

--Реализовать операцию вставки в дерево, узлы которого ещё хранят своего родителя

data Tree a = Leaf | Node { value  :: a 
                          , parent :: Maybe (Tree a) 
                          , left   :: Tree a
                          , right  :: Tree a
                          } deriving Show

insert1 :: (Ord a) => Tree a -> Maybe (Tree a) -> a -> Tree a
insert1 Leaf par x           = Node x par Leaf Leaf
insert1 t@(Node v p l r) _ x = case compare v x of EQ -> Node v p l r
                                                   LT -> Node v p l (insert1 r (Just t) x)
                                                   GT -> Node v p (insert1 l (Just t) x) r

insert :: (Ord a) => Tree a -> a -> Tree a
insert t x = insert1 t Nothing x

test0 = insert Leaf 6
test1 = insert test0 2
test2 = insert test1 3
test3 = insert test1 1


