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

#define taskname "set"

const int module = 239017;

vector<vector<pair<int, bool> > > hash_table;

int get_hash(int n)
{
    return abs(n) % module;
}
int find(int n)
{
	int k = get_hash(n), i = 0;
    while(i < (int)hash_table[k].size() && hash_table[k][i].first != n)
    	i++;
    return i;
}

int main()
{
	freopen(taskname".in", "r", stdin);
	freopen(taskname".out", "w", stdout);
	hash_table.resize(module);
	char request[30];
	int key;
	while (scanf("%s %i%*c", request, &key) > 0)
	{
	    int hash = get_hash(key);
		int index = find(key);
		switch(request[0])
		{
			case 'e':
				if(index == (int)hash_table[hash].size() || !hash_table[hash][index].second)
					printf("false\n");
				else
					printf("true\n");
				break;
		 	case 'i':
		 		if(index == (int)hash_table[hash].size())
		 			hash_table[hash].push_back(make_pair(key, true));
		 		else 
		 			hash_table[hash][index].second = true;
		   		break;	
		   	case 'd':
		 		if(index < (int)hash_table[hash].size())
		 			hash_table[hash][index].second = false;
		   		break;	
		}
	}
	return 0;
}