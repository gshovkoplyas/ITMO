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

#define taskname "a"

vector<bool> was;
vector<int> rank;
vector<vector<int> > g;
bool no_problem;
vector<pair<int, int> > ans;

void dfs(int v)
{
    was[v] = true;
    if ((int)g[v].size() == 0)
    {
        rank[v] = 1;
        return;
    }
    vector<pair<int, int> > child;
    for (int i = 0; i < (int)g[v].size(); i++)
    {
        int u = g[v][i];
        dfs(u);
        child.push_back(make_pair(rank[u], u));
    }
    sort(child.begin(), child.end());
    for (int i = 0; i < (int)child.size(); i++)
    {
        int u = child[i].second;
        int cur_rank = child[i].first;
        ans.push_back(make_pair(v, u));
        if ((i == 0 && cur_rank > 1) || (i > 0 && cur_rank - 1 > child[i - 1].second))
            no_problem = false;
    }
    rank[v] = child[child.size() - 1].first + 1;
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n;
    cin >> n;
    g.resize(n);
    for (int i = 0; i < n; i++)
    {
        int a;
        cin >> a;
        a--;
        if (a != i)
            g[a].push_back(i);
    }
    was.assign(n, false);
    rank.assign(n, 0);
    no_problem = true;
    for (int i = 0; i < n; i++)
        if (!was[i])
            dfs(i);
    if (no_problem)
    {
        cout << ans.size() << endl;
        for (int i = 0; i < (int)ans.size(); i++)
        {
            int a = ans[i].first + 1;
            int b = ans[i].second + 1;
            cout << a << ' ' << b << '\n';
        }
    }
    else
        cout << "-1\n";
    return 0;
}
