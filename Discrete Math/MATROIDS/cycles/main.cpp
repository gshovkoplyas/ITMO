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

#define taskname "cycles"


int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n, m;
    cin >> n >> m;
    int k = 1 << n;
    vector<bool> bad(k, false);
    vector<int> power(k, 0), w(n);
    for (int i = 0; i < n; i++)
        cin >> w[i];

    for (int i = 0; i < m; i++)
    {
        int size, mask = 0;
        cin >> size;
        for (int j = 0; j < size; j++)
        {
            int q;
            cin >> q;
            mask |= (1 << (--q));
        }
        //cerr << mask << endl;
        bad[mask] = true;
        power[mask] = size;
    }
    long long ans = 0;
    for (int i = 0; i < k; i++)
    { 
        if (bad[i])
        {
            for (int j = 0; j < n; j++)
            {
                int x = 1 << j;
                bad[x | i] = true;
            }
        }
        else
        {
            long long cur = 0;
            for (int j = 0; j < n; j++)
            {
                int x = 1 << j;
                if ((x & i) != 0)
                    cur += w[j];
            }
            ans = max(ans, cur);
        }
    }
    cout << ans << endl;
    return 0;
}