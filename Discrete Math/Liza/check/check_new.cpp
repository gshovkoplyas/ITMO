#include<cstdio>
#include<algorithm>
#include<iostream>
using namespace std;

const int MAXN = 200005;
const int INF = (int)1e9 + 7;
int value[MAXN], left_kid[MAXN], right_kid[MAXN];

bool check(int v, int a, int b)
{
    bool is_ok = (value[v] > a && value[v] < b);
    if (right_kid[v] != -1)
        is_ok &= check(right_kid[v], value[v], b);
    if (left_kid[v] != -1)
        is_ok &= check(left_kid[v], a, value[v]);
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
    }
    if (check(0, -INF, INF))
        printf("YES\n");
    else
        printf("NO\n");
    return 0;
}