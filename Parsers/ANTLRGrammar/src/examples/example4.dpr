program arrays;
var
  OO0Ol, lO0Ol: array3D;
  O00Ol, l00Ol, Ol0Ol: array[0..3] of array1D;
  ll0Ol, O10Ol, l10Ol, OOlOl: array2D;
  lOlOl, O0lOl, l0lOl, OllOl: integer;

begin
for lOlOl := 1 to 3 do
begin
for O0lOl := 1 to 3 do
for l0lOl := 1 to 3 do
begin
OO0Ol[lOlOl, O0lOl, l0lOl] := lOlOl + O0lOl + l0lOl;
OllOl := l0lOl;
end;

;
end;
;
lO0Ol := O0lOl;
for lOlOl := 1 to 3 do
for O0lOl := 1 to 3 do
O00Ol[lOlOl, O0lOl] := lOlOl * O0lOl

;
Ol0Ol := OllOl;
for lOlOl := 3 downto 1 do
for O0lOl := 3 downto 1 do
begin
for l0lOl := 3 downto 1 do
write(OO0Ol[lOlOl, O0lOl, l0lOl], ' ')
;
writeln;
end;

;
writeln;
for lOlOl := 1 to 3 do
begin
for O0lOl := 1 to 3 do
write(O00Ol[lOlOl, O0lOl], ' ')
;
writeln;
OllOl := ll0Ol;
end;
;
Ol0Ol := Ol0Ol;
end.

