#include<bits/stdc++.h>
using namespace std;

const int ALPH_SIZE = 'z' - 'a' + 1;
const int MAXN = (int)2e4;
const double EPS = 1e-12;

char in[MAXN];
double out[MAXN];

vector<vector<double>> f;

int main() 
{
    freopen("continuous.in", "r", stdin);
    freopen("continuous.out", "w", stdout);
    int n, m;
    scanf("%d%d", &n, &m);
    vector<vector<int>> g(n);
    for (int i = 0; i < n; i++)
    {
        int a, b;
        scanf("%d%d", &a, &b);
        g[i].push_back(a - 1);
        g[i].push_back(b - 1);
    }

    f.assign(2 * n + 1, vector<double>(2 * n + 1, 0));
    for (int i = 0; i < m; i++)
    {
        int len;
        scanf("%d %s", &len, in);
        for (int j = 0; j < len; j++)
            cin >> out[j];
        /*printf("%d %s\n", len, in);
        for (int j = 0; j < len; j++)
            printf("%f\n", out[j]);  */
        
        int cur = 0;
        vector<int> res;
        for (int j = 0; j < len; j++) 
        {
            res.push_back(2 * cur + in[j] - '0');
            for (int ii = 0; ii < (int)res.size(); ii++)
            {    
                for (int jj = 0; jj < (int)res.size(); jj++)
                    f[res[ii]][res[jj]] += (double)2 / len;
                f[res[ii]][2 * n] += (double)2 / len * out[j];
            }
            cur = g[cur][in[j] - '0'];
        }
    }
    /*for (int i = 0; i < 2 * n + 1; i++)
    {
        for (int j = 0; j < 2 * n + 1; j++)
            printf("%.5f ", f[i][j]);
        cout << endl;
    } */
    //Gauss
    vector<int> where(2 * n, -1);
    for (int col = 0, row = 0; col < 2 * n && row < 2 * n; col++) 
    {
        int sel = row;
        for (int i = row; i < 2 * n; i++)
            if (fabs(f[i][col]) > fabs(f[sel][col]))
                sel = i;
        if (fabs(f[sel][col]) < EPS)
            continue;
        for (int i = col; i <= 2 * n; i++)
            swap(f[sel][i], f[row][i]);
        where[col] = row;
        for (int i = 0; i < 2 * n; i++)
            if (i != row) 
            {
                double c = f[i][col] / f[row][col];
                for (int j = col; j <= 2 * n; j++)
                    f[i][j] -= f[row][j] * c;
            }
        row++;
    }      
    /*for (int k = 0; k < (int)where.size(); k++)
        cout << where[k] << ' ';
    cout << endl;*/                        
    
    vector<double> ans(2 * n + 1, 0);
    for (int i = 0; i < 2 * n; i++)
        if (where[i] != -1)
            ans[i] = f[where[i]][2 * n] / f[where[i]][i];
    for (int i = 0; i < 2 * n; i++) {
        double sum = 0;
        for (int j = 0; j <= 2 * n; j++)
            sum += ans[j] * f[i][j];
    }
    for (int i = 0; i < n; i++)
        printf("%.15f %.15f\n", ans[2 * i], ans[2 * i + 1]);
    return 0;
}