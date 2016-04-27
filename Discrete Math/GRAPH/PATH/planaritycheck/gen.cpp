#include<string>
#include<iostream>
#include<cstdio>
using namespace std;

int main() 
{
    int n = 1 << 15;
    string s = "";
    freopen("planaritycheck.in", "w", stdout);
    cout << n - 1 << endl;
    for (int i = 0; i < n; i++)
    {
        s = "";
        int k = i;
        for (int j = 0; j < 15; j++)
            s += k % 2 + '0', k /= 2;
        cout << s << endl;
    } 
    return 0;
}