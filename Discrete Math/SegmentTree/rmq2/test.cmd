@echo off
for /L %%i in (1, 1, 100500) do (
  gen.exe
  rmq2.exe
  stress.exe
  fc rmq2.out stress.out 
  if errorlevel 1 exit
  echo Test %%i: OK
  echo %TIME%
)