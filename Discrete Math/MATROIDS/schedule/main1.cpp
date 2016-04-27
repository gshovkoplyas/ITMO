/*Grigory Shovkoplyas in the house*/
#include<cstdio>
#include<cassert>
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

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n;
    cin >> n;
    vector<pair<int, int>> e(n);
    for (int i = 0; i < n; i++)
    {
        int a, b;
        cin >> a >> b;
        e[i] = make_pair(a, b);
    }
    sort(e.begin(), e.end());
    set<int> schedule;
    int cur_time = 0;
    long long ans = 0;
    for (int i = 0; i < n; i++)
    {
        if (e[i].first == 0)
        {
            ans += e[i].second;
            continue;
        }
        if (e[i].first > cur_time)
            schedule.insert(e[i].second), cur_time++;
        else if (e[i].second > *schedule.begin())
        {
            ans += *schedule.begin();
            schedule.erase(schedule.begin());
            schedule.insert(e[i].second);
        }
    }    
    cout << ans << endl;
    return 0;
}

