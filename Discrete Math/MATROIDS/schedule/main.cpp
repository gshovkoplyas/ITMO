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

#define taskname "schedule"

struct event 
{
    int d, w;
    event(){}
    event(int a, int b): d(a), w(b) {}
    void read() 
    {
        cin >> d >> w;
    }
};

bool cmp(event a, event b) {
    if (a.w == b.w)
        return a.d < b.d;
    return a.w > b.w;
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname"1.out", "w", stdout);
    int n;
    cin >> n;
    vector<event> e(n);
    for (int i = 0; i < n; i++)
        e[i].read();
    sort(e.begin(), e.end(), cmp);
    map<int, bool> shedule;
    long long ans = 0;
    for (int i = 0; i < n; i++)
    {
        int j = e[i].d - 1;
        //cerr << j << ' ';
        while (j >= 0 && shedule[j])
            j--;
        //cerr << j << endl;
        if (j < 0)
            ans += e[i].w;
        else
            shedule[j] = true;
    }    
    cout << ans << endl;
    return 0;
}

