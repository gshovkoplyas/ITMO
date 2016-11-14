{-# LANGUAGE FlexibleInstances, UndecidableInstances #-}
module StateMonad where

data State s v = State { runState :: s -> (v, s) }

instance Applicative (State s) => Monad (State s) where
    return v = State (\s -> (v, s))
--(>>=) :: State s a -> (a -> State s b) -> State s b    
    state >>= f = State (\s -> let (value, newState) = (runState state) s 
                               in (runState (f value)) newState)
