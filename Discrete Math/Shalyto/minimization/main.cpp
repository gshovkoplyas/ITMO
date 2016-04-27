#include<bits/stdc++.h>
using namespace std;

const int MAX_SEG = 20;
const int MAX_IT = 20;
const double EPS = 1e-4;
const double INF = 1e18;

void print(vector<double> &x) 
{
    for (auto x_i : x)
        cout << x_i << ' ';
    cout << endl;
    cout.flush();
}

int main() 
{
    int n;
    cin >> n;
    vector<double> x(n, 0);
    cout.precision(5);
    cout << fixed;
    for (int i = 0; i < n; i++)
    {
        double minn = INF;
        double minx = -1;
        for (int j = 0; j < MAX_SEG; j++)
        {
            double l = (double)j / MAX_SEG;
            double r = (double)(j + 1) / MAX_SEG;
            for (int k = 0; k < MAX_IT; k++) 
            {
                double m1 = l + (r - l) / 3;
                double m2 = r - (r - l) / 3;
                double f1, f2;
                x[i] = m1;
                print(x);
                cin >> f1;
                x[i] = m2;
                print(x);
                cin >> f2;
                if (f1 > f2)
                    l = m1;
                else
                    r = m2;
                if (f1 < minn)
                    minn = f1, minx = m1;
                if (f2 < minn)
                    minn = f2, minx = m2;
            }
        }
        x[i] = minx;
    }
    double ans; 
    print(x);
    cin >> ans;
    cout.flush();
    cout << "minimum " << ans << endl;
    cout.flush();        
    return 0; 
}