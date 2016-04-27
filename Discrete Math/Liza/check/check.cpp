#include<cstdio>
#include<algorithm>
#include<iostream>
using namespace std;

const int MAXN = 200005;
int value[MAXN], left_kid[MAXN], right_kid[MAXN], min_value[MAXN], max_value[MAXN];
bool max_ready[MAXN], min_ready[MAXN];

int min_in_subtree(int v)
{
     if (min_ready[v])
        return min_value[v];
    int res = value[v];
    if (right_kid[v] != -1)
        res = min(res, min_in_subtree(right_kid[v]));
    if (left_kid[v] != -1)
        res = min(res, min_in_subtree(left_kid[v]));
    min_value[v] = res;
    min_ready[v] = true;
    return res;
}

int max_in_subtree(int v)
{
    if (max_ready[v])
        return max_value[v];
    int res = value[v];
    if (right_kid[v] != -1)
        res = max(res, max_in_subtree(right_kid[v]));
    if (left_kid[v] != -1)
        res = max(res, max_in_subtree(left_kid[v]));
    max_value[v] = res;
    max_ready[v] = true;
    return res;
}

bool check(int v)
{
    bool is_ok = true;
    if (right_kid[v] != -1)
        is_ok &= (check(right_kid[v]) && (value[v] < min_in_subtree(right_kid[v])));
    if (left_kid[v] != -1)
        is_ok &= (check(left_kid[v]) && (value[v] > max_in_subtree(left_kid[v])));
    return is_ok;
}

int main()
{
    freopen("check.in", "r", stdin);
    freopen("check.out", "w", stdout);
    int n;
    scanf("%d", &n);
    if (n == 0)
    {
        printf("YES\n");
        return 0;
    }
    for (int i = 0; i < n; i++)
    {
        scanf("%d%d%d", &value[i], &left_kid[i], &right_kid[i]);
        left_kid[i]--;
        right_kid[i]--;
        min_ready[i] = false;
        max_ready[i] = false;
    }
    if (check(0))
        printf("YES\n");
    else
        printf("NO\n");
    return 0;
}