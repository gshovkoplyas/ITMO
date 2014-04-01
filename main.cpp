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

#define taskname "bstsimple"

const int inf = (int)1e9 + 7;

struct node{
  int data;
  node *left, *right, *parent;
  
  node(){}
  node(int x) 
  {
    data = x;
    left = NULL;
    right = NULL;
  }
  void print() 
  { 
    if(this != NULL)
    {
      //cout << data << endl;
      left->print();
      printf("%i ", data);
      right->print();
    }
  }
};

void insert(node *& tree, int new_data, node *& parent) 
{
  if(tree == NULL)
  {
    tree = new node(new_data);
    tree->parent = parent;
  }
  else
  {
    if(new_data == tree->data)
      return;
    if(new_data < tree->data)
      insert(tree->left, new_data, tree);
    else
      insert(tree->right, new_data, tree);
  }
}

bool exists(node *& tree, int request)
{
  if(tree == NULL)
    return false;
  if(tree->data == request)
    return true;
  if(request < tree->data)
    return exists(tree->left, request);
  else
    return exists(tree->right, request);
}

int next(node *& tree, int request, int curmax)
{
  if(tree == NULL)
    return curmax;
  if(tree->data > request)
    return next(tree->left, request, tree->data);
  return next(tree->right, request, curmax);
}

int prev(node *& tree, int request, int curmin)
{
  if(tree == NULL)
    return curmin;
  if(tree->data < request)
    return prev(tree->right, request, tree->data);
  return prev(tree->left, request, curmin);                      
}

void del(node *&tree, int request)
{
  if(tree == NULL)
    return;
  if(tree->data == request)
  {
    if(tree->left == NULL && tree->right == NULL)
    {
      if(tree->parent == NULL)
      {
        delete tree;
        tree = NULL;
        return;
      }
      if(tree->data > tree->parent->data)
        tree->parent->right = NULL;
      else
        tree->parent->left = NULL;
      delete tree;
      return;
    }
    if(tree->left != NULL)
    {
      node *bench = tree->left;
      while(bench->right != NULL)
        bench = bench->right;
      tree->data = bench->data;
      if(bench->data > bench->parent->data)
        bench->parent->right = bench->left;
      else
        bench->parent->left = bench->left;
      delete bench;
    } 
    else
    {
      node *bench = tree->right;
      while(bench->left != NULL)
        bench = bench->left;
      tree->data = bench->data;
      if(bench->data > bench->parent->data)
          bench->parent->right = bench->right;
      else
          bench->parent->left = bench->right;
      delete bench;
    }
    return;
  }
  if(request < tree->data)
    return del(tree->left, request);
  else
    return del(tree->right, request);  
}

int main()
{
  freopen(taskname".in", "r", stdin);
  freopen(taskname".out", "w", stdout);
  node *tree = NULL;
  node *nullnode = NULL;
  string request;
  int key;
  while(cin >> request >> key)
  {
    //cerr << key << endl;
    if(request == "insert")
      insert(tree, key, nullnode);
    if(request == "delete")
      del(tree, key), tree->print();
    if(request == "exists")
    {
      if(exists(tree, key))
        cout << "true" << endl;
      else
        cout << "false" << endl;
    }
    if(request == "prev")
    {
      int ans = prev(tree, key, -inf);
      if(ans == -inf)
        cout << "none" << endl;
      else
        cout << ans << endl;
    }
	if(request == "next")
    {
      int ans = next(tree, key, inf);
      if(ans == inf)
        cout << "none" << endl;
      else
        cout << ans << endl;
    }
  }
  return 0;
}
