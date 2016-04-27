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

#define taskname "radixsort"

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n, m, k;
    cin >> n >> m >> k;
    vector<string> a(n);
    for (int i = 0; i < n; i++)
        cin >> a[i];
    for (int i = m - 1; i >= m - k; i--)
    {
        vector<string> b(n);
        vector<int> c(256, 0);
        for (int j = 0; j < n; j++)
            c[a[j][i]]++;
        int cnt = 0;
        for (int j = 0; j < 256; j++)
        {
            int num = c[j];
            c[j] = cnt;
            cnt += num;
        }
        for (int j = 0; j < n; j++)
        {
            b[c[a[j][i]]] = a[j];
            c[a[j][i]]++;
        }
        a = b;
    }
    for (int i = 0; i < n; i++) 
        cout << a[i] << '\n';
    return 0;
}