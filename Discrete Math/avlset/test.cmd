@echo off
for /L %%i in (1, 1, 100500) do (
  gen.exe
  avlset.exe
  stress.exe
  fc avlset.out stress.out 
  if errorlevel 1 exit
  echo Test %%i: OK
  echo %TIME%
)