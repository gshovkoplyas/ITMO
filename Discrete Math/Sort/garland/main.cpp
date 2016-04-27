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

#define taskname "garland"

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n;
    double h;
    cin >> n >> h;
    double l = 0, r = 1e18; 
    vector<double> a(n);
    a[0] = h;
    for (int i = 0; i < 20000; i++)
    {
        double h2 = (l + r) / 2;
        a[1] = h2;
        for (int j = 2; j < n; j++)
            a[j] = -a[j - 2] + 2 * a[j - 1] + 2;
        bool good = true;
        for (int j = 0; j < n; j++)
        {
            if (a[j] < 0)
                good = false;
        }
        if (good)
            r = h2;
        else
            l = h2;        
    }
    cout.precision(2);
    cout << fixed;
    cout << a[n - 1] << endl;
    return 0;
}