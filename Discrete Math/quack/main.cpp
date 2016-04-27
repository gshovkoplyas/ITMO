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
 
#define taskname "quack"
 
queue<unsigned short> q;
unsigned short reg[26];
vector<string> s;
map<string, int> link;
 
int main()
{
  freopen(taskname".in", "r", stdin);
  freopen(taskname".out", "w", stdout);
  string str;
  while(getline(cin, str) > 0) 
  {
    s.push_back(str);
    if(str[0] == ':')
    {
      string l = str.substr(1, str.size() - 1);
      link[l] = s.size() - 1;
    }
  }
  for(int i = 0; i < (int)s.size(); i++)
  {
    char c = s[i][0];
    if(c >= '0' && c <= '9')
    {
      unsigned short num = 0;
      for(int j = 0; j < (int)s[i].size(); j++)
        num = num * 10 + (s[i][j] - '0');  
      q.push(num);
      continue;
    }
    if(c == '+' || c == '-' || c == '*' || c == '/' || c == '%')
    {
      unsigned short a, b, result;
      a = q.front();
      q.pop();
      b = q.front();
      q.pop();
      if(c == '+')
        result = a + b;
      if(c == '-')
        result = a - b;
      if(c == '*')
        result = a * b;
      if(c == '/')
        result = (b == 0) ? b : a / b;
      if(c == '%')
        result = (b == 0) ? b : a % b;
      q.push(result);
      continue;
    }
    if(c == '>')
    {
      int r = s[i][1] - 'a';
      reg[r] = q.front();
      q.pop();
      continue;
    }
    if(c == '<')
    {
      int r = s[i][1] - 'a';
      q.push(reg[r]);
      continue;
    }
    if(c == 'P')
    {
      if(s[i].size() == 1)
      {
        unsigned short a = q.front();
        q.pop();
        printf("%i\n", a);
      }
      else
      {
        int r = s[i][1] - 'a';
        unsigned short a = reg[r];
        printf("%i\n", a);
      }
      continue;
    }
    if(c == 'C')
    {
      if(s[i].size() == 1)
      {
        unsigned short a = q.front();
        q.pop();
        printf("%c", a % 256);
      }
      else
      {
        int r = s[i][1] - 'a';
        unsigned short a = reg[r];
        printf("%c", a % 256);
      }
      continue;
    }
    if(c == 'J')
    {
      string l = s[i].substr(1, s[i].size() - 1);
      i = link[l];
      continue;
    }
    if(c == 'Z')
    {
      int r = s[i][1] - 'a';
      if(reg[r] == 0)
      {
        string l = s[i].substr(2, s[i].size() - 2);
        i = link[l];
      }
      continue;
    }
    if(c == 'E')
    {
      int r1 = s[i][1] - 'a';
      int r2 = s[i][2] - 'a';
      if(reg[r1] == reg[r2])
      {
        string l = s[i].substr(3, s[i].size() - 3);
        i = link[l];
      }
      continue;
    }
    if(c == 'G')
    {
      int r1 = s[i][1] - 'a';
      int r2 = s[i][2] - 'a';
      if(reg[r1] > reg[r2])
      {
        string l = s[i].substr(3, s[i].size() - 3);
        i = link[l];
      }
      continue;
    }
    if(c == 'Q')
      return 0;
  }
  return 0;
}