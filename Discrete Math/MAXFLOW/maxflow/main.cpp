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

int n, m, s, t;
vector<vector<int> > c, f;
vector<int> d, str, q;

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
        for (int u = 0; u < n; u++)
            if (d[u] == -1 && f[v][u] < c[v][u])
                q[qt++] = u, d[u] = d[v] + 1;
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
    for (int u = str[v]; u < n; u++)
    {
        if (d[u] != d[v] + 1)
            continue;
        int can_push = dfs(u, min(flow, c[v][u] - f[v][u]));
        if (can_push)
        {
            f[u][v] -= can_push;
            f[v][u] += can_push;
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
    f.assign(n, vector<int>(n, 0));
    c.assign(n, vector<int>(n, 0));
    q.assign(n, 0);
    for (int i = 0; i < m; i++)
    {
        int a, b, x;
        scanf("%d%d%d", &a, &b, &x);
        a--;
        b--;
        c[a][b] = x;
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