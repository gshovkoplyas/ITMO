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

#define taskname "bicone"

map<pair<int, int>, int> e;
map<pair<int, int>, bool> br;
vector<int> tin, up, was;
int t = 0;
vector<vector<int> > g;
vector<int> ans;
vector<int> color;
int c = 0;


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
            {
                ans.push_back(e[make_pair(v, u)]);
                br[make_pair(v, u)] = br[make_pair(u, v)] = true;
            }
        }
    }
}

void dfs2(int v) 
{
    color[v] = c;
    for (int i = 0; i < (int)g[v].size(); i++)
    {
        int u = g[v][i];
        if (!br[make_pair(u, v)] && !color[u])
            dfs2(u);
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
    color.assign(n, 0);
    for (int i = 0; i < n; i++)
        if (!color[i])
            c++, dfs2(i);
    printf("%d\n", c);
    for (int i = 0; i < n; i++)
        printf("%d ", color[i]);
    return 0;           
}