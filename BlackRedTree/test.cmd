@echo off
for /L %%i in (1, 1, 100500) do (
  gen.exe
  stress.exe
  java Main
  fc stress.out bst.out || exit
  echo Test %%i: OK
)
