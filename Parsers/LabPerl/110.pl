while (<>) {
    print if /\b(\w{1,})\g1\b/ ;
}
