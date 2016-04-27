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

#define taskname "rmq2"

const long long INF = (long long)1e18 + 7; // 1e9

struct element
{
    long long add, set, data;
    bool flag;
    element(){}
    element(int n)
    {
        data = n;
        add = 0;
        flag = false;
        set = INF;
    }
};

int x;
vector<element> segment_tree;

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
    segment_tree.assign(2 * x, element(INF));
    for (int i = 0; i < n; i++)
        segment_tree[i + x] = element(a[i]);
    int i = x - 1;
    while (i > 0)
        segment_tree[i] = element(min(segment_tree[2 * i].data, segment_tree[2 * i + 1].data)), i--;
}

void change_set(int v, long long data)
{
    segment_tree[v].set = data;
    segment_tree[v].add = 0;
    segment_tree[v].flag = true;
}

void change_add(int v, long long data)
{
    if (segment_tree[v].flag)
        segment_tree[v].set += data;
    else
        segment_tree[v].add += data;
}

long long get(int v)
{
    if (segment_tree[v].flag)
        return segment_tree[v].set;
    return segment_tree[v].data + segment_tree[v].add;
}

void push(int v)
{
    segment_tree[v].data = get(v);
    if (segment_tree[v].flag)
    {
        change_set(2 * v, segment_tree[v].set);
        change_set(2 * v + 1, segment_tree[v].set);
        segment_tree[v].flag = false;
    } 
    else if (segment_tree[v].add != 0)
    {
        change_add(2 * v, segment_tree[v].add);
        change_add(2 * v + 1, segment_tree[v].add);
        segment_tree[v].add = 0;
    }
}

void update_set(int v, int l, int r, int a, int b, long long data)
{
    if (l > b || r < a)
        return;
    if (l >= a && r <= b)
    {
        change_set(v, data);
        return;
    }
    push(v);
    int m = (l + r) / 2;
    update_set(2 * v, l, m, a, b, data);
    update_set(2 * v + 1, m + 1, r, a, b, data);
    segment_tree[v].data = min(get(2 * v), get(2 * v + 1));
}

void update_add(int v, int l, int r, int a, int b, long long data)
{
    if (l > b || r < a)
        return;
    if (l >= a && r <= b)
    {
        change_add(v, data);
        return;
    }
    push(v);
    int m = (l + r) / 2;
    update_add(2 * v, l, m, a, b, data);
    update_add(2 * v + 1, m + 1, r, a, b, data);
    segment_tree[v].data = min(get(2 * v), get(2 * v + 1));
}

long long rmq(int v, int l, int r, int a, int b)
{
    if (l > b || r < a)
        return INF;
    if (l >= a && r <= b)
        return get(v);
    push(v);
    int m = (l + r) / 2;
    return min(rmq(2 * v, l, m, a, b), rmq(2 * v + 1, m + 1, r, a, b));
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
    /*for (int i = 1; i < 2 * x; i++)
        cout << segment_tree[i].data << ' ';
    cout << endl;
    for (int i = 1; i < 2 * x; i++)
        cout << segment_tree[i].set << ' ';
    cout << endl;
    for (int i = 1; i < 2 * x; i++)
        cout << segment_tree[i].add << ' ';
    cout << endl << endl;*/
    char request[10];
    while (scanf("%s", request) > 0)
    {
        //printf("%s\n", request);
        if (request[0] == 'm')
        {
            int l, r;
            scanf("%d%d", &l, &r);
            l--, r--;
            printf("%I64d\n", rmq(1, 0, x - 1, l, r));
        }
        else 
        {
            int a, b;
            long long data;
            scanf("%d%d%I64d", &a, &b, &data);
            a--, b--;
            if (request[0] == 'a')
                update_add(1, 0, x - 1, a, b, data);
            else
                update_set(1, 0, x - 1, a, b, data);
        }
        /*for (int i = 1; i < 2 * x; i++)
            cout << segment_tree[i].data << ' ';
        cout << endl;
        for (int i = 1; i < 2 * x; i++)
            cout << segment_tree[i].set << ' ';
        cout << endl;
        for (int i = 1; i < 2 * x; i++)
            cout << segment_tree[i].add << ' ';
        cout << endl << endl;*/

    }
    return 0;
}
