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

#define taskname "components"

vector<int> wa;
vector<vector<int> > g;
int c = 0;
vector<int> color;

void dfs(int v)
{
    color[v] = c;
    for (int i = 0; i < (int)g[v].size(); i++)
        if (!color[g[v][i]])
            dfs(g[v][i]);
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n, m;
    scanf("%d%d", &n, &m);
    g.resize(n);
    for (int i = 0; i < m; i++)
    {
        int a, b; 
        scanf("%d%d", &a, &b);
        a--;
        b--;
        g[a].push_back(b);
        g[b].push_back(a);
    }
    color.assign(n, 0);
    for (int v = 0; v < n; v++)
        if (color[v] == 0)
            c++, dfs(v);
    printf("%d\n", c);
    for (int i = 0; i < n; i++)
        printf("%d ", color[i]);  
    return 0;           
}