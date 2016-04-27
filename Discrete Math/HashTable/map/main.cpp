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

#define taskname "map"

const int module = 239017;
const int p = 37;

vector<vector<pair<pair<string, string>, bool> > > hash_table;

int get_hash(string s)
{
	int hash = 0;
	for(int i = 0; i < (int)s.size(); i++)
		hash = (((long long)hash * p) + s[i]) % 239017;
	return hash;
}

int find(string s)
{
	int k = get_hash(s), i = 0;
    while(i < (int)hash_table[k].size() && hash_table[k][i].first.first != s)
    	i++;
    return i;
}

int main()
{
	freopen(taskname".in", "r", stdin);
	freopen(taskname".out", "w", stdout);
	hash_table.resize(module);
	string request, key, data;
	while (cin >> request)
	{
	    cin >> key;
	    int hash = get_hash(key);
		int index = find(key);
		switch(request[0])
		{
			case 'g':
				if(index == (int)hash_table[hash].size() || !hash_table[hash][index].second)
					printf("none\n");
				else
					cout << hash_table[hash][index].first.second << endl;
				break;
		 	case 'p':
		 		cin >> data;
		 		if(index == (int)hash_table[hash].size())
		 			hash_table[hash].push_back(make_pair(make_pair(key, data), true));
		 		else 
		 			hash_table[hash][index].second = true, hash_table[hash][index].first.second = data;
		   		break;	
		   	case 'd':
		 		if(index < (int)hash_table[hash].size())
		 			hash_table[hash][index].second = false;
		   		break;	
		}
	}
	return 0;
}