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

#define taskname "rmq2"

int main()
{
  freopen(taskname".in", "r", stdin);
  freopen("stress.out", "w", stdout);
  int n;
    scanf("%d", &n);
    vector<long long> a(n);
    for (int i = 0; i < n; i++)
        scanf("%I64d", &a[i]); 
  char request[10];
  while (scanf("%s", request) > 0)
    {
        if (request[0] == 'm')
        {
            int l, r;
            scanf("%d%d", &l, &r);
            l--;
            long long ans = (long long)1e18 + 888;
            for(int i = l; i < r; i++)
              ans = min(ans, a[i]);
            cout << ans << endl;
        }
        else 
        {
            int l, r;
            long long data;
            scanf("%d%d%I64d", &l, &r, &data);
            l--;
            if (request[0] == 'a')
              for (int i = l; i < r; i++)
                  a[i] += data;
            else
              for (int i = l; i < r; i++)
                  a[i] = data;
        }
        //for(int i = 0; i < n; i++)
          //printf("%d ", a[i]);
        //printf("\n");
    }

  return 0;
}