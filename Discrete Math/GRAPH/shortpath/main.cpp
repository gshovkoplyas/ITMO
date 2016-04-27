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

#define taskname "shortpath"

vector<int> was, ans;
vector<vector<pair<int, int> > > g;

void dfs(int v)
{
    was[v] = 1;
    for (int i = 0; i < (int)g[v].size(); i++)
    {
        if (was[g[v][i].first] == 0)
            dfs(g[v][i].first);
    }
    ans.push_back(v);
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n, m, s, t;
    scanf("%d%d%d%d", &n, &m, &s, &t);
    s--;
    t--;
    g.resize(n);
    for (int i = 0; i < m; i++)
    {
        int a, b, c; 
        scanf("%d%d%d", &a, &b, &c);
        a--;
        b--;
        g[a].push_back(make_pair(b, c));
    }
    was.assign(n, 0);
    for (int i = 0; i < n; i++)
        if (was[i] == 0)
            dfs(i);
    reverse(ans.begin(), ans.end());
    vector<int> d(n, (int)1e9 + 7);
    int i = 0;
    while (ans[i] != s)
        i++;
    d[s] = 0;
    for (; i < n; i++)
    {
        int v = ans[i];
        for (int j = 0; j < (int)g[v].size(); j++)
            d[g[v][j].first] = min(d[g[v][j].first], d[v] + g[v][j].second);
    }
    if (d[t] == (int)1e9 + 7)
        printf("Unreachable");
     else
        printf("%d\n", d[t]);
    return 0;           
}