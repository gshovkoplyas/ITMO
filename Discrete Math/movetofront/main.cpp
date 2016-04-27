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
			cout << "left_size: " << left_size << ", "; 
			cout << "right_size: " << right_size << ", ";
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
			cout << ", ";
			cout << "size: ";
			cout << get_size();
			cout << endl;
			right->print(prefix + " ");
		}
	}
	void print_answer() 
	{
		if (this != NULL)
		{
			left->print_answer();
			printf("%d ", data);
			right->print_answer();
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

node *find(node *vertex, int key, int add = 0)
{
	if (vertex == NULL)
		return NULL;
	int cur = vertex->left_size + add;
	if (key == cur)
	{
		splay(vertex);
		return splay(vertex);
	}
	if (key < cur && vertex->left != NULL)
		return find(vertex->left, key, add);
	if (key > cur && vertex->right != NULL)
		return find(vertex->right, key, add + vertex->left_size + 1);
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
	int cur = root->left_size;
	if (cur < key)
	{
		right = root->right;
		root->right = NULL;
		root->right_size = NULL;
		set_parent(right, null_node);
		left = root;
	}
	else
	{
		left = root->left;
		root->left = NULL;
		root->left_size = 0;
		set_parent(left, null_node);
		right = root;
	}
}

node *insert(node *root, int new_data)
{
	node *left, *right;
	split(root, root->get_size(), left, right);
	root = new node(new_data);
	root->left = left;
	root->left_size = left->get_size();
	root->right = right;
	root->right_size = right->get_size();
	keep_parent(root);
	return root;
}

node *merge(node *left, node *right)
{
	if (right == NULL)
		return left;
	if (left == NULL)
		return right;
	right = find(right, 0);
	right->left = left;
	right->left_size = left->get_size();
	left->parent = right;
	return right;
}

int main()
{
	freopen(taskname".in", "r", stdin);
	freopen(taskname".out", "w", stdout);
	node *tree = NULL;
	int n, m;
	scanf("%d%d", &n, &m);
	for (int i = 1; i <= n; i++)
		tree = insert(tree, i);
	for (int i = 0; i < m; i++)
	{
		int a, b;
		scanf("%d%d", &a, &b);
		node *t1, *t2, *t3, *t0;
		split(tree, a - 1, t1, t2);
		split(t2, b - a + 1, t0, t3);
		node *t4 = merge(t0, t1);
		node *t5 = merge(t4, t3);
		tree = t5;
	}
	tree->print_answer();
	return 0;
}
