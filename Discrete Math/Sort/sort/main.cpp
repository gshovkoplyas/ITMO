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

#define taskname "sort"

void my_quick_sort(vector<int> &a, int l, int r)
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
    if (i < r)
        my_quick_sort(a, i, r);
    if (l < j)  
        my_quick_sort(a, l, j);
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    srand(time(NULL));
    int n;
    cin >> n;
    vector<int>a(n);
    for (int i = 0; i < n; i++)
      cin >> a[i];
    my_quick_sort(a, 0, a.size() - 1);
    for (int i = 0; i < n; i++)
      cout << a[i] << ' ';
    cout << endl;
    return 0;
}