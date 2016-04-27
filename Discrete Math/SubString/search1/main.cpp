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

#define taskname "search1"

int main()
{
    freopen(taskname".in", "r", stdin);
    freopen(taskname".out", "w", stdout);
    string a, b;
    cin >> a >> b;
    int n = a.size();
    int m = b.size();
    vector<int> ans;
    for (int i = 0; i + n - 1 < m; i++)
    {
        bool isOk = true;    
        for (int j = 0; j < n; j++)
        {
            if (a[j] != b[i + j])
            {
                isOk = false;
                break;
            }   
        }
        if (isOk)
            ans.push_back(i + 1);
    }
    cout << ans.size() << endl;
    for (int i = 0; i < (int)ans.size(); i++)
        cout << ans[i] << ' ';
    cout << endl;
    return 0;
}