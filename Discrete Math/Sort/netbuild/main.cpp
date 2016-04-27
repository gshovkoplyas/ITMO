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

#define taskname "netbuild"

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n; 
    cin >> n;
    int x = 1;
    while (x < n)
        x <<= 1;
    swap(x, n);
    vector<vector<pair<int, int> > > cmp(12);
    int level = 0;
    for (int k = 2; k <= n; k *= 2)
    {
        for (int i = 0; i < n / k; i++)
        {
            int start = i * k;
            for (int j = 0; j < k / 2; j++)
                if(start + k - j <= x)
                    cmp[level].push_back(make_pair(start + j + 1, start + k - j));
        }     
        level++;
        for (int d = k / 2; d > 1; d /= 2)
        {
            for (int i = 0; i < n / d; i++)
            {
                int start = i * d;
                for (int j = 0; j < d / 2; j++)
                    if(start + d / 2 + j < x)
                        cmp[level].push_back(make_pair(start + j + 1, start + d / 2 + j + 1));
            }
            level++;
        }
    }
    int ans = 0, cmps = 0;
    for (int i = 0; i < 12; i++)
        if (cmp[i].size() != 0)
            ans++, cmps += cmp[i].size();
    printf("%d %d %d\n", x, cmps, ans);
    for (int i = 0; i < ans; i++)
    {
        printf("%d ", (int)cmp[i].size());
        for (int j = 0; j < (int)cmp[i].size(); j++)
            printf("%d %d ", cmp[i][j].first, cmp[i][j].second);
        printf("\n");
    }
    return 0;
}