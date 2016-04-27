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

#define taskname "pathbgep"

const int INF = (int)1e9 + 7;

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n, m;
    scanf("%d%d", &n, &m);
    vector<vector<pair<int, int> > > g(n);
    for (int i = 0; i < m; i++) 
    {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        a--;
        b--;
        g[a].push_back(make_pair(b, c));
        g[b].push_back(make_pair(a, c));
    }
    vector<int> d(n, INF);
    d[0] = 0;
    set<pair<int, int> > s;
    s.insert(make_pair(0, 0));
    while ((int)s.size() != 0) 
    {
        int v = s.begin()->second;
        s.erase(s.begin());
        for (int i = 0; i < (int)g[v].size(); i++)
        {
            int u = g[v][i].first;
            int w = g[v][i].second;
            if (d[u] > d[v] + w)
            {
                s.erase(make_pair(d[u], u));
                d[u] = d[v] + w;
                s.insert(make_pair(d[u], u));
            }
        } 
    }
    for (int i = 0; i < n; i++)
        printf("%d ", d[i]);
    return 0;           
}