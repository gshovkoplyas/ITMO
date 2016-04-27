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

#define taskname "minimax"

int n;
vector<vector<int> > g;
vector<bool> was;
vector<int> match;

bool dfs(int v, int minw) 
{
    if (was[v])
        return false;
    was[v] = true;
    for (int u = 0; u < n; u++)
    {
        if (g[v][u] < minw)
            continue;
        if (match[u] == -1 || dfs(match[u], minw))
        {
            match[u] = v;
            return true;
        }
    }
    return false;
}

int cuhn(int minw)
{
    match.assign(n, -1);
    for (int i = 0; i < n; i++)
    {
        was.assign(n, false);
        dfs(i, minw);
    }
    int ans = 0;
    for (int i = 0; i < n; i++)
        if (match[i] != -1)
            ans++;
    return ans;
}


int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    scanf("%d", &n);
    g.assign(n, vector<int>(n));
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            scanf("%d", &g[i][j]);
    int r = (int)1e9;
    int l = -r;
    while (l < r - 1)
    {
        int m = (l + r) / 2;
        if (cuhn(m) == n)
            l = m;
        else
            r = m;
    }
    printf("%d\n", l);
    return 0;           
}