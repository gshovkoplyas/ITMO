#include<bits/stdc++.h>
using namespace std;

struct node
{
    int l, r;
    char data;
    void read()
    {
        cin >> l >> r >> data;
        l--;
        r--;
    }
};

int main() 
{
    freopen("start.in", "r", stdin);
    freopen("start.out", "w", stdout);
    int n, m;
    cin >> m >> n;
    vector<node> a(n);
    for (int i = 0; i < n; i++)
        a[i].read();
    vector<vector<int>> g(n);
    for (int i = 0; i < n; i++)
    {
        g[a[i].l].push_back(i);
        g[a[i].r].push_back(i);
    }
    string s;
    cin >> s;
    reverse(s.begin(), s.end());
    vector<bool> prev(n, true), cur(n);
    for (int i = 0; i < m; i++)
    {
        cur.assign(n, false);
        for (int j = 0; j < n; j++)
            if (prev[j] && s[i] == a[j].data)
            {
                for (int k = 0; k < (int)g[j].size(); k++)
                    cur[g[j][k]] = true;
            }
        prev = cur;
        
    } 
    vector<int> ans;
    for (int i = 0; i < n; i++)
        if(prev[i])
            ans.push_back(i);
    cout << ans.size() << ' ';
    for (int i = 0; i < (int)ans.size(); i++)
        cout << ans[i] + 1 << ' ';
    return 0;
}