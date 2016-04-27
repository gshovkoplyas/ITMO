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
 
struct vertex
{
    vector<int> next;
    vector<int> move;
    vector<int> num;
    int suff_link;
    int cool_link;
    bool is_term;
    int parrent;
    int parrent_char;
 
};
 
vector<vertex> bohr;
 
vertex new_vertex(int parrent, int parrent_char)
{
    vertex v;
    v.is_term = false;
    v.suff_link = -1;
    v.cool_link = -1;
    v.next = vector<int>(ALPHABET_SIZE, -1);
    v.move = vector<int>(ALPHABET_SIZE, -1);
    v.num = vector<int>();
    v.parrent = parrent;
    v.parrent_char = parrent_char;
    return v;
}
 
int cnt;
 
void add(char *s)
{
    int v = 0;
    int n = strlen(s);
    for (int i = 0; i < n; i++)
    {
        if (bohr[v].next[(int)(s[i] - 'a')] == -1)
        {
            bohr[v].next[(int)(s[i] - 'a')] = bohr.size();
            bohr.push_back(new_vertex(v, s[i] - 'a'));
        }
        v = bohr[v].next[(int)(s[i] - 'a')];
    }
    bohr[v].is_term = true;
    bohr[v].num.push_back(cnt++);
}
 
int get_auto_move(int v, int c);
 
int get_suff_link(int v)
{
    if (bohr[v].suff_link == -1)
    {
        if (v == 0 || bohr[v].parrent == 0)
            bohr[v].suff_link = 0;
        else
            bohr[v].suff_link = get_auto_move(get_suff_link(bohr[v].parrent), bohr[v].parrent_char);
    }
    return bohr[v].suff_link;
}
 
int get_auto_move(int v, int c)
{
    if (bohr[v].move[c] == -1)
    {
        if (bohr[v].next[c] == -1)
        {
            if (v == 0)
                bohr[v].move[c] = 0;
            else
                bohr[v].move[c] = get_auto_move(get_suff_link(v), c);
        }
        else
            bohr[v].move[c] = bohr[v].next[c];
    }
    return bohr[v].move[c];
}
 
int get_cool_link(int v)
{
    if (bohr[v].cool_link == -1)
    {
        if (get_suff_link(v) == 0)
            bohr[v].cool_link = 0;
        else
        {
            if (bohr[get_suff_link(v)].is_term)
                bohr[v].cool_link = get_suff_link(v);
            else
                bohr[v].cool_link = get_cool_link(get_suff_link(v));
        }
    }
    return bohr[v].cool_link;
}
 
vector<bool> was;
 
void check(int v)
{
    for (int u = v; u != 0; u = get_cool_link(u)){
        if (bohr[u].is_term)
            for (int i = 0; i < (int)bohr[u].num.size(); i++)
                was[bohr[u].num[i]] = true;
    }
}
 
void find(char *s)
{
    int n = strlen(s);
    int v = 0;
    for (int i = 0; i < n; i++)
    {
        v = get_auto_move(v, s[i] - 'a');
        check(v);
    }
}
 
char str[2000000];
 
int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    bohr.push_back(new_vertex(-1, 0));
    int n;
    scanf("%d%*c", &n);
    cnt = 0;
    for (int i = 0; i < n; i++)
    {
        gets(str);
        add(str);
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