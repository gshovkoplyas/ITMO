module LCA where

data InNode a = Node 
    { label  :: a
    , parent :: Maybe (InNode a)
    } deriving Show

least :: Eq a => [InNode a] -> [InNode a] -> Maybe (InNode a)
least _ [] = Nothing
least [] _ = Nothing
least (x:xs) (y:ys) = if   label x == label y 
                      then case (least xs ys) of Nothing -> Just x 
                                                 Just a -> Just a 
                      else Nothing


go :: Eq a => InNode a -> [InNode a]
go n@Node{parent = Nothing} = [n]
go n@Node{parent = Just x}  = n:(go x)

leastCommonAncestor :: Eq a => InNode a -> InNode a -> Maybe (InNode a)
leastCommonAncestor x y = least (reverse(go x)) (reverse(go y))  

test1 = Node{label = 1, parent = Nothing}
test2 = Node{label = 2, parent = Just test1}
test3 = Node{label = 3, parent = Just test1}
test4 = Node{label = 4, parent = Just test2}
check = leastCommonAncestor test3 test4