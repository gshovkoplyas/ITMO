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
 
#define taskname "rsq"
 
int x;
vector<long long> segment_tree;
 
int step(int n)
{
    int i = 1;
    while (i < n)
        i <<= 1;
    return i;
}
 
void build_tree(vector<long long> a)
{
    int n = a.size();
    x = step(n);
    segment_tree.assign(2 * x, 0);
    for (int i = 0; i < n; i++)
        segment_tree[i + x] = a[i];
    int i = x - 1;
    while (i > 0)
        segment_tree[i] = segment_tree[2 * i] + segment_tree[2 * i + 1], i--;
}
 
void update(int index, long long data)
{
    segment_tree[index + x] = data;
    int v = (index + x) / 2;
    while (v > 0)
        segment_tree[v] = segment_tree[2 * v] + segment_tree[2 * v + 1], v /= 2;
}
 
long long rsq(int v, int l, int r, int a, int b)
{
    if (l > b || r < a)
        return 0;
    if (l >= a && r <= b)
        return segment_tree[v];
    int m = (l + r) / 2;
    return rsq(2 * v, l, m, a, b) + rsq(2 * v + 1, m + 1, r, a, b);
}
 
int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n;
    scanf("%d", &n);
    vector<long long> a(n);
    for (int i = 0; i < n; i++)
        scanf("%I64d", &a[i]);
    build_tree(a);
    char request[10];
    while (scanf("%s", request) > 0)
    {
        if (request[1] == 'u')
        {
            int l, r;
            scanf("%d%d", &l, &r);
            l--, r--;
            printf("%I64d\n", rsq(1, 0, x - 1, l, r));
        }
        else
        {
            int index;
            long long data;
            scanf("%d%I64d", &index, &data);
            index--;
            update(index, data);
        }
    }
    return 0;
}


