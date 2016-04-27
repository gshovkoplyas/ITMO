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

#define taskname "priorityqueue"

const int N = (int)2e6;

int heap[N];
int heap_size;

vector<int> value, index;

void sift_down(int v) 
{
  if (2 * v > heap_size)
    return;
  if (2 * v + 1 > heap_size)
  {
    if (value[heap[2 * v]] < value[heap[v]])
    {
      swap(index[heap[2 * v]], index[heap[v]]);
      swap(heap[2 * v], heap[v]);
    }
    return;
  }
  if (value[heap[2 * v]] <= value[heap[2 * v + 1]] && value[heap[2 * v]] <= value[heap[v]])
  {
    swap(index[heap[2 * v]], index[heap[v]]);
    swap(heap[2 * v], heap[v]); 
    sift_down(2 * v);
    return;
  }
  if (value[heap[2 * v + 1]] <= value[heap[2 * v]] && value[heap[2 * v + 1]] <= value[heap[v]])
  {
    swap(index[heap[2 * v + 1]], index[heap[v]]);
    swap(heap[2 * v + 1], heap[v]); 
    sift_down(2 * v + 1);
    return;
  }
}

void sift_up(int v)
{
  if (v == 1)
    return;
  if (value[heap[v]] < value[heap[v / 2]])
  {
    swap(index[heap[v]], index[heap[v / 2]]);
    swap(heap[v], heap[v / 2]);
    sift_up(v / 2);
  }
}

int extract_min() 
{
  int result = heap[1];
  heap[1] = heap[heap_size];
  index[heap[1]] = 1;
  heap_size--;
  sift_down(1);
  return result;
}

void decrease_key(int ind, int newkey)
{
  value[ind] = newkey;
  sift_up(index[ind]);
}

void push(int x)
{
  heap_size++;
  heap[heap_size] = x;
  sift_up(heap_size);
}


int main()
{
  freopen(taskname".in", "r", stdin);
  freopen(taskname".out", "w", stdout);
  string request;
  int k = 0;
  while(cin >> request)
  { 
    if(request == "push")
    {
      int key;
      cin >> key;
      index.push_back(heap_size + 1);
      value.push_back(key);
      push(k); 
    }
    else
      value.push_back(0), index.push_back(0); 
    if(request == "extract-min")
    {
      if(heap_size == 0)
        printf("*\n");
      else
        printf("%i\n", value[extract_min()]);
    }
    if(request == "decrease-key")
    {
      int ind, newkey;
      cin >> ind >> newkey;
      decrease_key(ind - 1, newkey);
    }
    k++;
  }
  return 0;
}