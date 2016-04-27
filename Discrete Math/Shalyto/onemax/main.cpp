#include<bits/stdc++.h>
using namespace std;


int main() 
{
    int n;
    cin >> n;
    string s(n, '0');
    for (int i = 0; i < n; i++)
    {
        int res1, res2;
        cout << s << endl;
        cout.flush();
        cin >> res1;
        if (res1 == n)
            return 0;;
        s[i] = '1';
        cout << s << endl;
        cout.flush();
        cin >> res2;
        if (res2 == n)
            return 0;
        if (res2 < res1)
            s[i] = '0';
    }
    return 0; 
}