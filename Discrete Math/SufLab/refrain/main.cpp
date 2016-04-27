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

#define taskname "refrain"

const int MAXC = 256;
const int MAXN = 400005;

vector<int> par, siz;

int get(int x)
{
    if (par[x] == x)
        return x;
    par[x] = get(par[x]);
    return par[x];
}

void join(int x, int y)
{
    x = get(x);
    y = get(y);
    if (x == y)
        return;
    if (siz[x] > siz[y])
        swap(x, y);
    par[x] = y;
    siz[y] += siz[x];
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n;
    scanf("%d%*d", &n);
    vector<int> c(n + 1, 0);
    for (int i = 0; i < n; i++)
        scanf("%d", &c[i]);
    n++;
    vector<int> s(n);
    for (int i = 0; i < n; i++)
        s[i] = c[i];
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
    //------------------lcp---------
    vector<int> lcp(n);
    vector<int> pos(n);
    for (int i = 0; i < n; i++)
        pos[a[i]] = i;
    k = 0;
    for (int i = 0; i < n; i++)
    {
        if (k > 0)
            k--;
        if (pos[i] == n - 1)
        {
            lcp[n - 1] = -1;
            k = 0;
        }
        else
        {
            int id = a[pos[i] + 1];
            while (max(i + k, id + k) < n && s[i + k] == s[id + k])
                k++;
            lcp[pos[i]] = k;
        }
    }
    vector<pair<int, int> > v;
    for (int i = 0; i < n; i++)  
        v.push_back(make_pair(lcp[i], i));
    sort(v.begin(), v.end());
    reverse(v.begin(), v.end());
    vector<int> seg(n, 0);
    par.resize(n);
    for (int i = 0; i < n; i++)
        par[i] = i;
    siz.assign(n, 1);
    long long ans = n - 1;
    int len = n - 1;
    int beg = 0;
    for (int i = 0; i < (int)v.size(); i++)
    {
        int cur = v[i].second;
        seg[cur] = 1;
        if (cur - 1 >= 0 && seg[cur - 1] == 1)
            join(cur, cur - 1);
        if (cur + 1 < n && seg[cur + 1] == 1)
            join(cur, cur + 1);
        if (ans <= 1ll * (siz[get(cur)] + 1) * lcp[cur])
        {
            ans = 1ll * (siz[get(cur)] + 1) * lcp[cur];
            len = lcp[cur];
            beg = a[cur];
        }
    }
    cout << ans << endl;
    printf("%d\n", len);
    for (int i = beg; i < beg + len; i++)
        printf("%d ", s[i]);
    return 0;           
}







