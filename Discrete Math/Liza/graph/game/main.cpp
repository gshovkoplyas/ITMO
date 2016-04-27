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

#define taskname "game"

vector<int> was, bad;
vector<vector<int> > g;

void dfs(int v)
{
    was[v] = 1;
    bool is_bad = true;
    for (int i = 0; i < (int)g[v].size(); i++)
    {
        if (was[g[v][i]] == 0)
            dfs(g[v][i]);
        if (bad[g[v][i]])
            is_bad = false;
    }
    bad[v] = is_bad;
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n, m, s;
    scanf("%d%d%d", &n, &m, &s);
    s--;
    g.resize(n);
    for (int i = 0; i < m; i++)
    {
        int a, b; 
        scanf("%d%d", &a, &b);
        a--;
        b--;
        g[a].push_back(b);
    }
    was.assign(n, 0);
    bad.assign(n, 0);
    for (int i = 0; i < n; i++)
        if (!was[i])
            dfs(i);
    if (!bad[s])
        printf("First");
    else
        printf("Second");
    printf(" player wins\n");
    return 0;           
}