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
 
#define taskname "postfix"
 
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
  bool isprevnum = false;
  int num = 0;
  char c;
  while(scanf("%c", &c) > 0)
  {
    if(c >= '0' && c <= '9')
    {
      isprevnum = true;
      num = num * 10 + (c - '0');
      continue;
    } 
    else if(c == '+' || c == '-' || c == '*') 
    {
      isprevnum = false;
      int a = pop(top), b = pop(top);
      int result = 0;
      if(c == '+')
        result = a + b;
      if(c == '-')
        result = b - a;
      if(c == '*')
        result = a * b;
      push(top, result);
    } 
    else 
    {
      if(isprevnum)
        push(top, num);
        num = 0;
    }
  }
  printf("%i\n", pop(top));
  return 0;
}