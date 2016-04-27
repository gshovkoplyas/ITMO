#define _CRT_SECURE_NO_WARNINGS
#include <cassert>
#include <cstdio>
#include <algorithm>
#include <iostream>
using namespace std;

struct node 
{
    int key, height;
    node *left, *right;
    node(){}
    node(int x)
    {
        key = x;
        height = 1;
        left = NULL;
        right = NULL;
    }

    void print()
    {
        if (this != NULL)
        {
            left->print();
            printf("%d ", key);
            right->print();
        }
    }
};

int height(node *p)
{
    if (p == NULL)
        return 0;
    return p->height;
}

int balance(node *p)
{
    if (p == NULL)
        return 0;
    return height(p->right) - height(p->left);
}

void correct_height(node *p)
{
    int height_left = height(p->left);
    int height_right = height(p->right);
    p->height = max(height_left, height_right) + 1;
}

node *small_rotate_right(node *p)
{
    node *q = p->left;
    p->left = q->right;
    q->right = p;
    correct_height(p);
    correct_height(q);
    return q;
}

node *small_rotate_left(node *p)
{
    node *q = p->right;
    p->right = q->left;
    q->left = p;
    correct_height(p);
    correct_height(q);
    return q;
}

node *do_good(node *p)
{
    correct_height(p);
    if (balance(p) == 2)
    {
        if (balance(p->right) < 0)
            p->right = small_rotate_right(p->right);
        return small_rotate_left(p);
    }
    if (balance(p) == -2)
    {
        if (balance(p->left) > 0)
            p->left = small_rotate_left(p->left);
        return small_rotate_right(p);
    }
    return p;
}

node *insert(node *p, int x)
{
    if (p == NULL)
        return new node(x);
    if (x < p->key)
        p->left = insert(p->left, x);
    else if (x > p->key)
        p->right = insert(p->right, x);
    return do_good(p);
}

node *max(node *p)
{
    if (p->right == NULL)
        return p;
    return max(p->right);
}

node *remove_max(node *p)
{
    if (p->right == NULL)
        return p->left;
    p->right = remove_max(p->right);
    return do_good(p);
}

node *remove(node *p, int x)
{
    if (p == NULL)
        return NULL;
    if (x < p->key)
        p->left = remove(p->left, x);
    else if (x > p->key)
        p->right = remove(p->right, x);
    else
    {
        node *l = p->left;
        node *r = p->right;
        delete p;
        if (l == NULL)
            return r;
        node *m = max(l);
        m->left = remove_max(l);
        m->right = r;
        return do_good(m);
    }
    return do_good(p);
}

bool exists(node *p, int x)
{
    if (p == NULL)
        return false;
    if (p->key == x)
        return true;
    if (x < p->key)
        return exists(p->left, x);
    else
        return exists(p->right, x);
}


int main()
{
    freopen("avlset.in", "r", stdin);
    freopen("avlset.out", "w", stdout);
    int n;
    scanf("%d%*c", &n);
    node *p = NULL;
    for (int i = 0; i < n; i++)
    {
        char c;
        int x;
        scanf("%c%i%*c", &c, &x);
        if (c == 'C')
        {
            if (exists(p, x))
                printf("Y\n");
            else
                printf("N\n");
        } 
        else
        {
            if (c == 'A')
                p = insert(p, x);
            if (c == 'D')
                p = remove(p, x);
            assert(-1 <= balance(p) && balance(p) <= 1);
            printf("%d\n", balance(p));
        }
    }
    return 0;
}

