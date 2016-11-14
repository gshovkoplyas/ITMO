{-# LANGUAGE FlexibleInstances, UndecidableInstances #-}

module Instance4 where

import           JoinFish


--(>=>) :: (m a -> m b) -> (b -> m c) -> (a -> m c)
--join  :: m (m a) -> m a
--id :: a -> a
--a = m b
--(>=>) :: ((m b) -> m b) -> (b -> m c) -> ((m b) -> m c)
--b = m c
--a = m (m c)
--(>=>) :: ((m (m c)) -> m (m c)) -> ((m c) -> m c) -> ((m (m c)) -> m c)


instance (Applicative m, MonadFish m) => MonadJoin m where    
    returnJoin = returnFish
    join x = (id >=> id) x 