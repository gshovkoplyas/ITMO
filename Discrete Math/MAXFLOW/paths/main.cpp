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

#define taskname "paths"

int n, m, k;
vector<vector<int> > g;
vector<bool> was;
vector<int> match;

bool dfs(int v) 
{
    if (was[v])
        return false;
    was[v] = true;
    for (int i = 0; i < (int)g[v].size(); i++)
    {
        int u = g[v][i];
        if (match[u] == -1 || dfs(match[u]))
        {
            match[u] = v;
            return true;
        }
    }
    return false;
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    scanf("%d%d", &n, &m);
    g.resize(n + n);
    for (int i = 0; i < m; i++)
    {
        int a, b;
        scanf("%d%d", &a, &b);
        a--;
        b--;
        g[a].push_back(b + n);
    }
    match.assign(n + n, -1);
    for (int i = 0; i < n; i++)
    {
        was.assign(n, false);
        dfs(i);
    }
    int ans = 0;
    for (int i = n; i < 2 * n; i++)
        if (match[i] != -1)
            ans++;
    printf("%d\n", n - ans);
    return 0;           
}