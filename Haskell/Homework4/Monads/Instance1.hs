{-# LANGUAGE FlexibleInstances, UndecidableInstances #-}

module Instance1 where

import           JoinFish

--(>=>) :: (a -> m b) -> (b -> m c) -> (a -> m c)
--(>>=) ::        m b -> (b -> m c) -> m c

instance Monad m => MonadFish m where
    returnFish = return
    f >=> g = \a -> f a >>= g