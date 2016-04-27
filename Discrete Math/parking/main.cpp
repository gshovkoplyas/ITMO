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

#define taskname "parking"
#define find tratata
#define union blablabla

vector<int> value, size, parent;
vector<int> next_zero;

int find(int x)
{
  if(x == parent[x])
    return x;
  parent[x] = find(parent[x]);
  return parent[x];
}

void union(int x, int y)
{
  x = find(x);
  y = find(y);
  if(x != y)
  {
    next_zero[x] = next_zero[y];
    if(size[x] < size[y])
      swap(x, y);
    size[x] += size[y];
    parent[y] = x;
  }
}

int main()
{
  freopen(taskname".in", "r", stdin);
  freopen(taskname".out", "w", stdout);
   int n;
  scanf("%i", &n);
  value.assign(n, 0);
  parent.assign(n, 0);
  size.assign(n, 1);
  next_zero.resize(n);
  for (int i = 0; i < n; i++)
    value[i] = parent[i] = next_zero[i] = i;
  for (int i = 0; i < n; i++)
  {
    int car;
    scanf("%i", &car);
    int answer = next_zero[find(--car)];
    printf("%i ", answer + 1);
    union(answer, (answer + 1) % n);
  } 
  return 0;
}

