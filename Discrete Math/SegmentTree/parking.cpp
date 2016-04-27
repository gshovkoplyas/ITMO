/*Grigory Shovkoplyas in the house*/
#define _CRT_SECURE_NO_WARNINGS 
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
 
#define taskname "parking"
 
const int INF = (int)1e9 + 7;
 
int x;
vector<pair<int, int> > segment_tree;
 
int step(int n)
{
    int i = 1;
    while (i < n)
        i <<= 1;
    return i;
}
 
void build_tree(int n)
{
    x = step(n);
    segment_tree.resize(2 * x);
    for (int i = 0; i < n; i++)
        segment_tree[i + x] = make_pair(0, i);
    for (int i = n + x; i < 2 * x; i++)
        segment_tree[i] = make_pair(INF, i - x);
    int i = x - 1;
    while (i > 0)
        segment_tree[i] = min(segment_tree[2 * i], segment_tree[2 * i + 1]), i--;
}
 
void update(int index, int data)
{
    segment_tree[index + x].first = data;
    int v = (index + x) / 2;
    while (v > 0)
        segment_tree[v] = min(segment_tree[2 * v], segment_tree[2 * v + 1]), v /= 2;
}
 
pair<int, int> rmq(int v, int l, int r, int a, int b)
{
    if (l > b || r < a)
        return make_pair(INF, INF);
    if (l >= a && r <= b)
        return segment_tree[v];
    int m = (l + r) / 2;
    return min(rmq(2 * v, l, m, a, b), rmq(2 * v + 1, m + 1, r, a, b));
}
 
int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n, m;
    scanf("%d%d", &n, &m);
    build_tree(n);
    char request[10];
    int index;
    for (int i = 0; i < m; i++)
    {
        scanf("%s%d", request, &index);
        index--;
        if (request[1] == 'n')
        {
            pair<int, int> ans = rmq(1, 0, x - 1, index, x - 1);
            if (ans.first != 0)
                ans = rmq(1, 0, x - 1, 0, index);
            update(ans.second, 1);
            printf("%d\n", ans.second + 1);
        }
        else
            update(index, 0);
    }
    return 0;
}

