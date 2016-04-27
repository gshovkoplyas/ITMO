#include<bits/stdc++.h>
using namespace std;

int n;
vector<vector<int>> tree;
vector<int> num;
map<int, int> var;
vector<vector<int>> new_tree;


bool is_leaf(int v) 
{   
    return tree[v].size() == 0;
}

void dfs(int v, int prev) 
{
    if (is_leaf(v))
        return;
    if (var[num[v]] == 0)
    {
        new_tree[v] = tree[v];
        var[num[v]] = -1;
        dfs(tree[v][0], v);
        var[num[v]] = 1;
        dfs(tree[v][1], v);
        var[num[v]] = 0;
    } 
    else if (var[num[v]] == -1) 
    {
        if (new_tree[prev][0] == v) 
            new_tree[prev][0] = tree[v][0];
        else if (new_tree[prev][1] == v) 
            new_tree[prev][1] = tree[v][0];
        dfs(tree[v][0], prev);  
    } 
    else 
    {
        if (new_tree[prev][0] == v) 
            new_tree[prev][0] = tree[v][1];
        else if (new_tree[prev][1] == v) 
            new_tree[prev][1] = tree[v][1]; 
        dfs(tree[v][1], prev);
    }
}

int main() 
{
    freopen("trees.in", "r", stdin);
    freopen("trees.out", "w", stdout);
    scanf("%d\n", &n);
    if (n == 1)
    {
        string s;
        int tmp;
        cin >> s;
        cin >> tmp;
        cout << 1 << endl << s << ' ' << tmp << endl;
        return 0;
    }
    tree.resize(n);
    num.resize(n);
    new_tree.resize(n);
    for (int i = 0; i < n; i++)
    {
        char s[10];
        int tmp;
        scanf("%s%d\n", s, &tmp);
        num[i] = tmp;
        if (s[0] == 'c')
        {
            int child1, child2;
            cin >> child1 >> child2;
            tree[i].push_back(child1 - 1);
            tree[i].push_back(child2 - 1);
        }    

    }
    /*for (int i = 0; i < n; i++)
    {
        cout << i << ": ";
        for (int j = 0; j < (int)tree[i].size(); j++)
            cout << tree[i][j] << ' ';
        cout << endl;
    }
    cout << endl; */
    dfs(0, -1);
    /*for (int i = 0; i < n; i++)
    {
        cout << i << ": ";
        for (int j = 0; j < (int)new_tree[i].size(); j++)
            cout << new_tree[i][j] << ' ';
        cout << endl;
    } */
    vector<bool> used(n, false);
    for (int i = 0; i < n; i++)
        if (new_tree[i].size())
        {
            used[i] = true;
            used[new_tree[i][0]] = true;
            used[new_tree[i][1]] = true;
        }
    vector<int> new_i(n);
    int cnt = 1;
    for (int i = 0; i < n; i++)
        if (used[i])
            new_i[i] = cnt++;
    cout << cnt - 1 << endl; 
    for (int i = 0; i < n; i++)
        if (used[i])
        {
            if ((int)new_tree[i].size() == 0)
                cout << "leaf " << num[i] << endl;
            else
                cout << "choice " << num[i] << ' ' << new_i[new_tree[i][0]] << ' ' << new_i[new_tree[i][1]] << endl;   
        }
    return 0;
}