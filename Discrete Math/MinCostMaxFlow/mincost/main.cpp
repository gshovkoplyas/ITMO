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

#define taskname "mincost"

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

int n, m;
vector<vector<edge> > g;


void add_edge(int a, int b, int capacity, int money)
{
    a--;
    b--;
    int s1 = g[a].size();
    int s2 = g[b].size();
    g[a].push_back(edge(b, money, capacity, 0, s2));
    g[b].push_back(edge(a, -money, 0, 0, s1));
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    cin >> n >> m;
    g.resize(n);
    for (int i = 0; i < m; i++)
    {
        int a, b, c, d;
        cin >> a >> b >> c >> d;
        add_edge(a, b, c, d);
    }
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
    return 0;
}