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
 
#define taskname "brackets"
 
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
  if(s == NULL)
    return 2;
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
  bool good = true;
  char c;
  while(scanf("%c", &c) > 0)
  {
    switch(c)
    {
      case '[':
        push(top, 0);
        break;
      case '(':
        push(top, 1);
        break;
      case ']':
        if(pop(top) != 0)
          good = false;
        break;
     case ')':
        if(pop(top) != 1)
          good = false;
        break;
     default:
       if(top != NULL)
         good = false;
       if(good)
         printf("YES\n");
       else
         printf("NO\n");
       good = true;
       top = NULL;
       break;
    }
  }
  return 0;
}