$input = "";
while ($string = <>) {
    $string =~ s/^\s+//;        #spaces in the beginning
    $string =~ s/\s{2,}/\s/g;   #two or more spaces 
    $string =~ s/\s+\n$/\n/;    #spaces in the ending
    
    $input = $input.$string;
}

$input =~ s/^\n+//;             #empty strings in the beginning
$input =~ s/\n+$/\n/;           #empty strings in the ending
$input =~ s/\n{3,}/\n/g;        #two or more empty strings 
print $input;
