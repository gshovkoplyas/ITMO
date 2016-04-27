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

#define taskname "stack2"

struct listack{
  int data;
  listack *next;
};

void push(listack *(&s), int x) 
{
  listack *e = new listack;
  e->data = x;
  e->next = s;
  s = e;
}

int pop(listack *(&s)) 
{
  int result = s->data;
  listack *e = s->next;
  delete s;
  s = e;
  return result;
}


int main()
{
  freopen(taskname".in", "r", stdin);
  freopen(taskname".out", "w", stdout);
  listack *top = NULL;
  int n;
  scanf("%i%*c", &n);
  for(int i = 0; i < n; i++)
  {
    char c;
    scanf("%c%*c", &c);
    if(c == '-')
      printf("%i\n", pop(top));
    else
    {
      int a;
      scanf("%i%*c", &a);
      push(top, a);
    }
  }
  return 0;
}