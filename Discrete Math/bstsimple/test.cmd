@echo off
for /L %%i in (1, 1, 100500) do (
  gen.exe
  main.exe
  stress.exe
  fc bstsimple.out stress.out 
  if errorlevel 1 exit
  echo Test %%i: OK
  echo %TIME%
)