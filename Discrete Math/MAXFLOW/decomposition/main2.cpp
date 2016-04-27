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

#define taskname "decomposition"

const int INF = (int)2e9 + 7;

int n, m, s, t;
vector<vector<int> > c, f, num, ans;
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
    for (int &u = str[v]; u < n; u++)
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

void dfs2(int v, vector<int> &path)
{
    if (v == t)
        return;
    for (int &u = str[v]; u < n; u++)
        if (f[v][u] > 0)
        {
            path.push_back(num[v][u]);
            path[0] = min(path[0], f[v][u]);
            dfs2(u, path);
            int flow = path[0];
            f[v][u] -= flow;
            f[u][v] += flow;
            break;
        }
}


int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    scanf("%d%d", &n, &m);
    f.assign(n, vector<int>(n, 0));
    c.assign(n, vector<int>(n, 0));
    num.assign(n, vector<int>(n, -1));
    q.assign(n, 0);
    for (int i = 0; i < m; i++)
    {
        int a, b, x;
        scanf("%d%d%d", &a, &b, &x);
        a--;
        b--;
        c[a][b] = x;
        num[a][b] = i;
    }
    s = 0;
    t = n - 1;
    while (bfs()) 
    {
        str.assign(n, 0);
        while (true)
        {
            int can_push = dfs(s, INF);
            if (!can_push)
                break;
        }
    }
    str.assign(n, 0);
    while (true)
    {
        vector<int> path(1, INF);
        dfs2(s, path);
        if (path[0] == INF)
            break;
        ans.push_back(path);
    }
    printf("%d\n", (int)ans.size());
    for (int i = 0; i < (int)ans.size(); i++)
    {
        printf("%d %d ", ans[i][0], (int)ans[i].size() - 1);
        for (int j = 1; j < (int)ans[i].size(); j++)
            printf("%d ", ans[i][j] + 1);
        printf("\n");
    }
    return 0;           
}