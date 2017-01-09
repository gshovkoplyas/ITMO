{-# LANGUAGE FlexibleInstances, UndecidableInstances #-}

module Instance2 where

import           JoinFish

--returnJoin :: a -> m a
--join         :: m (m a) -> m a
--(>>=) ::        m (m a) -> ((m a) -> m a) -> m a
--id ::                        m a  -> m a

instance Monad m => MonadJoin m where
    returnJoin = return
    join x = x >>= id