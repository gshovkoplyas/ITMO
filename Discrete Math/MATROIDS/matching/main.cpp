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

#define taskname "matching"

int n;
vector<vector<int> > g;
vector<bool> was;
vector<int> match;

bool dfs(int v) 
{
    if (was[v])
        return false;
    was[v] = true;
    for (int i = 0; i < (int)g[v].size(); i++)
    {
        int u = g[v][i];
        if (match[u] == -1 || dfs(match[u]))
        {
            match[v] = u;
            match[u] = v;
            return true;
        }
    }
    return false;
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    scanf("%d", &n);
    g.resize(2 * n);
    vector<int> w(n);
    for (int i = 0; i < n; i++)
        scanf("%d ", &w[i]);
    vector<int> id(n);
    for (int i = 0; i < n; i++)
        id[i] = i;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n - 1; j++)
            if (w[id[j]] < w[id[j + 1]])
                swap(id[j], id[j + 1]);
    //cerr << 1;
    for (int i = 0; i < n; i++)
    {
        int len;
        scanf("%d", &len);
        for (int j = 0; j < len; j++)
        {
            int b;
            scanf("%d", &b);
            b += n - 1;
            g[i].push_back(b);
            g[b].push_back(i);
        }
    }
    //cerr << 2;
    match.assign(2 * n, -1);
    for (int i = 0; i < n; i++)
    {
        was.assign(n, false);
        dfs(id[i]);
    }
    for (int i = 0; i < n; i++)
        printf("%d ", (match[i] == -1) ? 0 : match[i] - n + 1);
    return 0;           
}