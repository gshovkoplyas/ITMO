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

#define taskname "array"

const int MAXC = 256;
const int MAXN = 400005;

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    char s[MAXN];
    gets(s);
    int n = strlen(s) + 1;
    vector<int> c(n);
    for (int i = 0; i < n; i++)
        c[i] = s[i];
    vector<int> cnt(MAXC);
    for (int i = 0; i < n; i++)
        cnt[c[i]]++;
    int k = max(n, MAXC);
    vector<int> h(k);
    vector<int> h_(k);
    for (int i = 1; i < MAXC; i++)
    {
        h[i] = h[i - 1] + cnt[i - 1];
        h_[i] = h[i];
    }
    vector<int> a(n);
    for (int i = 0; i < n; i++)
        a[h_[c[i]]++] = i;
    vector<int> new_a(n);
    vector<int> new_c(n);
    for (int l = 1; l < n; l <<= 1)
    {
        for (int i = 0; i < n; i++)
        {
            int id = (a[i] - l + n) % n;
            new_a[h[c[id]]++] = id;
        }
        int size = 0;
        for (int i = 0; i < n; i++)
        {
            if (i == 0 || c[new_a[i]] != c[new_a[i - 1]] || c[(new_a[i] + l) % n] != c[(new_a[i - 1] + l) % n])
                h[size++] = i;
            new_c[new_a[i]] = size - 1;
        }
        a = new_a;
        c = new_c;
    }
    for (int i = 1; i < n; i++)
        printf("%d%c", a[i] + 1, (i == n - 1) ? '\n' : ' ');
    return 0;           
}







