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

#define taskname "isheap"

const int INF = (int)2e9 + 7;

int main()
{
  freopen(taskname".in", "r", stdin);
  freopen(taskname".out", "w", stdout);
  int n; 
  cin >> n;
  vector<int> heap(3 * n, INF);	
  for (int i = 0; i < n; i++)
    cin >> heap[i];
  bool isheap = true;
  for (int i = 0; i < n; i++)
    if (heap[2 * i + 1] < heap[i] || heap[2 * i + 2] < heap[i])
      isheap = false;
  if(isheap)
    printf("YES");
  else
    printf("NO");
  return 0;
}