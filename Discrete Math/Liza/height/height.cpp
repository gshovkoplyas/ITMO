
#include<cstdio>
#include<iostream>
using namespace std;

const int MAXN = 200005;
int value[MAXN], left_kid[MAXN], right_kid[MAXN];

int max(int a, int b)
{
    if (a > b)
        return a;
    return b;
}

int height(int v)
{
    if (v == -1)
        return 0;
    return max(height(right_kid[v]), height(left_kid[v])) + 1;        
}

int main()
{
    freopen("height.in", "r", stdin);
    freopen("height.out", "w", stdout);
    int n;
    scanf("%d", &n);
    if (n == 0)
    {
        printf("0\n");
        return 0;
    }
    for (int i = 0; i < n; i++)
    {
        scanf("%d%d%d", &value[i], &left_kid[i], &right_kid[i]);
        left_kid[i]--;
        right_kid[i]--;
    }
    printf("%d\n", height(0));
    return 0;
}