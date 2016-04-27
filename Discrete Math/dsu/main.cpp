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

#define taskname "dsu"
#define find tratata
#define union blablabla

vector<int> value, size, parent;
vector<pair<int, int> > extremum;

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
    if(size[x] < size[y])
      swap(x, y);
    size[x] += size[y];
    extremum[x].first = min(extremum[x].first, extremum[y].first);
    extremum[x].second = max(extremum[x].second, extremum[y].second);
    parent[y] = x;
  }
}

void get(int x)
{
  x = find(x);
  cout << extremum[x].first + 1 << ' ' << extremum[x].second + 1 << ' ' << size[x] << endl;
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
  extremum.resize(n);
  for(int i = 0; i < n; i++)
    value[i] = parent[i] = extremum[i].first = extremum[i].second = i; 
  string request;
  while(cin >> request)
  {
    if(request == "union")
    {
      int set_index1, set_index2;
      cin >> set_index1 >> set_index2;
      union(--set_index1, --set_index2);
    }  
    if(request == "get")
    {
      int set_index;
      cin >> set_index;
      get(--set_index);
    }
  }
  return 0;
}