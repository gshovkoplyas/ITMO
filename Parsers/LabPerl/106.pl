while (<>) {
    print if /\b[0-9]{1,}(\.[0-9]*)?\b/ ;
}
