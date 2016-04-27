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

#define taskname "cycle"

vector<int> was, buf;
vector<vector<int> > g;

void dfs(int v)
{
    was[v] = 1;
    buf.push_back(v);
    for (int i = 0; i < (int)g[v].size(); i++)
    {
        if (was[g[v][i]] == 0)
            dfs(g[v][i]);
        if (was[g[v][i]] == 1)
        {
            printf("YES\n");
            vector<int> ans;
            for (int j = buf.size() - 1; j >= 0; j--)
            {
                ans.push_back(buf[j]);
                if (buf[j] == g[v][i])
                    break;
            }
            reverse(ans.begin(), ans.end());
            for (int j = 0; j < (int)ans.size(); j++)
                printf("%d ", ans[j] + 1);
            exit(0);
        }
    }
    buf.pop_back();
    was[v] = 2;
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
    }
    was.assign(n, 0);
    for (int i = 0; i < n; i++)
        if (was[i] == 0)
            dfs(i);
    printf("NO\n");
    return 0;           
}