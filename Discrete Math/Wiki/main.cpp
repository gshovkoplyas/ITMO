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

int n;
vector<int> a;

int bin_search(int x)
{
    int l = 0, r = a.size() - 1;
    int cnt = 0;
    while (r >= l)
    {
        cnt++;
        int m = (l + r) / 2;
        if (x == a[m])
            return cnt;
        if (x < a[m])
            r = m - 1;
        else
            l = m + 1;
    }
    cerr << "fucking shit" << endl;
    return cnt;
}

int ip_search(int x)
{
    int l = 0, r = a.size() - 1;
    int cnt = 0;
    while (a[l] < x && a[r] > x)
    {
        cnt++;
        int m = l + (x - a[l]) * (r - l) / (a[r] - a[l]);
        if (a[m] < x)
            l = m + 1;
        else if (a[m] > x)
            r = m - 1;
        else
            return cnt;
    }
    //cerr << "fffucking shit" << endl;
    return cnt;
     
}

bool check()
{
    int cur = 1;
    int c = n + 5, b = 0;
    for (int i = 1; i < n; i++)
    {
        if (a[i] == a[i - 1])
            cur++;
        else
            c = min(cur, c), b = max(cur, b), cur = 1; 
    }
    c = min(cur, c), b = max(cur, b);
    return c > 1 && b - c < 3;
}

void gen(int len = 1, int prev = 1)
{
    if (len < n)
    {
        for (int i = prev; i <= prev + 1; i++)
        {
            a[len] = i;
            gen(len + 1, i); 
        }     
    }
    else
    {
        bool flag = false;
        for (int i = 1; i <= prev; i++)
            if (bin_search(i) >= 4 && ip_search(i) == 2 && check())
                flag = true, cout << i << endl;
        for (int i = 0; i < n && flag; i++)
            cout << a[i] << ((i < n - 1) ? " " : "\n");
    }
}

int main()
{
    freopen("output.txt", "w", stdout);
    for (int i = 16; i <= 25; i++)
    {
        n = i;
        a.assign(n, 1);
        gen();    
    }
    return 0;
}