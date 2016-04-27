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
#include<queue>
using namespace std;

#define taskname "maxflow"

const int INF = (int)1e9;

int n, m, s, t;
vector<vector<int> > c, f;
vector<int> d, str;
queue<int> q;

struct edge {
  int begin;
  int end;
  int capacity;
  int flow
  edge &reversed;

  edge(int begin, int end, int capacity, int flow): begin(begin), end(end), capacity(capacity), flow(flow) {
  }
};

struct max_flow {
  vector <vector<edge *>> graph;
  vector <int> queue;
  vector <int> distance;
  vector <int> nextEdge;
  
  max_flow(int vertices): graph(vertices), queue(vertices), distance(vertices), nextEdge(verices) {
  }

  void add_edge(int begin, int end, int capacity) {
    edge e1(begin, end, capacity, 0);
    edge e2(end, begin, 0, 0);
    e1.reversed = e2;
    e2.reversed = e1;
    graph[begin].push_back(&e1);
    graph[end].push_back(&e2);                       
  }
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    scanf("%d%d", &n, &m);
    return 0;           
}