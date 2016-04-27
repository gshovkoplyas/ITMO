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

#define taskname "check"


int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n, m;
    cin >> n >> m;
    int k = 1 << n;
    vector<bool> was(k, false);
    vector<int> power(k, 0);
    bool ok = true;
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
        was[mask] = true;
        power[mask] = size;
    }
    ok &= was[0];
    for (int i = 0; i < k; i++)
        if (was[i])
            for (int j = 0; j < k; j++)
            {
                if ((i | j) == i && !was[j])
                    ok = false;
                if (was[j] && power[i] > power[j])
                {
                    int is_x = false;
                    //cerr << i << ' ' << j << ' ';
                    for (int k = 0; k < n; k++)
                    {
                        int x = 1 << k;
                        if ((i & x) != 0 && (j & x) == 0 && was[j | x])
                            is_x = true;// cerr << k << endl;
                    }
                    ok &= is_x;
                }
            }
    if (ok)
        printf("YES\n");
    else
        printf("NO\n");
    return 0;
}