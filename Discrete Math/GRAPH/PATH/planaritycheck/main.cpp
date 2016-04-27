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

#define taskname "planaritycheck"


bool is_k5(vector<vector<int> > g)
{
    for (int i = 0; i < 5; i++)
        for (int j = i + 1; j < 5; j++)
            if (g[i][j] != 1)
                return false;
    return true;
}

bool is_k33(vector<vector<int> > g)
{
    for (int x = 0; x < 6; x++)
        for (int y = x + 1; y < 6; y++)
            for (int z = y + 1; z < 6; z++)
            {
                vector<int> a, b;
                for (int i = 0; i < 6; i++)
                    if (i == x || i == y || i == z)
                        a.push_back(i);
                    else
                        b.push_back(i);
                /*bool is_bin = true;
                for (int i = 0; i < 3; i++)
                    for (int j = i + 1; j < 3; j++)
                        if (g[a[i]][a[j]] || g[b[i]][b[j]])
                            is_bin = false;
                if (!is_bin)
                    continue;*/
                bool k33 = true;
                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++)
                        if (!g[a[i]][b[j]])
                            k33 = false;
                if (k33)
                    return true;

            }
    return false;
}

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    int t;
    cin >> t;
    while (t--)
    {
        string s;
        cin >> s;
        int n = 1;
        while (n * (n - 1) != 2 * (int)s.size())
            n++;
        vector<vector<int> > g(n, vector<int>(n, 0));
        int k = 0;
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                g[i][j] = g[j][i] = s[k++] - '0';
        /*for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
                cout << g[i][j];
            cout << endl;
        }
        cout << endl;*/
        if (n < 5)
            printf("YES\n");
        else if (n == 5)
        {
            if (is_k5(g))
                printf("NO\n");
            else
                printf("YES\n");
        } else 
        {
            if (is_k33(g))
                printf("NO\n");
            else
            {
                bool has_k5 = false;
                for (int x = 0; x < 6; x++)
                {
                    vector<vector<int> > new_g(5, vector<int>(5, 0));
                    for (int i = 0; i < 6; i++)
                        for (int j = i + 1; j < 6; j++)
                        {
                            if (i == x || j == x)
                                continue;
                            int a = i;
                            int b = j;
                            if (a > x)
                                a--;
                            if (b > x)
                                b--;
                            new_g[a][b] = new_g[b][a] = g[i][j];
                        }
                    if (is_k5(new_g))
                        has_k5 = true;
                }
                for (int x = 0; x < 6; x++)
                    for (int y = 0; y < 6; y++)
                        for (int z = y + 1; z < 6; z++)
                            if (g[x][y] && g[x][z])
                            {
                                vector<vector<int> > new_g(5, vector<int>(5, 0));
                                for (int i = 0; i < 6; i++)
                                    for (int j = i + 1; j < 6; j++)
                                    {
                                        if (i == x || j == x)
                                            continue;
                                        int a = i;
                                        int b = j;
                                        if (a > x)
                                            a--;
                                        if (b > x)
                                            b--;
                                        new_g[a][b] = new_g[b][a] = g[i][j];
                                    }
                                int a = y;
                                int b = z;
                                if (a > x)
                                    a--;
                                if (b > x)
                                    b--;
                                new_g[a][b] = new_g[b][a] = 1;
                                if (is_k5(new_g))
                                    has_k5 = true;
                            }
                if (has_k5)
                    printf("NO\n");
                else
                    printf("YES\n");
            }

        }
    }
    return 0;           
}