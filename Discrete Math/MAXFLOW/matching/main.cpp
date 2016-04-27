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

#define taskname "matching"

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
    scanf("%d%d%d", &n, &m, &k);
    g.resize(n + m);
    for (int i = 0; i < k; i++)
    {
        int a, b;
        scanf("%d%d", &a, &b);
        a--;
        b--;
        b += n;
        g[a].push_back(b);
        g[b].push_back(a);
    }
    match.assign(n + m, -1);
    for (int i = 0; i < n; i++)
    {
        was.assign(n, false);
        dfs(i);
    }
    int ans = 0;
    for (int i = n; i < n + m; i++)
        if (match[i] != -1)
            ans++;
    printf("%d\n", ans);
    return 0;           
}