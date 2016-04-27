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

#define taskname "destroy"

struct edge 
{
    int a, b, id;
    long long c;
    edge(){}
    edge(int x, int y, long long z, int o)        
    {
        a = x;
        b = y;
        c = z;
        id = o;
    }
};

bool cmp(edge x, edge y)
{
    return x.c > y.c;
}

vector<int> par, siz;

int get(int x)
{
    if (par[x] != x)
        par[x] = get(par[x]);
    return par[x];
}

void join(int x, int y)
{
    x = get(x);
    y = get(y);
    if (x == y)
        return;
    if (siz[x] > siz[y])
        swap(x, y);
    siz[y] += siz[x];
    par[x] = y;
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n, m;
    unsigned long long s;
    cin >> n >> m >> s;
    vector<edge> e(m);
    for (int i = 0; i < m; i++)
    {
        int a, b;
        long long c;
        cin >> a >> b >> c;
        e[i] = edge(a - 1, b - 1, c, i);
    }
    siz.assign(n, 0);
    par.assign(n, 0);
    for (int i = 0; i < n; i++)
        par[i] = i;
    vector<bool> in_tree(m, false);
    sort(e.begin(), e.end(), cmp);
    for (int i = 0; i < m; i++)
    {
        if (get(e[i].a) != get(e[i].b))
        {
            join(e[i].a, e[i].b);
            in_tree[e[i].id] = true;
            //cerr << e[i].id << endl;
        }
    }
    unsigned long long cur_sum = 0;
    vector<int> to_del;
    reverse(e.begin(), e.end());
    for (int i = 0; i < m && cur_sum <= s; i++)
        if (!in_tree[e[i].id])
        {
            cur_sum += e[i].c;
            if (cur_sum <= s)
                to_del.push_back(e[i].id);
        }
    sort(to_del.begin(), to_del.end());
    printf("%d\n", (int)to_del.size());
    for (int i = 0; i < (int)to_del.size(); i++)
        printf("%d ", to_del[i] + 1);
    return 0;
}