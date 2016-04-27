/*Grigory Shovkoplyas in the house*/
#include<cstdio>
#include<iostream>
#include<algorithm>
#include<cmath>
#include<cstring>
#include<string>
#include<vector>
#include<map>
#include<set>
#include<cstdlib>
#include<ctime>
using namespace std;

#define taskname "search2"

vector<int> z_function(string s)
{
    vector<int> z(s.size(), 0);
    int l = 0, r = 0;
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
    string a, b;
    cin >> a >> b;
    string c = a + "#" + b;
    vector<int> z = z_function(c);
    int n = a.size();
    int m = c.size();
    vector<int> ans;
    for (int i = n + 1; i < m; i++)
        if (z[i] == n)
            ans.push_back(i - n);
    cout << ans.size() << endl;
    for (int i = 0; i < (int)ans.size(); i++)
        cout << ans[i] << ' ';
    cout << endl;
    return 0;
}