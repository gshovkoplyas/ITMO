#include <vector>
//#include <iostream>
#include <fstream>
using namespace std;
  
int main()
{   ifstream cin("pathmgep.in");
    ofstream cout("pathmgep.out");
    int f, n, s,im;
    cin >> n;
    cin >> s;
    cin >> f;
    vector <bool> used;
    vector <long long> d;
    vector <int> p(n);
    vector <vector <int> > g(n);
    im = 2000000;
    used.assign(n, 0);
    d.assign(n, im);
    d[s-1] = 0;
    for(int i=0; i < n; i++)
        g[i].assign(n, 0);
     
    for(int i=0; i < n; i++)
        for(int j=0; j < n; j++)
            cin >> g[i][j];
     
    for(int i=0; i < n; i++)
    {
        int v = -1;
        for(int j=0; j < n; j++)
            if(used[j] == false && (v == -1 || d[j] < d[v]))
                v = j;
        used[v] = true;
        for   (   int    j   =   0;    j    <   n;    j++  )
            if (g[v][j]  !=  -1  &&  d[v] + g[v][j] < d[j] )
            {
                p[j] = v;
                d[j] = d[v]+g[v][j];
            }
    }
    if(d[f-1] != im)
        cout << d[f-1] << endl;
    else
        cout << -1 << endl;
    cin.close();
    cout.close();
    return 0;
}