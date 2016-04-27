#define _CRT_SECURE_NO_WARNINGS
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

#define taskname "search4"

const size_t ALPHABET_SIZE = 26;

struct vertex {
    int next[ALPHABET_SIZE], go[ALPHABET_SIZE]; 
    vector<int> num;
    bool is_term, was;
    int p, link;
    char pch;
    int up;
};

vertex new_vertex()
{
    vertex res;
    memset (res.next, 255, sizeof(res.next));
    memset (res.go, 255, sizeof(res.go));
    res.num = vector<int>();
    res.p = res.link = res.up = -1;
    res.is_term = false;
    res.was = false;
    return res;
}

vector<vertex> bohr;

void add(char *s, int num) 
{
    int v = 0;
    int n = strlen(s);
    for (int i = 0; i < n; i++)
    {
        char c = s[i] - 'a';
        if (bohr[v].next[c] == -1)
        {
            int k = bohr.size();
            bohr[v].next[c] = k;
            bohr.push_back(new_vertex());
            bohr[k].p = v;
            bohr[k].pch = c;
        }
        v = bohr[v].next[c];
    }
    bohr[v].num.push_back(num);
    bohr[v].is_term = true;
}

int go(int v, char c);

int get_link(int v) {
    if (bohr[v].link == -1)
    {
        if (v == 0 || bohr[v].p == 0)
            bohr[v].link = 0;
        else
            bohr[v].link = go(get_link(bohr[v].p), bohr[v].pch);
    }
    return bohr[v].link;
}

int go(int v, char c)
{
    if (bohr[v].go[c] == -1)
    {
        if (bohr[v].next[c] != -1)
            bohr[v].go[c] = bohr[v].next[c];
        else
        {
            if (v == 0)
                bohr[v].go[c] = 0;
            else
                bohr[v].go[c] = go(get_link(v), c);
        }
    }
    return bohr[v].go[c];
}

int get_up(int v)
{
    if (bohr[v].up == -1)
    {
        if (bohr[get_link(v)].is_term)
            bohr[v].up = get_link(v);
        else if (v == 0) 
            bohr[v].up = 0;
        else
            bohr[v].up = get_up(get_link(v));
    }
    return bohr[v].up; 
}

char str[2000000];
vector<bool> was;

void check(int v)
{
    for (int u = v; u != 0; u = get_up(u))
    {
        if (bohr[u].was)
            return;
        if (bohr[u].is_term) 
            for (int i = 0; i < (int)bohr[u].num.size(); i++)
                was[bohr[u].num[i]] = true;
        bohr[u].was = true;
    }
}

void find(char *s)
{
    int n = strlen(s);
    int v = 0;
    for (int i = 0; i < n; i++)
    {
        v = go(v, s[i] - 'a');
        check(v);
    }
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    bohr.push_back(new_vertex()); //bohr init
    int n;
    scanf("%d%*c", &n);
    for (int i = 0; i < n; i++)
    {
        gets(str);
        add(str, i);
    }
    gets(str);
    was.assign(n, false);
    find(str);
    for (int i = 0; i < n; i++)
    {
        if (was[i])
            printf("YES\n");
        else
            printf("NO\n");
    }
    return 0;
}