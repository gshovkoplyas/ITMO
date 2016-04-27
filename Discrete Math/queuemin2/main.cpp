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
#include<stack>
using namespace std;

#define taskname "queuemin2"
#define X first
#define Y second

stack<pair<int, int> > head, tail;

void push(int x)
{
  int y;
  if(tail.size() > 0 && tail.top().Y < x)
    y = tail.top().Y;
  else
    y = x;
  tail.push(make_pair(x, y));
}

void pop()
{
  if(head.size() == 0)
  {
    int k = tail.size();
    for(int i = 0; i < k; i++)
    {
      int x = tail.top().X;
      int y;
      if(head.size() > 0 && head.top().Y < x)
        y = head.top().Y;
      else
        y = x;
      head.push(make_pair(x, y));
      tail.pop();
    }
  }
  head.pop();
}

int get_min()
{
  if(head.size() == 0)
    return tail.top().Y;
  if(tail.size() == 0)
    return head.top().Y;
  return min(tail.top().Y, head.top().Y);
}

int main()
{
  freopen(taskname".in", "r", stdin);
  freopen(taskname".out", "w", stdout);
  int n, m, k, a, b, c;
  cin >> n >> m >> k >> a >> b >> c;
  vector<int> x(k);
  for(int i = 0; i < k; i++)
    scanf("%i", &x[i]);
  int x0 = 0, x1 = 0;
  for(int i = 0; i < m; i++)
  {
    int y;
    if(i < k)
      y = x[i];
    else
      y = a * x0 + b * x1 + c;
    push(y);
    x0 = x1;
    x1 = y;
  }
  long long ans = 0;
  for(int i = m; i <= n; i++)
  {
    ans += get_min();
    pop();
    int y;
    if(i < k)
      y = x[i];
    else
      y = a * x0 + b * x1 + c;
    push(y);
    x0 = x1;
    x1 = y; 
  }
  cout << ans << endl;
  return 0;
}