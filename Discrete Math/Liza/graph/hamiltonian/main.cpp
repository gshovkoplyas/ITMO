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

#define taskname "hamiltonian"

vector<int> was, ans;
vector<vector<int> > g;

void dfs(int v)
{
    was[v] = 1;
    for (int i = 0; i < (int)g[v].size(); i++)
    {
        if (was[g[v][i]] == 0)
            dfs(g[v][i]);
        if (was[g[v][i]] == 1)
        {
            printf("-1");
            exit(0);
        }
    }
    was[v] = 2;
    ans.push_back(v);
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n, m;
    scanf("%d%d", &n, &m);
    g.resize(n);
    map<pair<int, int>, bool> e;
    for (int i = 0; i < m; i++)
    {
        int a, b; 
        scanf("%d%d", &a, &b);
        a--;
        b--;
        g[a].push_back(b);
        e[make_pair(a, b)] = true;
    }
    was.assign(n, 0);
    for (int i = 0; i < n; i++)
        if (was[i] == 0)
            dfs(i);
    int cnt = 0;
    for (int i = n - 1; i > 0; i--)
        if (!e[make_pair(ans[i], ans[i - 1])])
            cnt++;
    if (!e[make_pair(ans[0], ans[n - 1])])
        cnt++;
    if (cnt < 2)
        printf("YES\n");
    else
        printf("NO\n");
    return 0;           
}