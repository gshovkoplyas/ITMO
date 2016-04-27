#include<bits/stdc++.h>
using namespace std;

int main() 
{
    freopen("mutation.in", "r", stdin);
    freopen("mutation.out", "w", stdout);
    int n, m;
    cin >> n >> m;
    while (m--) 
    {
        string a, b;
        cin >> a >> b;
        int cnt = 0;
        for (int i = 0; i < n; i++)
            if (a[i] != b[i])
                cnt++;
        double res1 = 1;
        res1 /= n;
        double res2 = n - 1;
        res2 /= n;
        double ans = 1;
        for (int i = 0; i < cnt; i++)
            ans *= res1;
        for (int i = 0; i < n - cnt; i++)
            ans *= res2;
        cout.precision(15);
        cout << fixed << ans << endl;
    }
    return 0;
}