#include <bits/stdc++.h>
using namespace std;

const int MOD = (int)1e9 + 7;
const int INF = (int)2e9;
    
int main()
{
    freopen("problem4.in", "rt", stdin);
    freopen("problem4.out", "wt", stdout);
    int n, m, k, l;
    cin >> n >> m >> k >> l;
    vector<bool> is_ok(n, false);
    for (int i = 0; i < k; i++)
    {
        int tmp;
        cin >> tmp;
        is_ok[tmp - 1] = true;
    }
    vector<vector<int>> aut = vector<vector<int>>(n, vector<int>(30, -1));
    vector<vector<int>> gr(n);
    for (int i = 0; i < m; i++)
    {
        int a, b;
        char c;
        scanf("%d %d %c", &a, &b, &c);
        aut[a - 1][c - 'a'] = b - 1;
        gr[b - 1].push_back(a - 1);
    }

    vector<vector<int>> dp(n, vector<int>(l + 1, 0));
    deque<pair<int, int>> q;
    vector<vector<int>> was(n, vector<int>(l + 1, 0));
    for (int i = 0; i < n; i++)
    {
        if (is_ok[i])
        {
            q.push_back(make_pair(i, 0));
            dp[i][0] = 1;
        }
    }
    while(!q.empty()) 
    {
        int v = q.front().first;
        int w = q.front().second;
        //cerr << v << ' ' << w << ' ' << l << endl;
        q.pop_front();
        if (was[v][w] || w == l)
            continue;
        was[v][w] = 1;
        //cerr << gr[v].size() << endl;
        for (int i = 0; i < (int)gr[v].size(); i++) 
        {
            int u = gr[v][i];
            dp[u][w + 1] = (dp[u][w + 1] + dp[v][w]) % MOD;
            q.push_back(make_pair(u, w + 1));
        }
    }

    cout << dp[0][l] << endl;

    return 0;
}