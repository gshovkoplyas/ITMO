while (<>) {
    s/(\b\w+\b)([^\w]+)(\b\w+\b)/$3$2$1/ ;   
    print ;
}