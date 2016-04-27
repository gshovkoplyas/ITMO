#include <cstdio>
#include <vector>
#include <deque>
#include <iostream>
using namespace std;

const int MOD = (int)1e9 + 7;
const int INF = (int)2e9;
    
int main()
{
    freopen("problem3.in", "rt", stdin);
    freopen("problem3.out", "wt", stdout);
    int n, m, k;
    cin >> n >> m >> k;
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

    deque<int> q1, was1(n, 0);
    for (int i = 0; i < n; i++)
    {
        if (is_ok[i])
            q1.push_back(i);
    }
    while(!q1.empty()) 
    {
        int v = q1.front();
        q1.pop_front();
        if (was1[v])
            continue;
        was1[v] = true;
        for (int i = 0; i < (int)gr[v].size(); i++) 
        {
            int u = gr[v][i];
            q1.push_back(u);
        }
    }

    vector<int> dp(n, 0);
    vector<int> was(n, 0);
    dp[0] = 1;
    deque<int> q;
    q.push_back(0);
    while (!q.empty()) 
    {
        int v = q.front();
        q.pop_front();
        if (was[v])
            continue;
        was[v] = true;
        for (int i = 0; i < (int)aut[v].size(); i++) 
        {
            int u = aut[v][i];
            if (u == -1)
                continue;
            if (was[u])
            {
                if (was1[u])
                {
                    cout << -1 << endl;
                    return 0;
                }
                else
                    continue;
            } 
            dp[u] = (dp[u] + dp[v]) % MOD;
            q.push_back(u);
        }
    }
    int ans = 0;
    for (int i = 0; i < n; i++)
        if (is_ok[i])
            ans = (ans + dp[i]) % MOD;
    cout << ans << endl;
    return 0;
}