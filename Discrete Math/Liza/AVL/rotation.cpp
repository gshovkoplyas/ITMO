#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
#include <iostream>
using namespace std;

const int MAXN = 200005;
int data[MAXN], left_son[MAXN], right_son[MAXN];

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

node *min(node *p)
{
    if (p->left == NULL)
        return p;
    return min(p->left);
}

node *remove_min(node *p)
{
    if (p->left == NULL)
        return p->right;
    p->left = remove_min(p->left);
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
        if (r == NULL)
            return l;
        node *m = min(r);
        m->right = remove_min(r);
        m->left = l;
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

int ans(node *p, int i = 0)
{
    if (p != NULL)
    {
        int res = i;
        left_son[i] = -1;
        if (p->left != NULL)
            left_son[i] = res + 1, res = ans(p->left, res + 1);
        data[i] = p->key;
        right_son[i] = -1;
        if (p->right != NULL)
            right_son[i] = res + 1, res = ans(p->right, res + 1);
        return res;
    }
    return i - 1;
}

node *build_tree(node *p, int i)
{
    p = new node(data[i]);
    if (left_son[i] != -1)
        p->left = build_tree(p->left, left_son[i]);
    if (right_son[i] != -1)
        p->right = build_tree(p->right, right_son[i]);
    correct_height(p);
    return p;
}


int main()
{
    freopen("rotation.in", "r", stdin);
    freopen("rotation.out", "w", stdout);
    int n;
    scanf("%d%*c", &n);
    node *p = NULL;
    for (int i = 0; i < n; i++)
    {
        scanf("%d%d%d", &data[i], &left_son[i], &right_son[i]);
        left_son[i]--;
        right_son[i]--;
    }
    p = build_tree(p, 0);
    p = do_good(p);
    int k = ans(p);
    printf("%d\n", k + 1);
    for (int i = 0; i < k + 1; i++)
        printf("%d %d %d\n", data[i], left_son[i] + 1, right_son[i] + 1);
    return 0;
}

