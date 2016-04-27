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

#define taskname "bridges"

map<pair<int, int>, int> e;
vector<int> tin, up, was;
int t = 0;
vector<vector<int> > g;
vector<int> ans;

void dfs(int v, int prev)
{
    was[v] = 1;
    tin[v] = up[v] = ++t;
    for (int i = 0; i < (int)g[v].size(); i++)
    {
        int u = g[v][i];
        if (u == prev)
            continue;
        if (was[u])
            up[v] = min(up[v], tin[u]);
        else
        {
            dfs(u, v);
            up[v] = min(up[v], up[u]);
            if (up[u] > tin[v])
                ans.push_back(e[make_pair(v, u)]);
        }
    }
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
        e[make_pair(a, b)] = e[make_pair(b, a)] = i + 1;
    }
    was.assign(n, 0);
    up.assign(n, 0);
    tin.assign(n, 0);
    for (int v = 0; v < n; v++)
        if (!was[v])
            dfs(v, -1);
    sort(ans.begin(), ans.end());
    ans.resize(unique(ans.begin(), ans.end()) - ans.begin());
    printf("%d\n", (int)ans.size());
    for (int i = 0; i < (int)ans.size(); i++)
        printf("%d\n", ans[i]);  
    return 0;           
}