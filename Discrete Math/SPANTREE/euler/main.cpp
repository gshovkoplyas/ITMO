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

#define taskname "euler"

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n;
    scanf("%d", &n);
    vector<int> deg(n, 0);
    vector<vector<int> > g(n, vector<int>(n, 0));
    int cnt_odd = 0;
    for (int i = 0; i < n; i++)
    {
        int m;
        scanf("%d", &m);
        deg[i] = m;
        if (m % 2 == 1)
            cnt_odd++;
        for (int j = 0; j < m; j++)
        {
            int a;
            scanf("%d", &a);
            a--;
            g[i][a]++;
        }
    }
    if (cnt_odd > 2)
    {
        printf("-1\n");
        return 0;
    }
    int a = -1, b = -1;
    for (int i = 0; i < n; i++)
        if (deg[i] % 2 == 1)
        {
            if (a == -1)
                a = i;
            else
                b = i;
        }
    if (cnt_odd == 2)
    {
        g[a][b]++;
        g[b][a]++;
    }
    vector<int> stack;
    vector<int> ans;
    int start_vertex = 0;
    while (start_vertex < n && deg[start_vertex] == 0)
        start_vertex++;
    if (start_vertex == n) 
    {
        printf("0\n");
        return 0;
    }
    stack.push_back(start_vertex);
    while ((int)stack.size() > 0) 
    {
        int v = stack[stack.size() - 1];
        int u = 0;
        while (u < n && g[u][v] == 0)
            u++;
        if (u == n)
        {
            ans.push_back(v);
            stack.pop_back();
        }
        else
        {
            g[v][u]--;
            g[u][v]--;
            stack.push_back(u);
        }
    }
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            if (g[i][j] != 0)
            {
                printf("-1\n");
                return 0;
            }
    if (cnt_odd == 2) 
    {
        for (int i = 0; i < (int)ans.size() - 1; i++)
            if ((ans[i] == a && ans[i + 1] == b) || (ans[i] == b && ans[i + 1] == a))
             {
                vector<int> tmp;
                for (int j = i + 1; j < (int)ans.size(); j++)
                    tmp.push_back(ans[j]);
                for (int j = 0; j < i + 1; j++)
                    tmp.push_back(ans[j]);
                ans = tmp;
                break;

             }
    }
    printf("%i\n", (int)ans.size() - 1);
    for (int i = 0; i < (int)ans.size(); i++)
        printf("%i ", ans[i] + 1);
    return 0;           
}