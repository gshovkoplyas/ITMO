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

#define taskname "netcheck"

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n, m, k;
    cin >> n >> m >> k;
    vector<vector<pair<int, int> > > cmp(k);
    for (int i = 0; i < k; i++)
    {
        int r;
        cin >> r;
        for (int j = 0; j < r; j++)
        {
            int a, b;
            cin >> a >> b;
            a--;
            b--;
            if (a > b)
                swap(a, b);
            cmp[i].push_back(make_pair(a, b));
        }
    } 
    bool ans = true;
    for (int mask = 0; mask < (1 << n); mask++)
    {
        vector<int> a(n);
        for(int i = 0; i < n; i++)
            a[i] = ((mask & (1 << i)) != 0);
        /*for(int i = 0; i < n; i++)
            cout << a[i] << ' ';
        cout << endl;*/
        for (int i = 0; i < k; i++)
            for (int j = 0; j < (int)cmp[i].size(); j++)
                if(a[cmp[i][j].first] > a[cmp[i][j].second])
                    swap(a[cmp[i][j].first], a[cmp[i][j].second]);
        for (int i = 1; i < n; i++)
            if (a[i] < a[i - 1])
                ans = false;
        /*for(int i = 0; i < n; i++)
            cout << a[i] << ' ';
        cout << endl;
        cout << endl;*/
    }
    if (ans)
        cout << "Yes" << endl;
    else
        cout << "No" << endl;
    return 0;
}