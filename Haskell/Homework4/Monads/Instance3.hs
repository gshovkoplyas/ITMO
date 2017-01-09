{-# LANGUAGE FlexibleInstances, UndecidableInstances #-}

module Instance3 where

import           JoinFish


--(>=>) :: (a -> m b) -> (b -> m c) -> (a -> m c)
--(>>=) ::        m a -> (a -> m b) -> m b
--const :: (a -> b) -> a
--const m a :: _ -> m a
--(>=>) :: (_ -> m a) -> (a -> m b) -> (a -> m b)

instance (Applicative m, MonadFish m) => Monad m where    
    return = returnFish
    a >>= f = (const a >=> f) undefined 