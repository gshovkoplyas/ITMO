module SmallGame where

import Debug.Trace

data Player = Player
    { pname :: String
    , inith  :: Int
    , phealth  :: Int
    , pattack  :: Int
    , pdefense :: Int
    } deriving Show

data Equipment = Equipment
    { ename :: String
    , ehealth  :: Int
    , eattack  :: Int
    , edefense :: Int
    } deriving Show

data Monster = Monster
    { mname :: String
    , mhealth  :: Int
    , mattack  :: Int
    , mdefense :: Int
    , loot :: Equipment
    } deriving Show

mStr :: Monster -> String
mStr (Monster mn mh ma md l) = mn ++ " = {" ++ (show mh) ++ ", " ++ (show ma) ++ ", " ++ (show md) ++ "}" 

player = Player "Grisha" 100 100 1 0
strength = Equipment "Strength" 150 10 0
endurance = Equipment "Endurance" 100 25 25   
magic = Equipment "Magic" 200 5 5
m0 = Monster "Monster 0" 0 5 0 strength 
m1 = Monster "Monster 1" 5 5 0 strength 
m2 = Monster "Monster 2" 20 10 5 endurance 
m3 = Monster "Monster 3" 100 20 2 magic

monsters = [m1, m2, m3]

statsE :: Equipment -> Int
statsE (Equipment n h a d) = h + a + d

statsP :: Player -> Int
statsP (Player n h _ a d) = h + a + d


data Result = Win | Lose
    deriving Show


updH :: Int -> Int -> Int -> Int
updH h a d =
    let new_h = min (h - a + d) h --because we can't hill by defense
    in max 0 new_h

updStats :: Player -> Equipment -> Player
updStats p@(Player pn ih ph pa pd) e@(Equipment en eh ea ed) 
    = if ((statsP p) > (statsE e))
      then trace (en ++ " dropped") (Player pn ih ih pa pd)
      else trace (en ++ " getted") (Player pn eh eh ea ed) 

gloriousBattle :: Player -> [Monster] -> Result
gloriousBattle _ [] = Win
gloriousBattle p@(Player _ _ 0 _ _) _ = Lose
gloriousBattle p@(Player pn _ ph pa pd) (m@(Monster mn 0 ma md l):ms) 
    = trace (mn ++ " killed, " ++ (show l) ++ " collected") $ gloriousBattle (updStats p l) ms
gloriousBattle p@(Player pn ih ph pa pd) (m@(Monster mn mh ma md l):ms) 
    = traceShow p $ trace (mStr m) $ gloriousBattle (Player pn ih (updH ph ma pd) pa pd) ((Monster mn (updH mh pa md) ma md l):ms) 

check = gloriousBattle player [m0]
check1 = gloriousBattle player [m1]
check2 = gloriousBattle player monsters
