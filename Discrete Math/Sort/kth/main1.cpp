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

#define taskname "kth"

int kth_element(vector<int> &a, int k) 
{
    int l = 0, r = a.size() - 1;
    while (true)
    {
        int m = l + rand() % (r - l + 1);
        if (l != r)
            swap(a[m], a[r]);
        int x = a[r], i = l;
        for (int j = l; j <= r; j++)
            if (a[j] <= x)
            {
                swap(a[i], a[j]);
                i++;
            }
        int pos = i - 1;
        if (pos == k)
            return a[pos];
        else if(k < pos)
            r = pos - 1;
        else
            l = pos + 1;
    }
} 

int main()
{
    srand(time(NULL));
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n, k, A, B, C;
    cin >> n >> k >> A >> B >> C;
    vector<int> a(n);
    cin >> a[0] >> a[1];
    for (int i = 2; i < n; i++)
        a[i] = A * a[i - 2] + B * a[i - 1] + C;
    //for (int i = 0; i < n; i++)
      //  cout << kth_element(a, i) << endl;
    cout << kth_element(a, k - 1) << endl;
    return 0;
}