#include <cstdio>
#include <iostream>
#include <algorithm>
#include <ctime>
#include <set>

using namespace std;

typedef long long ll;

ll rdtsc() {
  ll tmp;
  asm("rdtsc" : "=A"(tmp));
  return tmp;
}

const int maxn = 100;

int getRand() {
  return rand() % 10 - 20;
}

int main() {
  srand(rdtsc());
  freopen("rmq2.in", "w", stdout);
  int q = maxn;
  int e = rand() % maxn + 1;
  cout << e << endl;
  for(int i = 0; i < e; i++)
    cout << getRand() << ' ';
  cout << endl;
  for (int i = 0; i < q; i++) {
    int type = rand() % 3;
    int l = rand() % e + 1;
    int r = rand() % e + 1;
    if (l > r)
      swap(l, r);
    if (type == 0) 
      printf("min %d %d\n", l, r);
    if (type == 1)
      printf("set %d %d %d\n", l, r, getRand());
    if (type == 2)
      printf("add %d %d %d\n", l, r, getRand());
  }
}