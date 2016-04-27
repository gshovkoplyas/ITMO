@echo off
for /d %%i in (..\problems\*) do (
    if exist ..\problems\%%i\statement\pics\r.bat (
        pushd ..\problems\%%i\statement\pics
        if exist buildPics.cmd call buildPics.cmd
        if exist r.bat call r.bat
        popd
    )
)

for %%i in (*.tex) do (
latex %%~ni.tex
dvips %%~ni.dvi
dvipdfmx -p a4 %%~ni.dvi
)
for %%i in (*.tex) do (
latex %%~ni.tex
dvips %%~ni.dvi
dvipdfmx -p a4 %%~ni.dvi
)

pdflatex code_rules_cpp.tex
