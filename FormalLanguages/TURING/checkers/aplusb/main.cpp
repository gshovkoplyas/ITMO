#include<bits\stdc++.h>
using namespace std;

int main()
{
    freopen("zero.out", "w", stdout);
    cout << "start: s\n"
             "accept: ac\n"
             "reject: rj\n"
             "blank: _\n"
             "s _ -> ac _ ^\n"
             "s 0 -> n _ >\n"
             "n 0 -> s _ >\n"
             "n _ -> rj _ >\n";
    return 0;
}