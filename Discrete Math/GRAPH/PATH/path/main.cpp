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

#define taskname "path"

const long long INF = (long long)6e18; 

struct edge
{
    int from, to;
    long long weight;
    edge(){}
    edge(int a, int b, long long c): from(a), to(b), weight(c) {}
};

int n, m, s;
vector<vector<int> > g;
vector<bool> was;

void dfs(int v)
{
    was[v] = true;
    for (int i = 0; i < (int)g[v].size(); i++)
        if (!was[g[v][i]])
            dfs(g[v][i]);
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    scanf("%d%d%d", &n, &m, &s);
    s--;
    g.resize(n);
    vector<edge> e;
    for (int i = 0; i < m; i++)
    {
        int a, b;
        long long c;
        cin >> a >> b >> c;
        a--, b--;
        g[a].push_back(b);
        e.push_back(edge(a, b, c));
    }
    vector<long long> d(n, INF);
    d[s] = 0;
    vector<int> p(n, -1);
    int v = -1;
    /*for (int i = 0; i < n; i++)
        cout << d[i] << ' ';
    cout << endl;*/
    for (int i = 0; i < n; i++) 
    {
        v = -1;
        for (int j = 0; j < (int)e.size(); j++)
            if (d[e[j].from] < INF && d[e[j].to] > d[e[j].from] + e[j].weight)
            {
                d[e[j].to] = max(-INF, d[e[j].from] + e[j].weight);
                p[e[j].to] = e[j].from;
                v = e[j].to;
            }
    }
    /*for (int i = 0; i < n; i++)
        cout << d[i] << ' ';
    cout << endl;*/
    was.assign(n, false);
    if (v != -1)
    {
        int cur = v;
        for (int i = 0; i < n; i++)
            cur = p[cur];
        dfs(cur);
    }
    cerr << 1;
    for (int i = 0; i < n; i++)
    {
        if (was[i])
            printf("-\n");
        else if (d[i] == INF)
            printf("*\n");
        else
            cout << d[i] << endl;
    }
    return 0;           
}
                                            