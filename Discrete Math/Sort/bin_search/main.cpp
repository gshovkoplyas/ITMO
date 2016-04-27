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

vector<int> a;

int my_lower_bound(int x)
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

int my_upper_bound(int x)
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
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n;
    cin >> n;
    a.resize(n);
    for (int i = 0; i < n; i++)
      cin >> a[i];
    int m;
    cin >> m;
    for (int i = 0; i < m; i++)
    {
        int request;
        cin >> request;
        int l = my_lower_bound(request);
        int u = my_upper_bound(request);
        if (l == -1)
            printf("-1 -1\n");
        else   
            printf("%d %d\n", l + 1, u + 1);
    }
    return 0;
}

