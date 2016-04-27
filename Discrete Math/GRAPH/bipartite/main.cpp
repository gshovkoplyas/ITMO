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

#define taskname "bipartite"

vector<int> color;
vector<vector<int> > g;

void dfs(int v, int c)
{
    color[v] = c;
    for (int i = 0; i < (int)g[v].size(); i++)
    {
        if (color[g[v][i]] == c)
        {
            printf("NO");
            exit(0);
        }
        if (!color[g[v][i]])
            dfs(g[v][i], -c);
    }
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
        if (a != b) 
        {
            g[a].push_back(b);
            g[b].push_back(a);
        } else {
            printf("NO");
            exit(0);
        }
    }
    for (int i = 0; i < n; i++)
    {
        sort(g[i].begin(), g[i].end());
        vector<int>::iterator it = unique(g[i].begin(), g[i].end());
        g[i].resize(distance(g[i].begin(), it));
    }    
    color.assign(n, 0);
    for (int v = 0; v < n; v++)
        if (color[v] == 0)
            dfs(v, 1);
    printf("YES");
    return 0;           
}