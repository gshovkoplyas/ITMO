#include <iostream>
#include <cstdio>
#include <ctime>
#include <algorithm>
 
using namespace std;
 
int n, k;
int a[40000000];
 
int findk(int k, int l, int r) {
    if (l == r) {
        return a[l];
    }
 
    int i = l;
    int j = r;
    int m = l + rand() % (r - l + 1);
    int x = a[m];
 
    while (i <= j) {
        while (a[i] < x) {
            i++;
        }
        while (a[j] > x) {
            j--;
        }
        if (i <= j) {
            swap(a[i], a[j]);
            i++;
            j--;
        }
    }
 
    if (i <= k) {
        findk(k, i, r);
    }
    if (j >= k) {
        findk(k, l, j);
    }
}
 
int main() {
 
    freopen("kth.in", "r", stdin);
    freopen("kth.out", "w", stdout);
 
    srand(time(NULL));
 
    int x1, x2, x3;
 
    cin >> n >> k;
    cin >> x1 >> x2 >> x3;
    cin >> a[1] >> a[2];
 
    for (int i = 3; i <= n; i++) {
        a[i] = x1 * a[i - 2] + x2 * a[i - 1] + x3;
    }
 
    findk(k, 1, n);
    cout << a[k];
 
    return 0;
}