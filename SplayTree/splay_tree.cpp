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

#define taskname "movetofront"

struct node 
{
	int data, left_size, right_size;
	node *left, *right, *parent;
	node(){}
	node(int new_data)
	{
		data = new_data;
		left = NULL;
		right = NULL;
		parent = NULL;
		left_size = right_size = 0;
	}
	int get_size()
	{	
		if (this == NULL)
			return 0;
		return 1 + left_size + right_size;
	}
	void print(string prefix = "")
	{
		if (this != NULL)
		{
			left->print(prefix + " ");
			cout << prefix << "data: " << data << ", "; 
			cout << "parent: "; 
			if (parent != NULL)
				cout << parent->data;
			else
				cout << "NULL";
		    cout << ", ";
			cout << "parent.left: ";
			if (parent != NULL && parent->left != NULL)
				cout << parent->left->data;
			else
				cout << "NULL";
			cout << ", ";
			cout << "parent.right: ";
			if (parent != NULL && parent->right != NULL)
				cout << parent->right->data;
			else
				cout << "NULL";
			cout << endl;
			right->print(prefix + " ");
		}
	}

};

void set_parent(node *&child, node *&parent)
{
	if (child != NULL)
		child->parent = parent;
}

void keep_parent(node *&vertex)
{
	set_parent(vertex->left, vertex);
	set_parent(vertex->right, vertex);
}

void rotate(node *child, node *parent)
{
	node *grandpa = parent->parent;
	if (grandpa != NULL) 
	{
		if (grandpa->left == parent)
			grandpa->left = child;
		else
			grandpa->right = child;
	}
	if (parent->left == child) 
	{
		parent->left = child->right;
		parent->left_size = child->right->get_size();
		child->right = parent;
		child->right_size = parent->get_size();
	}
	else
	{
		parent->right = child->left;
		parent->right_size = child->left->get_size();
		child->left = parent;
		child->left_size = parent->get_size();
	}
	keep_parent(child);
	keep_parent(parent);
	child->parent = grandpa;
}

node *splay(node *vertex)
{
	node *parent = vertex->parent;
	if (parent == NULL)
		return vertex;
	node *grandpa = parent->parent;
	if (grandpa == NULL)
	{
		rotate(vertex, parent);
		return vertex;
	}
	else
	{
		bool zig_zig = (grandpa->left == parent) == (parent->left == vertex);
		if (zig_zig)
		{
			rotate(parent, grandpa);
			rotate(vertex, parent);
		}
		else
		{
			rotate(vertex, parent);
			rotate(vertex, grandpa);
		}
		return splay(vertex);
	}
}

node *find(node *vertex, int key)
{
	if (vertex == NULL)
		return NULL;
	if (vertex->data == key)
	{
		splay(vertex);
		return splay(vertex);
	}
	if (key < vertex->data && vertex->left != NULL)
		return find(vertex->left, key);
	if (key > vertex->data && vertex->right != NULL)
		return find(vertex->right, key);
	return splay(vertex);
}

// в left все ключи меньше key, в right все ключи не меньше key
void split(node *root, int key, node *&left, node *&right)
{
	if (root == NULL)
	{
		left = NULL;
		right = NULL;
		return;
	}
	node *null_node = NULL;
	root = find(root, key);
	if (root->data < key)
	{
		right = root->right;
		root->right = NULL;
		set_parent(right, null_node);
		left = root;
	}
	else
	{
		left = root->left;
		root->left = NULL;
		set_parent(left, null_node);
		right = root;
	}
}

node *insert(node *root, int new_data)
{
	node *left, *right;
	split(root, new_data, left, right);
	root = new node(new_data);
	root->left = left;
	root->right = right;
	keep_parent(root);
	return root;
}

node *merge(node *left, node *right)
{
	if (right == NULL)
		return left;
	if (left == NULL)
		return right;
	right = find(right, left->data);
	right->left = left;
	left->parent = right;
	return right;
}

int main()
{
	freopen(taskname".in", "r", stdin);
	freopen(taskname".out", "w", stdout);
	node *tree = NULL;
	for (int i = 1; i < 10; i++)
		tree = insert(tree, i);
	node *t1, *t2;
	split(tree, 5, t1, t2);
	tree = merge(t1, t2);
	tree->print();
	return 0;
}
