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

#define taskname "search3"

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
    int n = a.size();
    int m = b.size();
    string ra = a, rb = b;
    reverse(ra.begin(), ra.end());
    reverse(rb.begin(), rb.end());
    string sp = a + "#" + b;
    string sr = ra + "#" + rb;
    vector<int> zp, zr;
    zp = z_function(sp);
    zr = z_function(sr);
    vector<int> ans;
    for (int i = 0; i + n <= m; i++)
    {
        if (zp[i + n + 1] + zr[m + 1 - i] >= n - 1)
            ans.push_back(i + 1);    
    }
    cout << ans.size() << endl;
    for (int i = 0; i < (int)ans.size(); i++)
        cout << ans[i] << ' ';
    cout << endl;
    return 0;
}