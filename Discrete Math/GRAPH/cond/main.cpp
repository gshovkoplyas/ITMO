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

#define taskname "cond"

vector<int> was, ans;
vector<vector<int> > g, r;
int c = 0;
vector<int> color;

void dfs(int v)
{
    was[v] = 1;
    for (int i = 0; i < (int)g[v].size(); i++)
    {
        if (was[g[v][i]] == 0)
            dfs(g[v][i]);
        /*if (was[g[v][i]] == 1)
        {
            printf("-1");
            exit(0);
        }*/
    }
    //was[v] = 2;
    ans.push_back(v);
}

void dfs2(int v)
{
    color[v] = c;
    for (int i = 0; i < (int)r[v].size(); i++)
    {
        if (color[r[v][i]] == 0)
            dfs2(r[v][i]);
    }
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n, m;
    scanf("%d%d", &n, &m);
    g.resize(n);
    r.resize(n);
    for (int i = 0; i < m; i++)
    {
        int a, b; 
        scanf("%d%d", &a, &b);
        a--;
        b--;
        g[a].push_back(b);
        r[b].push_back(a);
    }
    was.assign(n, 0);
    for (int i = 0; i < n; i++)
        if (was[i] == 0)
            dfs(i);
    color.assign(n, 0);
    reverse(ans.begin(), ans.end());
    for (int i = 0; i < n; i++)
    {
        int v = ans[i];
        if (color[v] == 0)
            c++, dfs2(v);
    }
    printf("%d\n", c);
    for (int i = 0; i < n; i++)
        printf("%d ", color[i]);  
    return 0;           
}