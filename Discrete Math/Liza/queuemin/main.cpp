#include<cstdio>
#include<algorithm>
#include<stack>
using namespace std;

#define taskname "queuemin"
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
  int n;
  scanf("%i%*c", &n);
  for(int i = 0; i < n; i++)
  {
    char c;
    scanf("%c%*c", &c);
    if (c == '?')
        printf("%d\n", get_min());
    else if (c == '-')
      pop();
    else
    {
      int a;
      scanf("%i%*c", &a);
      push(a);
    }
  }
  return 0;
}