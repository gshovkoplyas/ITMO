module Coins where

--import Data.Ord

newtype Coin color = Coin { getCoin :: Integer }
    deriving Show

instance Num (Coin a) where
    (+) (Coin x) (Coin y) = Coin (x + y)
    (-) x y       = Coin (getCoin x - getCoin y)
    (*) x y       = Coin (getCoin x * getCoin y)
    negate x      = Coin (negate (getCoin x))
    abs x         = Coin (abs (getCoin x))
    signum x      = Coin (signum (getCoin x))
    fromInteger x = Coin x
    

instance Monoid (Coin a) where
    mempty = Coin 0
    mappend x y = Coin (getCoin x + getCoin y) 

data Blue
data Red

class Color a where
    value :: a -> Integer

instance Color Blue where
    value _ = 0
     
instance Color Red where
    value _ = 1

getColor :: Coin color -> color
getColor _ = undefined

blue = undefined :: Blue
red  = undefined :: Red

coinCMP :: (Color a, Color b) => Coin a -> Coin b -> Ordering
coinCMP x y 
    | (value (getColor x) == value (getColor y)) = EQ
    | (value (getColor x) <  value (getColor y)) = LT
    | (value (getColor x) >  value (getColor y)) = GT


createCoins :: color -> Integer -> Coin color
createCoins _ = Coin 

cb1 = createCoins blue 10
cb2 = createCoins blue 10
cr1 = Coin 5 :: Coin Red

