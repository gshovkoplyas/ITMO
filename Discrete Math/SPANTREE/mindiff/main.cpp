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

#define taskname "mindiff"

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
    if (n == 1 && m == 0)
    {
        cout << "YES\n0\n" << endl;
        return 0;
    }
    vector<edge> e(m);
    for (int i = 0; i < m; i++)
    {
        int a, b, c;
        scanf("%i%i%i", &a, &b, &c);
        e[i] = edge(a - 1, b - 1, c);
    }
    int k = 0;
    size.assign(n, 1);
    parent.assign(n, 0);
    for (int i = 0; i < n; i++)
        parent[i] = i;
    sort(e.begin(), e.end(), cmp);
    int maxx = (int)(-2e9 - 7);
    for (int i = 0; i < m; i++)
    {
        if (find(e[i].a) != find(e[i].b))
        {
            union(e[i].a, e[i].b);
            k++;
            maxx = max(maxx, e[i].c);
        }
    }
    if (k != n - 1)
    {
        cout << "NO" << endl;
        return 0;
    }
    cout << "YES" << endl;
    long long diff = maxx - e[0].c;
    for (int q = 0; q < m; q++)
    {
        size.assign(n, 1);
        parent.assign(n, 0);
        for (int i = 0; i < n; i++)
            parent[i] = i;
        int k = 0;
        int maxx = (int)(-2e9 - 7);
        for (int i = q; i < m; i++)
        {
            if (find(e[i].a) != find(e[i].b))
            {
                union(e[i].a, e[i].b);
                k++;
                maxx = max(maxx, e[i].c);
            }
        }
        if (k == n - 1 && maxx - e[q].c < diff)
            diff = maxx - e[q].c;

    }
    cout << diff << endl;
    return 0;           
}