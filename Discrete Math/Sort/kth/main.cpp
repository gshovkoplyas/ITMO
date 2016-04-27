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
#include<cassert>
#include<cstdlib>
#include<ctime>
using namespace std;

#define taskname "kth"

int kth_element(vector<int> &a, int k, int l, int r)
{
    int i = l, j = r;
     //int m = (l + r) / 2;
    int m = l + rand() % (r - l + 1);
    int x = a[m];
    do
    {
        while (a[i] < x) 
            i++;
        while (a[j] > x)
            j--;
        if (i <= j)
        {
            if (i < j)
                swap(a[i], a[j]);
            i++;
            j--;
        }
    } while (i <= j);
    if (i <= k)
        return kth_element(a, k, i, r);
    if (k <= j)  
        return kth_element(a, k, l, j);
    return a[k];
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
    cout << kth_element(a, k - 1, 0, n - 1) << endl;
    return 0;
}
