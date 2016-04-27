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

#define taskname "chinese"

struct edge 
{
    int a, b, c;
    edge(){}
    edge(int x, int y, int z): a(x), b(y), c(z) {}
};

bool operator < (const edge &a, const edge &b)
{
    if (a.c == b.c)
    {
        if (a.a == b.a)
            return a.b < b.b;
        return a.a < b.a;
    }
    return a.c < b.c;
}

vector<vector<int> > vertex_list(int n, vector<edge> &e)
{
    vector<vector<int> > res(n);
    for (int i = 0; i < (int)e.size(); i++)
        res[e[i].a].push_back(e[i].b);
    return res;
}

vector<vector<int> > vertex_list_reversed(int n, vector<edge> &e) 
{
    vector<vector<int> > res(n);
    for (int i = 0; i < (int)e.size(); i++)
        res[e[i].b].push_back(e[i].a);
    return res;
}

void dfs(int v, vector<vector<int> > &g, vector<int> &was)
{
    was[v] = 1;
    for (int i = 0; i < (int)g[v].size(); i++)
        if (!was[g[v][i]])
            dfs(g[v][i], g, was);
}

void dfs_top(int v, vector<vector<int> > &g, vector<int> &was, vector<int> &res)
{
    was[v] = 1;
    for (int i = 0; i < (int)g[v].size(); i++)
        if (!was[g[v][i]])
            dfs_top(g[v][i], g, was, res);
    res.push_back(v);
}

vector<int> top_sort(vector<vector<int> > &g) 
{
    vector<int> res;
    vector<int> was(g.size(), 0);
    for (int v = 0; v < (int)g.size(); v++)
        if (!was[v])
            dfs_top(v, g, was, res);
    reverse(res.begin(), res.end());
    return res;
}

bool is_connected(int v, int n, vector<edge> &e)
{
    vector<int> was(n, 0);
    vector<vector<int> > g = vertex_list(n, e); 
    dfs(v, g, was);
    bool res = true;
    for (int i = 0; i < n; i++)
        if (was[i] == 0)
            res = false;
    return res;
}

void rfs(int v, vector<vector<int> > &g, vector<int> &color, int cur)
{
    color[v] = cur;
    for (int i = 0; i < (int)g[v].size(); i++)
        if (color[g[v][i]] == 0)
            rfs(g[v][i], g, color, cur);
}

vector<int> colore(int n, vector<edge> &e)
{
    vector<vector<int> > g = vertex_list(n, e);
    vector<vector<int> > r = vertex_list_reversed(n, e);
    vector<int> order = top_sort(g);
    vector<int> res(n, 0);
    int cur = 0;
    for (int i = 0; i < n; i++)
        if (res[order[i]] == 0)
        {
            cur++;
            rfs(order[i], r, res, cur);
        }
    return res;
}


long long ans_MST(int v, int n, vector<edge> &e)
{
    long long res = 0;
    vector<int> min_edges(n, (int)2e9 + 7);
    for (int i = 0; i < (int)e.size(); i++)
        min_edges[e[i].b] = min(min_edges[e[i].b], e[i].c);
    for (int i = 0; i < n; i++)
        if (i != v)
            res += min_edges[i];
    //cout << res << endl;
    vector<edge> null_ed;
    for (int i = 0; i < (int)e.size(); i++)
    {    
        e[i].c -= min_edges[e[i].b];
        if (e[i].c == 0)
            null_ed.push_back(e[i]);
    }
    if (is_connected(v, n, null_ed))
        return res;
    vector<int> color = colore(n, null_ed);
    //cout << "fuck" << endl;
    //for (int i = 0; i < (int)null_ed.size(); i++)
        //cout << null_ed[i].a << ' ' << null_ed[i].b << endl;
    int cnt = 0;
    for (int i = 0; i < n; i++)
        cnt = max(cnt, color[i]);//, cout << color[i] << ' ';
    //cout << endl;
    
    vector<edge> ne;
    for (int i = 0; i < (int)e.size(); i++)
        if (color[e[i].a] != color[e[i].b])
            ne.push_back(edge(color[e[i].a] - 1, color[e[i].b] - 1, e[i].c));
    
    //for (int i = 0; i < (int)null_ed.size(); i++)
    //    cout << ne[i].a << ' ' << ne[i].b << ' ' << ne[i].c << endl;
    //cout << endl;
    
    return res + ans_MST(color[v] - 1, cnt, ne);
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n, m;
    scanf("%i%i", &n, &m);
    vector<edge> e;
    for (int i = 0; i < m; i++)
    {
        int a, b, c;
        scanf("%i%i%i", &a, &b, &c);
        a--;
        b--;
        if (a != b)
            e.push_back(edge(a, b, c));
    }
    if (!is_connected(0, n, e))
        printf("NO\n");
    else
        cout << "YES\n" << ans_MST(0, n, e) << endl;
    return 0;           
}