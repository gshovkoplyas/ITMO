module CartesianTree where

import Debug.Trace


data Treap = Leaf | Node 
    { val     :: Int
    , max_val :: Int
    , y       :: Int
    , size    :: Int
    , left    :: (Treap)
    , right   :: (Treap) 
    } deriving Show

sizeOf :: Treap -> Int
sizeOf Leaf                = 0
sizeOf (Node _ _ _ sz _ _) = sz

maxValOf :: Treap -> Int
maxValOf Leaf                = 0
maxValOf (Node _ mv _ _ _ _) = mv


split :: Treap -> Int -> (Treap, Treap)
split Leaf _ = (Leaf, Leaf)
split (Node v mv y sz left right) x =
    let q = (sizeOf left) + 1
    in if q <= x 
       then let (t, rOut) = split right $ x - q 
                lOut      = update $ Node v v y sz left t
                in (lOut, rOut)  
       else let (lOut, t) = split left x 
                rOut      = update $ Node v v y sz t right
                in (lOut, rOut)

tmax :: (Ord a) => a -> a -> a -> a
tmax a b c = max a $ max b c

update :: Treap -> Treap
update (Node v mv y sz left right) = 
    Node v (tmax mv (maxValOf left) (maxValOf right)) y ((sizeOf left) + (sizeOf right) + 1) left right 

merge :: Treap -> Treap -> Treap
merge t Leaf = t
merge Leaf t = t
merge l@(Node v1 mv1 y1 sz1 l1 r1) r@(Node v2 mv2 y2 sz2 l2 r2) =
    if y1 > y2 
    then let rOut = merge r1 r
         in update $ Node v1 mv1 y1 sz1 l1 rOut    
    else let lOut = merge l l2
         in update $ Node v2 mv2 y2 sz2 lOut r2

rnd = 5

add :: Treap -> Int -> Treap
add t x =
    let m = Node x x rnd 1 Leaf Leaf
    in merge m t

fromList :: [Int] -> Treap
fromList [] = Leaf
fromList (x:xs) = add (fromList xs) x

show1 :: Treap -> String 
show1 Leaf = "Leaf"
show1 (Node v mv y sz l r) = 
    "Node " ++ (show v) ++ " maxv = " ++ (show mv) ++ " { " ++ (show (maxValOf l)) ++ ", " ++ (show (maxValOf r)) ++ "}"

rmq :: Treap -> Int -> Int -> Int
rmq Leaf _ _ = undefined
rmq t@(Node v mv y sz l r) a b =
    let (t1, t2) = split t b
        (t3, t4) = traceShow (show1 t1) $ trace (show1 t2) $ split t1 $ a - 1  
    in max_val t4  
