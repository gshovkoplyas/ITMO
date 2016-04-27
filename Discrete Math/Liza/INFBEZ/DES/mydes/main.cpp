/*Liza is so cute*/
#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <iostream>
#include <cmath>
#include <vector>
#include <string>
#include "des.h"
using namespace std;

int main()
{
	freopen("out.txt", "wt", stdout);
	vector<vector<bool> > data = read_text("input.txt");
	vector<bool> key = read_key("key.txt");
	cout << "first bit block of the input text:" << endl;
	for (int j = 0; j < (int)data[0].size(); j++)
		cout << (int)data[0][j];
	cout << endl;
	data = encrypt(data, key);
	cout << "first bit block after encryption:" << endl;
	for (int j = 0; j < (int)data[0].size(); j++)
		cout << (int)data[0][j];
	cout << endl;
	cout << "first bit block after decryption:" << endl;
	data = decrypt(data, key);
	for (int j = 0; j < (int)data[0].size(); j++)
		cout << (int)data[0][j];
	cout << endl;
	cout << "decrypted text:" << endl;
	for (int i = 0; i < (int)data.size(); i++)
		cout << bit_vector_to_string(data[i]);
	cout << endl;
	return 0;
}