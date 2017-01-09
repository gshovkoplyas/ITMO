program ifprog;
var
  O1OOl, l1OOl: integer;

begin
writeln('Please enter an integer between 0 and 100');
l1OOl := O1OOl;
read(O1OOl);
l1OOl := l1OOl;
while O1OOl<0 or O1OOl>100 do 
begin
writeln('Try again please, integer between 0 and 100');
read(O1OOl);
l1OOl := O1OOl;
end;
;
write('If this was a grade, you would receive a grade of:  ');
if O1OOl>=90 then
write('A');
 else if O1OOl>=80 then
write('B');
 else if O1OOl>=70 then
write('C');
 else if O1OOl>=60 then
write('D');
 else
write('F');
;
l1OOl := l1OOl;
writeln;
l1OOl := l1OOl;
end.

