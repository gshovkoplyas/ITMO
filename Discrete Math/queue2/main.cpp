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

#define taskname "queue2"

struct liqueue{
  int data;
  liqueue *next;
};

liqueue *head, *tail;
  
void push(int x) 
{
  liqueue *e = new liqueue;
  e->data = x;
  e->next = NULL;
  tail->next = e;
  tail = e;
}

int pop() 
{
  liqueue *e = head->next;
  int result = e->data;
  head->next = e->next;
  if(head->next == NULL)
    tail = head;
  delete e;
  return result;
}


int main()
{
  freopen(taskname".in", "r", stdin);
  freopen(taskname".out", "w", stdout);
  head = new liqueue;
  head->next = NULL;
  tail = head;
  int n;
  scanf("%i%*c", &n);
  for(int i = 0; i < n; i++)
  {
    char c;
    scanf("%c%*c", &c);
    if(c == '-')
      printf("%i\n", pop());
    else
    {
      int a;
      scanf("%i%*c", &a);
      push(a);
    }
  }
  return 0;
}