#ifndef DES_H
#define DES_H

#define _CRT_SECURE_NO_WARNINGS
#include <vector>
#include <string>
using namespace std;

vector<vector<bool> > read_text(char *file_name);
vector<bool> read_key(char *s);
vector<vector<bool> > encrypt(vector<vector<bool> > data, vector<bool> key);
vector<vector<bool> > decrypt(vector<vector<bool> > data, vector<bool> key);
string bit_vector_to_string(vector<bool> v);


#endif // DES_H
