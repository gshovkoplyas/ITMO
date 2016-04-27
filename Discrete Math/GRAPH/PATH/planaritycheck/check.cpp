#include<string>
#include<iostream>
#include<cstdio>
using namespace std;

int main() 
{
    FILE *f1 = fopen("planaritycheck.out", "r");
    FILE *f2 = fopen("stress.out", "r");
    char c1 = ' ', c2 = ' ';
    int i = -1;
    while (c1 == c2)
    {
        char s1[20];
        char s2[20];
        fscanf(f1, "%s", s1);
        fscanf(f2, "%s", s2);
        c1 = s1[0];
        c2 = s2[0];
        i++;
    }
    cout << i;
    return 0;
}