#include <cstdio>
#include <set>
#include <algorithm>
#include <cstring>

using namespace std;

int main() {
  freopen("avlset.in", "r", stdin);
  freopen("stress.out", "w", stdout);
  set <int> s;
  char str[20];
  int x;
  int n;
  scanf("%d%*c", n);
  while (scanf("%s%d", str, &x) >= 1) {
    if (!strcmp(str, "A"))
      s.insert(x);
    if (!strcmp(str, "D"))
      s.erase(x);
    if (!strcmp(str, "C"))
      printf("%s\n", s.find(x) != s.end() ? "Y" : "N");
    /*if (!strcmp(str, "next")) {
      set <int>::iterator it = s.upper_bound(x);
      if (it == s.end())
        printf("none\n");
      else
        printf("%d\n", *it);
    }
    if (!strcmp(str, "prev")) {
      set <int>::iterator it = s.upper_bound(x);
      if (it == s.begin()) {
        printf("none\n");
      } else {
        --it;
        printf("%d\n", *it);
      }*/
    //}
  }
  return 0;
}