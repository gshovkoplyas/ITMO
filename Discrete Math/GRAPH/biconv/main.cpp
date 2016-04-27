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

#define taskname "biconv"

vector<int> tin, up, was, color;
int t = 0;
vector<vector<int> > g;
vector<int> is_point;
map<pair<int, int>, int> e;
int col = 1;

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

void dfc(int v, int prev, int c)
{
    was[v] = 1;
    for (int i = 0; i < (int)g[v].size(); i++)
    {
        int u = g[v][i];
        if (u == prev)
            continue;
        if (was[u] == 0)
        {
            if (up[u] >= tin[v])
            {
                int c2 = col++;
                color[e[make_pair(u, v)]] = c2;
                dfc(u, v, c2);
            }
            else
            {
                color[e[make_pair(u, v)]] = c;
                dfc(u, v, c);    
            }
        }
        else if (tin[u] <= tin[v])
            color[e[make_pair(u, v)]] = c;
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
        e[make_pair(a, b)] = e[make_pair(b, a)] = i;
    }
    was.assign(n, 0);
    is_point.assign(n, 0);
    up.assign(n, 0);
    tin.assign(n, 0);
    for (int v = 0; v < n; v++)
        if (!was[v])
            dfs(v, -1);
    color.assign(m, 0);
    was.assign(n, 0);
    for (int i = 0; i < n; i++)
        if (!was[i])
            dfc(i, -1, col);
    printf("%d\n", col - 1);
    for (int i = 0; i < m; i++)
        printf("%d ", color[i]);  
    return 0;           
}