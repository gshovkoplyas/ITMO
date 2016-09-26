{-# LANGUAGE CPP #-}
{-# OPTIONS_GHC -fno-warn-missing-import-lists #-}
{-# OPTIONS_GHC -fno-warn-implicit-prelude #-}
module Paths_hw3 (
    version,
    getBinDir, getLibDir, getDataDir, getLibexecDir,
    getDataFileName, getSysconfDir
  ) where

import qualified Control.Exception as Exception
import Data.Version (Version(..))
import System.Environment (getEnv)
import Prelude

#if defined(VERSION_base)

#if MIN_VERSION_base(4,0,0)
catchIO :: IO a -> (Exception.IOException -> IO a) -> IO a
#else
catchIO :: IO a -> (Exception.Exception -> IO a) -> IO a
#endif

#else
catchIO :: IO a -> (Exception.IOException -> IO a) -> IO a
#endif
catchIO = Exception.catch

version :: Version
version = Version [0,1,0,0] []
bindir, libdir, datadir, libexecdir, sysconfdir :: FilePath

bindir     = "F:\\git\\ITMO\\Haskell\\Homework3\\hw3\\.stack-work\\install\\bf793b62\\bin"
libdir     = "F:\\git\\ITMO\\Haskell\\Homework3\\hw3\\.stack-work\\install\\bf793b62\\lib\\x86_64-windows-ghc-8.0.1\\hw3-0.1.0.0-AXaGW1BIMzGD78qTtHJ6tU"
datadir    = "F:\\git\\ITMO\\Haskell\\Homework3\\hw3\\.stack-work\\install\\bf793b62\\share\\x86_64-windows-ghc-8.0.1\\hw3-0.1.0.0"
libexecdir = "F:\\git\\ITMO\\Haskell\\Homework3\\hw3\\.stack-work\\install\\bf793b62\\libexec"
sysconfdir = "F:\\git\\ITMO\\Haskell\\Homework3\\hw3\\.stack-work\\install\\bf793b62\\etc"

getBinDir, getLibDir, getDataDir, getLibexecDir, getSysconfDir :: IO FilePath
getBinDir = catchIO (getEnv "hw3_bindir") (\_ -> return bindir)
getLibDir = catchIO (getEnv "hw3_libdir") (\_ -> return libdir)
getDataDir = catchIO (getEnv "hw3_datadir") (\_ -> return datadir)
getLibexecDir = catchIO (getEnv "hw3_libexecdir") (\_ -> return libexecdir)
getSysconfDir = catchIO (getEnv "hw3_sysconfdir") (\_ -> return sysconfdir)

getDataFileName :: FilePath -> IO FilePath
getDataFileName name = do
  dir <- getDataDir
  return (dir ++ "\\" ++ name)
