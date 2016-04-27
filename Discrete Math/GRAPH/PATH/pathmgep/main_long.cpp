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

#define taskname "pathmgep"

const long long INF = (long long)1e18 + 7;

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n, st, t;
    scanf("%d%d%d", &n, &st, &t);
    st--;
    t--;
    vector<vector<pair<int, int> > > g(n);
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
        {
            int w;
            scanf("%d", &w);
            if (i != j && w != -1)
                g[i].push_back(make_pair(j, w));
        }  
    vector<long long> d(n, INF);
    d[st] = 0;
    set<pair<long long, int> > s;
    s.insert(make_pair(0, st));
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
    if (d[t] == INF)
        printf("-1");
    else
        printf("%I64d\n", d[t]);
    return 0;           
}