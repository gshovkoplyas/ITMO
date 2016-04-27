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

#define taskname "spantree"

double len(pair<int, int> a, pair<int, int> b)
{
    double q = a.first - b.first;
    double w = a.second - b.second;
    return sqrt(q * q + w * w);
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n;
    cin >> n;
    vector<pair<int, int> > points(n);
    for (int i = 0; i < n; i++)
        cin >> points[i].first >> points[i].second;
    vector<vector<double> > g(n, vector<double>(n, 0));
    for (int i = 0; i < n; i++)
        for (int j = i + 1; j < n; j++)
            g[i][j] = g[j][i] = len(points[i], points[j]);
    vector<double> key(n, 1e30);
    vector<int> prev(n, -1);
    vector<bool> in_ans(n, 0);
    key[0] = 0;
    double ans = 0;
    for (int i = 0; i < n; i++)
    {
        int v = -1;
        for (int u = 0; u < n; u++)
            if(!in_ans[u] && (v == -1 || key[v] > key[u]))
                v = u;
        in_ans[v] = true;
        if (prev[v] != -1)
            ans += g[v][prev[v]];
        for (int u = 0; u < n; u++)
            if (g[v][u] < key[u])
            {
                key[u] = g[v][u];
                prev[u] = v;
            }
    }
    printf("%.6lf", ans);
    return 0;           
}