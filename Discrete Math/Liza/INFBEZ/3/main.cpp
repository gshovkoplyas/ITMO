#define _CRT_SECURE_NO_WARNINGS
#include <fstream>
#include <iostream>
#include <cstdio>
#include <string>

using namespace std;

void Generator(int *z,int n,int r,int *c,int *b)
{
    do
    {
        r++;
        int d=0;
        for(int j=0;j<r;j++) d^=c[j]*z[r-j];
        if(d==0)
        {
            for(int j=r;j>0;j--) b[j]=b[j-1];
            b[0]=0;
        }
        else
        {
            int *t=new int[r+1];
            int *tmpb=new int[r+1];
            tmpb[0]=0;
            for(int j=1;j<r+1;j++) tmpb[j]=b[j-1];
            for(int j=0;j<r+1;j++) t[j]=c[j]^tmpb[j];
            for(int j=0;j<r+1;j++) b[j]=c[j];
            for(int j=0;j<r+1;j++) c[j]=t[j];
        }
    } while (r<n);
}

int main()
{
    string s;
    ifstream fin("rand13.txt");
    getline(fin,s,'\n');
    cerr << 0;
    int n=1;
    int *z=new int[s.length()];
    cerr << 0.5;
    for(int i=0;i<s.length();i++)
    {
        if(s[i]=='0')
        {
            z[n]=0;
            n++;
        }
        if(s[i]=='1')
        {
            z[n]=1;
            n++;
        }
    }
    int *c=new int[n];
    int *b=new int[n];
    c[0]=1;
    b[0]=1;
    for(int i=1;i<n-1;i++)
    {
        c[i]=0;
        b[i]=0;
    }
    cerr << 1;
    Generator(z,n-1,0,c,b);
    cerr << 2;
    printf("c(x) = ");
    if(c[0]==1)
    {       
        printf("1");
        for(int i=1;i<n-1;i++)
            if(c[i]==1) printf(" + x^%d",i);        
    }
    else
    {
        for(int i=1;i<n-1;i++)
            if(c[i]==1) printf("x^%d + ",i);
    }
    printf("\n");
    return 0;
}