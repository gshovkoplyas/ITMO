#include<bits\stdc++.h>
using namespace std;

int main()
{
    freopen("mirror.out", "w", stdout);
    cout << "start: s\n"
            "accept: ac\n"
            "reject: rj\n"
            "blank: _\n"
            "s 0 -> s 0 >\n"
            "s 1 -> s 1 >\n"
            "s _ -> go _ <\n"
            
            "s _ -> ac _ ^\n"
            "s 0 -> n _ >\n"
            "n 0 -> s _ >\n"
            "n _ -> rj _ >\n";
    return 0;
}