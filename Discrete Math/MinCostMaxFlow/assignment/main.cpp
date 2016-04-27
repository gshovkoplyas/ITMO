/*Grigory Shovkoplyas in the house*/
#include<cstdio>
#include<iostream>
#include<algorithm>
#include<cmath>
#include<cstring>
#include<string>
#include<vector>
#include<map>
#include<set>
#include<cstdlib>
#include<ctime>
using namespace std;

#define taskname "assignment"

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n;
    cin >> n;
    vector<vector<int> > c(n + 1, vector<int>(n + 1));
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= n; j++)
            cin >> c[i][j];
    vector<long long> u(n + 1), v(n + 1);
    vector<int> p(n + 1), path(n + 1), ans(n + 1);
    for (int i = 0; i < n + 1; i++)
    {
        p[0] = i;
        vector<long long> minv(n + 1, (long long)1e18);
        vector<int> was(n + 1, 0);
        int curj = 0, newj;
        while(1)
        {
            //cerr << curj << endl;
            was[curj] = 1;
            long long delta = (long long)1e18;
            for (int j = 1; j <= n; j++)
                if (!was[j])
                {
                    long long cur = c[p[curj]][j] - u[p[curj]] - v[j];
                    if (cur < minv[j]) 
                        minv[j] = cur, path[j] = curj;
                    if (minv[j] < delta)
                        delta = minv[j], newj = j;
                }
            for (int j = 0; j <= n; j++)
                if (was[j])
                    u[p[j]] += delta, v[j] -= delta;
                else
                    minv[j] -= delta;
            curj = newj;
            if (p[curj] == 0)
                break;
        }
        do 
        {
            newj = path[curj];
            p[curj] = p[newj];
            curj = newj;
        } while(curj != 0);
    }
    cout << -v[0] << endl;
    for (int i = 1; i <= n; i++)
        ans[p[i]] = i;
    for (int i = 1; i <= n; i++)
        cout << i << ' ' << ans[i] << endl;
    return 0;           
}