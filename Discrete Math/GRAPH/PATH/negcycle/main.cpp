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

#define taskname "negcycle"

const int NO_EDGE = (int)1e9;
const long long INF = (long long)1e18; 

struct edge
{
    int from, to, weight;
    edge(){}
    edge(int a, int b, int c): from(a), to(b), weight(c) {}
};

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n;
    scanf("%d", &n);
    vector<edge> e;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
        {
            int q;
            scanf("%d", &q);
            if (q != NO_EDGE)
                e.push_back(edge(i, j, q));
        }
    vector<long long> d(n, 0);
    vector<int> p(n, -1);
    int v = -1;
    for (int i = 0; i < n; i++) 
    {
        v = -1;
        for (int j = 0; j < (int)e.size(); j++)
            if (d[e[j].to] > d[e[j].from] + e[j].weight)
            {
                d[e[j].to] = max(-INF, d[e[j].from] + e[j].weight);
                p[e[j].to] = e[j].from;
                v = e[j].to;
            }
    }
    if (v == -1)
    {
        printf("NO\n");
        return 0;
    }
    int cur = v;
    for (int i = 0; i < n; i++)
        cur = p[cur];
    vector<int> ans;
    int start = cur;
    while (cur != start || ans.size() == 0)
    {
        ans.push_back(cur);
        //cerr << cur << endl;
        cur = p[cur];
    }
    ans.push_back(start);
    reverse(ans.begin(), ans.end());
    printf("YES\n%d\n", (int)ans.size());
    for (int i = 0; i < (int)ans.size(); i++)
        printf("%d ", ans[i] + 1);
    return 0;           
}
                                            