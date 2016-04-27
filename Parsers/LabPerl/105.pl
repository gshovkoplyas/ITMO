while (<>) {
    print if /[x-z]\w{5,17}[x-z]/ ;
}
