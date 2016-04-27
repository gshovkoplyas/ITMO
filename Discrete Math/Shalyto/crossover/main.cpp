#include<bits/stdc++.h>
using namespace std;

int main() 
{
    freopen("crossover.in", "r", stdin);
    freopen("crossover.out", "w", stdout);
    int n, m;
    cin >> m >> n;
    vector<string> a(m);
    for (int i = 0; i < m; i++)
        cin >> a[i];
    string s;
    cin >> s;
    bool one_point = false, two_point = false, other = false;
    for (int i = 0; i < m; i++)
        if (a[i] == s)
        {
            cout << "YES" << endl;
            cout << "YES" << endl;
            cout << "YES" << endl;
            return 0;
        }
    for (int i = 0; i < m; i++)
        for (int j = i + 1; j < m; j++)
        {
            // one point
            for (int k = 0; k < n; k++)
            {
                bool ok1 = true;
                bool ok2 = true;
                for (int ii = 0; ii < k && ok1 && ok2; ii++)
                    if (a[i][ii] != s[ii])
                        ok1 = false;
                for (int ii = k; ii < n && ok1 && ok2; ii++)
                    if (a[j][ii] != s[ii])
                        ok2 = false;
                if (ok1 && ok2)
                    one_point = true;

                ok1 = true;
                ok2 = true;
                for (int ii = 0; ii < k && ok1 && ok2; ii++)
                    if (a[j][ii] != s[ii])
                        ok1 = false;
                for (int ii = k; ii < n && ok1 && ok2; ii++)
                    if (a[i][ii] != s[ii])
                        ok2 = false;
                if (ok1 && ok2)
                    one_point = true;
            }
            // two point
            for (int k = 0; k < n; k++)
                for (int l = k + 1; l < n; l++)
                {
                    bool ok1 = true;
                    bool ok2 = true;
                    bool ok3 = true;
                    for (int ii = 0; ii < k && ok1 && ok2 && ok3; ii++)
                        if (a[i][ii] != s[ii])
                            ok1 = false;
                    for (int ii = k; ii < l && ok1 && ok2 && ok3; ii++)
                        if (a[j][ii] != s[ii])
                            ok2 = false;
                    for (int ii = l; ii < n && ok1 && ok2 && ok3; ii++)
                        if (a[i][ii] != s[ii])
                            ok3 = false;
                    if (ok1 && ok2 && ok3)
                        two_point = true;

                    ok1 = true;
                    ok2 = true;
                    ok3 = true;
                    for (int ii = 0; ii < k && ok1 && ok2 && ok3; ii++)
                        if (a[j][ii] != s[ii])
                            ok1 = false;
                    for (int ii = k; ii < l && ok1 && ok2 && ok3; ii++)
                        if (a[i][ii] != s[ii])
                            ok2 = false;
                    for (int ii = l; ii < n && ok1 && ok2 && ok3; ii++)
                        if (a[j][ii] != s[ii])
                            ok3 = false;
                    if (ok1 && ok2 && ok3)
                        two_point = true;
                    
                }
            //other
            bool cur = true;
            for (int k = 0; k < n; k++)
                if (a[i][k] != s[k] && a[j][k] != s[k])
                    cur = false;
            other |= cur;
        }
    cout << (one_point ? "YES" : "NO") << endl;
    cout << (two_point ? "YES" : "NO") << endl;
    cout << (other ? "YES" : "NO") << endl;
    return 0;
}