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

#define taskname "binsearch"

int my_lower_bound(vector<int> a, int x)
{
    int l = -1, r = a.size();
    while (r > l + 1)
    {
        int m = (l + r) / 2;
        if (x <= a[m])
            r = m;
        else
            l = m;
    }
    if (r == (int)a.size() || a[r] != x)
      return -1;
    return r;
}

int my_upper_bound(vector<int> a, int x)
{
    int l = -1, r = a.size();
    while (r > l + 1)
    {
        int m = (l + r) / 2;
        if (x < a[m])
            r = m;
        else
            l = m;
    }
    return r - 1;
}

int main()
{
    //freopen(taskname".in", "r", stdin);
    //freopen(taskname".out", "w", stdout);
    int n, m;
    cin >> n >> m;
    vector<int> a(n);
    for (int i = 0; i < n; i++)
      cin >> a[i];
    for (int i = 0; i < m; i++)
    {
        int request;
        cin >> request;
        int l = my_lower_bound(a, request);
        int u = my_upper_bound(a, request);
        if (l == -1)
            cout << "0\n";
        else   
            cout << l + 1 << ' ' << u + 1<< endl;
    }
    return 0;
}

