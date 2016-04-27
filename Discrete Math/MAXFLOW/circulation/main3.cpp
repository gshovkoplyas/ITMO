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

#define taskname "circulation"

const int INF = (int)2e9;

struct edge
{
    int a, b, c, f, x;
    edge(){}
    edge(int q, int y, int i, int j, int w): a(q), b(y), c(i), f(j), x(w) {}
};

int n, m, s, t;
vector<vector<int> > g;
vector<int> d, str, q;
vector<edge> e;

void add_edge(int a, int b, int c, int x)
{
    a--;
    b--;
    g[a].push_back(e.size());
    g[b].push_back(e.size() + 1);
    e.push_back(edge(a, b, c, 0, x));
    e.push_back(edge(b, a, 0, 0, -1));
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
    s = n;
    t = n + 1;
    n += 2;
    g.resize(n);
    q.assign(n, 0);
    vector<int> mc(m);
    for (int i = 0; i < m; i++)
    {
        int a, b, l, r;
        scanf("%d%d%d%d", &a, &b, &l, &r);
        if (l != 0)
        {
            add_edge(s + 1, b, l, -1);
            add_edge(a, t + 1, l, -1);
        }
        add_edge(a, b, r - l, l);
    }
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
    int sum = 0;
    for (int i = 0; i < (int)g[s].size(); i++)
        sum += e[g[s][i]].c;
    if (sum != ans)
        printf("NO\n");
    else
    {
        printf("YES\n");
        for (int i = 0; i < (int)e.size(); i++)
            if (e[i].x != -1)
                printf("%d\n", e[i].f + e[i].x);
    }
    //printf("%d\n", ans);
    return 0;           
}