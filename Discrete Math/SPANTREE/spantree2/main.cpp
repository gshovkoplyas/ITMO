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

#define taskname "spantree2"

#define find tratata
#define union blablabla

struct edge 
{
    int a, b, c;
    edge(){}
    edge(int x, int y, int z): a(x), b(y), c(z) {}
};

bool cmp(edge x, edge y)
{
    return x.c < y.c;
}

vector<int> size, parent;

int find(int x)
{
    if(x == parent[x])
        return x;
    parent[x] = find(parent[x]);
    return parent[x];
}

void union(int x, int y)
{
    x = find(x);
    y = find(y);
    if(x != y)
    {
        if(size[x] < size[y])
        swap(x, y);
        size[x] += size[y];
        parent[y] = x;
    }
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n, m;
    scanf("%i%i", &n, &m);
    vector<edge> e(m);
    for (int i = 0; i < m; i++)
    {
        int a, b, c;
        scanf("%i%i%i", &a, &b, &c);
        e[i] = edge(a - 1, b - 1, c);
    }
    size.assign(n, 0);
    parent.assign(n, 0);
    for (int i = 0; i < n; i++)
        parent[i] = i;
    long long ans = 0;
    sort(e.begin(), e.end(), cmp);
    for (int i = 0; i < m; i++)
    {
        if (find(e[i].a) != find(e[i].b))
        {
            ans += e[i].c;
            union(e[i].a, e[i].b);
        }
    }
    cout << ans << endl;
    return 0;           
}