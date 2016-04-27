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

#define taskname "multiassignment"

const long long INF = (long long)1e18;

struct edge
{
    long long to, money, capacity, flow, back;
    edge(){}
    edge(int to1, int money1, int capacity1, int flow1, int back1)
    {
        to = to1;
        money = money1;
        capacity = capacity1;
        flow = flow1;
        back = back1;
    }
}; 

int n, k;
vector<vector<edge> > g;


void add_edge(int a, int b, int capacity, int money)
{
    int s1 = g[a].size();
    int s2 = g[b].size();
    g[a].push_back(edge(b, money, capacity, 0, s2));
    g[b].push_back(edge(a, -money, 0, 0, s1));
}

vector<vector<int> > ng;
vector<vector<bool> > used;
vector<int> was, match;

bool dfs(int v) 
{
    if (was[v])
        return false;
    was[v] = true;
    for (int i = 0; i < (int)ng[v].size(); i++)
    {
        if (used[v][i])
            continue;
        int u = ng[v][i];
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
    cin >> n >> k;
    g.resize(2 * n + 2);
    for (int i = 1; i <= n; i++)
    {
        add_edge(0, i, k, 0);
        add_edge(n + i, 2 * n + 1, k, 0);
    }
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= n; j++)
        {
            int a;
            cin >> a;
            add_edge(i, n + j, 1, a);
        }
    n = 2 * n + 2;
    long long ans = 0;
    while(1)
    {
        vector<long long> p(n), q(n), d(n, INF), s(n, 0), e(n);
        int qt = 0, qh = 0;
        q[qt++] = 0;
        d[0] = 0;
        while (qh != qt)
        {
            int v = q[qh++];
            s[v] = 2;
            qh = qh % n;
            for (int i = 0; i < (int)g[v].size(); i++)
            {
                edge &cur_ed = g[v][i];
                if (cur_ed.flow < cur_ed.capacity && d[v] + cur_ed.money < d[cur_ed.to])
                {
                    d[cur_ed.to] = d[v] + cur_ed.money;
                    if (s[cur_ed.to] == 0)
                    {
                        q[qt++] = cur_ed.to;
                        qt = qt % n;
                    }  
                    else if (s[cur_ed.to] == 2)
                    {
                        qh = (n + qh - 1)  % n;
                        q[qh] = cur_ed.to;
                    }
                    s[cur_ed.to] = 1;
                    p[cur_ed.to] = v;
                    e[cur_ed.to] = i;
                }
            }
        }
        if (d[n - 1] == INF)
            break;
        long long flow = INF;
        for (int i = n - 1; i != 0; i = p[i])
            flow = min(flow, g[p[i]][e[i]].capacity - g[p[i]][e[i]].flow);
        for (int i = n - 1; i != 0; i = p[i])
        {
            g[p[i]][e[i]].flow += flow;
            g[i][g[p[i]][e[i]].back].flow -= flow;
            ans += g[p[i]][e[i]].money * flow; 
        }
    }
    cout << ans << endl;
    int nn = n / 2 - 1;
    ng.resize(nn);
    for (int i = 1; i <= nn; i++)
        for (int j = 0; j < (int)g[i].size(); j++)
            if (g[i][j].flow > 0 && g[i][j].to > nn && g[i][j].to <= 2 * nn)
                ng[i - 1].push_back(g[i][j].to - nn - 1);
    used.resize(nn);
    for (int i = 0; i < nn; i++)
        used[i].assign(ng[i].size(), false);
    for (int q = 0; q < k; q++)
    {
        match.assign(nn, -1);
        for (int i = 0; i < nn; i++)
        {
            was.assign(nn, 0);
            dfs(i);
        }
        vector<int> ans(nn);
        for (int i = 0; i < nn; i++)
        {
            int v = match[i];
            for (int j = 0; j < (int)ng[i].size(); j++)
                if (ng[v][j] == i)
                    used[v][j] = true;
            ans[v] = i + 1;
        }
        for (int i = 0; i < nn; i++)
            cout << ans[i] << ' ';
        cout << endl;    
    }
    return 0;
}