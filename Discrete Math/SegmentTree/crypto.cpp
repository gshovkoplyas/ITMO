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
 
#define taskname "crypto"
 
int r;
 
struct matrix2x2
{
    int a, b, c, d;
    matrix2x2(){}
    matrix2x2(int aa, int bb, int cc, int dd)
    {
        a = aa % r, b = bb % r, c = cc % r, d = dd % r;
    }
    matrix2x2 operator * (matrix2x2 m)
    {
        int aa = (a * m.a + b * m.c) % r;
        int bb = (a * m.b + b * m.d) % r;
        int cc = (c * m.a + d * m.c) % r;
        int dd = (c * m.b + d * m.d) % r;
        return matrix2x2(aa, bb, cc, dd);
    }
    void read()
    {
        scanf("%d%d%d%d", &a, &b, &c, &d);
        a %= r;
        b %= r;
        c %= r;
        d %= r;
    }
    void print()
    {
        printf("%d %d\n%d %d\n\n", a, b, c, d);
    }
 
};
 
int x;
vector<matrix2x2> segment_tree;
 
int step(int n)
{
    int i = 1;
    while (i < n)
        i <<= 1;
    return i;
}
 
void build_tree(vector<matrix2x2> a)
{
    int n = a.size();
    x = step(n);
    segment_tree.assign(2 * x, matrix2x2(1, 0, 0, 1));
    for (int i = 0; i < n; i++)
        segment_tree[i + x] = a[i];
    int i = x - 1;
    while (i > 0)
        segment_tree[i] = segment_tree[2 * i] * segment_tree[2 * i + 1], i--;
}
 
matrix2x2 rsq(int v, int l, int r, int a, int b)
{
    if (l > b || r < a)
        return matrix2x2(1, 0, 0, 1);
    if (l >= a && r <= b)
        return segment_tree[v];
    int m = (l + r) / 2;
    return rsq(2 * v, l, m, a, b) * rsq(2 * v + 1, m + 1, r, a, b);
}
 
int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n, m;
    scanf("%d%d%d", &r, &n, &m);
    vector<matrix2x2> a(n);
    for (int i = 0; i < n; i++)
        a[i].read();
    build_tree(a);
    for (int i = 0; i < m; i++)
    {
        int l, r;
        scanf("%d%d", &l, &r);
        rsq(1, 0, x - 1, l - 1, r - 1).print();
    }
    return 0;
}

