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

#define taskname "prefix"

vector<int> prefix_function(string s)
{
    vector<int> p(s.size(), 0);
    for (int i = 1; i < (int)s.size(); i++)
    {
        int prev = p[i - 1];
        while (prev > 0 && s[i] != s[prev])
            prev = p[prev - 1];
        if (s[i] == s[prev])
            prev++;
        p[i] = prev;
    }
    return p;
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    string a;
    cin >> a;
    vector<int> p = prefix_function(a);
    for (int i = 0; i < (int)p.size(); i++)
        cout << p[i] << ' ';
    cout << endl;
    return 0;
}