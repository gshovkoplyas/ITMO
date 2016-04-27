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

#define taskname "points"

vector<int> tin, up, was;
int t = 0;
vector<vector<int> > g;
vector<int> is_point;

void dfs(int v, int prev)
{
    was[v] = 1;
    tin[v] = up[v] = ++t;
    int cnt = 0;
    for (int i = 0; i < (int)g[v].size(); i++)
    {
        int u = g[v][i];
        if (u == prev)
            continue;
        if (was[u])
            up[v] = min(up[v], tin[u]);
        else
        {
            cnt++;
            dfs(u, v);
            up[v] = min(up[v], up[u]);
            if (up[u] >= tin[v] && prev != -1)
                is_point[v] = 1;
        }
    }
    if (prev == -1 && cnt > 1)
        is_point[v] = 1;
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n, m;
    scanf("%d%d", &n, &m);
    g.resize(n);
    for (int i = 0; i < m; i++)
    {
        int a, b; 
        scanf("%d%d", &a, &b);
        a--;
        b--;
        g[a].push_back(b);
        g[b].push_back(a);
    }
    was.assign(n, 0);
    is_point.assign(n, 0);
    up.assign(n, 0);
    tin.assign(n, 0);
    for (int v = 0; v < n; v++)
        if (!was[v])
            dfs(v, -1);
    vector<int> ans;
    for (int i = 0; i < n; i++)
        if (is_point[i])
            ans.push_back(i);
    printf("%d\n", (int)ans.size());
    for (int i = 0; i < (int)ans.size(); i++)
        printf("%d\n", ans[i] + 1);  
    return 0;           
}