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

#define taskname "antiqs"

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int n;
    cin >> n;
    vector<int> a(n);
    for(int i = 0; i < n; i++)
        a[i] = i + 1;
    for(int i = 2; i < n; i++)
        swap(a[i], a[i / 2]);
    for(int i = 0; i < n; i++)
        printf("%d ", a[i]);
    return 0;
}