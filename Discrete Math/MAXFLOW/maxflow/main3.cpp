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
#include<queue>
using namespace std;

#define taskname "maxflow"

const int INF = (int)1e9;

struct edge
{
    int a, b, c, f;
    edge(){}
    edge(int x, int y, int i, int j): a(x), b(y), c(i), f(j) {}
};

int n, m, s, t;
vector<vector<int> > g;
vector<int> d, str, q;
vector<edge> e;

void add_edge(int a, int b, int c)
{
    a--;
    b--;
    g[a].push_back(e.size());
    g[b].push_back(e.size() + 1);
    e.push_back(edge(a, b, c, 0));
    e.push_back(edge(b, a, 0, 0));
}

bool bfs() 
{
    int qh = 0;
    int qt = 0;
    d.assign(n, -1);
    d[s] = 0;
    q[qt++] = s;
    while (qh < qt)
    {
        int v = q[qh++];
        for (int i = 0; i < (int)g[v].size(); i++)
        {
            int ind = g[v][i];
            int u = e[ind].b;
            if (d[u] == -1 && e[ind].f < e[ind].c)
                q[qt++] = u, d[u] = d[v] + 1;
        }
    }    
    //for (int i = 0; i < n; i++)
    //    cout << d[i] << ' ';
    //cout << endl;
    return d[t] != -1;
}

int dfs(int v, int flow)
{
    if (flow == 0)
        return 0;
    if (v == t)
        return flow;
    for (; str[v] < (int)g[v].size(); str[v]++) /*!!!!*/
    {
        int ind = g[v][str[v]];
        int u = e[ind].b;
        if (d[u] != d[v] + 1)
            continue;
        int can_push = dfs(u, min(flow, e[ind].c - e[ind].f));
        if (can_push)
        {
            e[ind].f += can_push;
            e[ind ^ 1].f -= can_push;
            return can_push;
        }
    }
    return 0;
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    scanf("%d%d", &n, &m);
    g.resize(n);
    q.assign(n, 0);
    for (int i = 0; i < m; i++)
    {
        int a, b, x;
        scanf("%d%d%d", &a, &b, &x);
        add_edge(a, b, x);
    }
    s = 0;
    t = n - 1;
    int ans = 0;
    while (bfs()) 
    {
        str.assign(n, 0);
        while (true)
        {
            int can_push = dfs(s, INF);
            if (!can_push)
                break;
            ans += can_push;
        }
    }
    printf("%d\n", ans);
    return 0;           
}