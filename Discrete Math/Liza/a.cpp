#include<cstdio>
using namespace std;

int main()
{
    freopen("radixsort.in", "r", stdin);
    freopen("radixsort.out", "w", stdout);
    int n, m, k;
    scanf("%i%i%i", &n, &m, &k);
    char s[1005][1005];
    char t[1005][1005];
    int c[30];
    for (int i = 0; i < n; i++)
        scanf("%s", s[i]);
    for (int q = 0; q < k; q++)
    {
        int i = m - q - 1;
        for (int j = 0; j < 30; j++)
            c[j] = 0;
        for (int j = 0; j < n; j++)
            c[s[j][i] - 'a']++;
        int cnt = 0;
        for (int j = 0; j < 30; j++)
        {
            int tmp = c[j];
            c[j] = cnt;
            cnt += tmp; 
        }
        for (int j = 0; j < n; j++)
        {
            int ind = s[j][i] - 'a';
            for (int k = 0; k < m; k++)
                t[c[ind]][k] = s[j][k];
            c[ind]++;
        }
        for (int j = 0; j < n; j++)
            for (int k = 0; k < m; k++)
                s[j][k] = t[j][k];
    }
    for (int i = 0; i < n; i++)
        printf("%s\n", s[i]);
    return 0;
}