#include <stdio.h>
#include <limits.h>

#define MAXN (110)
#define INF (INT_MAX / 4)

int a[MAXN][MAXN] = {{0}};
int d[MAXN] = {0};
int color[MAXN] = {0};
int N = 0;
int S = 0;
int T = 0;

void dijkstra(int v) {
    for (int i = 0; i < N; i++)
        d[i] = INF;
    d[v] = 0;
    while (1) {
        int cur = -1;
        for (int i = 0; i < N; i++)
            if (!color[i] && (-1 == cur || d[cur] > d[i]))
                cur = i;
        if (-1 == cur)
            break;
        color[cur] = 1;
        for (int i = 0; i < N; i++)
            if (a[cur][i])
                if (-1 == d[i] || d[i] > d[cur] + a[cur][i])
                    d[i] = d[cur] + a[cur][i];
    }
}

int main() {
    freopen("pathmgep.in", "rt", stdin);
    freopen("pathmgep.out", "wt", stdout);

    scanf("%d %d %d", &N, &S, &T);
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++) {
            scanf("%d", &a[i][j]);
            if (-1 == a[i][j])
                a[i][j] = INF;
        }

    dijkstra(S - 1);
    if (INF == d[T - 1])
        printf("-1");
    else
        printf("%d", d[T - 1]);

    return 0;
}
