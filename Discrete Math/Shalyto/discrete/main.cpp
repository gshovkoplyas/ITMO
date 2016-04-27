#include<bits/stdc++.h>
using namespace std;

const int ALPH_SIZE = 'z' - 'a' + 1;
const int MAXN = (int)2e4;

char in[MAXN], out[MAXN];

int main() 
{
    freopen("discrete.in", "r", stdin);
    freopen("discrete.out", "w", stdout);
    int n, m;
    scanf("%d%d", &n, &m);
    vector<vector<int>> g(n);
    for (int i = 0; i < n; i++)
    {
        int a, b;
        scanf("%d%d", &a, &b);
        g[i].push_back(a - 1);
        g[i].push_back(b - 1);
    }

    vector<vector<vector<double>>> f(n, vector<vector<double>>(2, vector<double>(ALPH_SIZE, 0)));
    for (int i = 0; i < m; i++)
    {
        int len;
        scanf("%d %s %s", &len, in, out);
        int cur = 0;
        for (int j = 0; j < len; j++) 
        {
            f[cur][in[j] - '0'][out[j] - 'a'] += (double)1 / len;
            cur = g[cur][in[j] - '0'];
            //cerr << cur << ' ';
        }
        //cerr << endl;
    }
    for (int i = 0; i < n; i++)
    {
        int ans0 = 0;
        for (int j = 0; j < ALPH_SIZE; j++)
        {
            //cout << f[i][0][j] << ' ';    
            if (f[i][0][ans0] < f[i][0][j])
                ans0 = j;
        }
        //cout << endl;
        int ans1 = 0;
        for (int j = 0; j < ALPH_SIZE; j++)
        {
            //cout << f[i][1][j] << ' ';    
            if (f[i][1][ans1] < f[i][1][j])
                ans1 = j;
        }
        //cout << endl << endl;
        printf("%c %c\n", ans0 + 'a', ans1 + 'a');        
    }
    return 0;
}