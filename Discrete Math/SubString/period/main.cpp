/*Grigory Shovkoplyas in the house*/
#include<cstdio>
#include<iostream>
#include<algorithm>
#include<cmath>
#include<cassert>
#include<cstring>
#include<string>
#include<vector>
#include<map>
#include<set>
#include<cstdlib>
#include<ctime>
using namespace std;

#define taskname "period"

vector<int> z_function(string s)
{
    vector<int> z(s.size(), 0);
    int l = 0, r = 0;
    z[0] = s.size();
    for (int i = 1; i < (int)s.size(); i++)
    {
        if (i <= r)
            z[i] = min(r - i + 1, z[i - l]);
        while (z[i] + i < (int)s.size() && s[z[i]] == s[z[i] + i])
            z[i]++;
        if (z[i] + i - 1 > r)
            l = i, r = z[i] + i - 1;    
    }
    return z;
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    string a;
    cin >> a;
    vector<int> z = z_function(a);
    int n = a.size();
    for (int t = 1; t <= n; t++)
    {
        bool isOk = true;
        for (int i = 0; i < n; i += t)
            if (z[i] < t)
                isOk = false;
        if (isOk)
        {
            cout << t << endl;
            return 0;
        }    
    }
    assert(false);
    return 0;
}