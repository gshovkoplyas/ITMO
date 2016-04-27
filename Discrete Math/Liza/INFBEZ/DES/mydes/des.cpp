#include "des.h"
#include <iostream>
#include <vector>
#include <string>
#include <cstdio>
using namespace std;

vector<bool> char_to_bit_vector(char c)
{
	vector<bool> res;
	for (int i = 128; i > 0; i /= 2)
		res.push_back((c & i) != 0);
	return res;
}

char bit_vector_to_char(vector<bool> v)
{
	char c = 0;
	for (int i = 0; i < (int)v.size(); i++)
		c += (int)v[i] << (v.size() - i - 1);
	return c;
}

string bit_vector_to_string(vector<bool> v)
{
	vector<bool> cur;
	string res = "";
	for (int i = 0; i < (int)v.size(); i++)
	{
		cur.push_back(v[i]);
		if ((int)cur.size() == 8)
		{
			char c = bit_vector_to_char(cur);
			if (c != 0)
				res += c;
			cur.clear();
		}
	}
	return res;
}

vector<bool> add_vector(vector<bool> a, vector<bool> b)
{
	for (int i = 0; i < (int)b.size(); i++)
		a.push_back(b[i]);
	return a;
}

vector<vector<bool> > read_text(char *s)
{
	vector<vector<bool> > res;
	vector<bool> cur_block;
	FILE *text = fopen(s, "rt");
	char c;
	while (fscanf(text, "%c", &c) > 0)
	{
		cur_block = add_vector(cur_block, char_to_bit_vector(c));
		if (cur_block.size() == 64)
		{
			res.push_back(cur_block);
			cur_block.clear();
		}
	}
	if (!cur_block.empty())
	{
		for (int i = cur_block.size(); i < 64; i++)
			cur_block.push_back(0);
		res.push_back(cur_block);
	}
	return res;
}


vector<bool> read_key(char *s)
{
	vector<bool> res;
	FILE *key = fopen(s, "rt");
	char c;
	while (fscanf(key, "%c", &c) > 0)
	{
		res = add_vector(res, char_to_bit_vector(c));
		if (res.size() == 64)
			break;
	}
	while (res.size() < 64)
		res.push_back(0);
	return res;
}


vector<bool> shuffle_one(vector<bool> block)
{
	int ip[64] = { 58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4,
				   62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8,
		           57, 49, 41, 33, 25, 17,  9, 1, 59, 51, 43, 35, 27, 19, 11, 3,
          		   61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7 };

	vector<bool> res(64);
	for (int i = 0; i < 64; i++)
		res[i] = block[ip[i] - 1];
	return res;
}

vector<bool> shuffle_end(vector<bool> block)
{
	int ip[64] = { 40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31,
				   38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, 13, 53, 21, 61, 29,
				   36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51, 19, 59, 27,
		           34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41,  9, 49, 17, 57, 25};
	vector<bool> res(64);
	for (int i = 0; i < 64; i++)
		res[i] = block[ip[i] - 1];
	return res;
}

vector<bool> key56(vector<bool> key)
{
	int c0d0[56] = { 57, 49, 41, 33, 25, 17,  9,  1, 58, 50, 42, 34, 26, 18, //c0
					 10,  2, 59, 51, 43, 35, 27, 19, 11,  3, 60, 52, 44, 36,
		     		 63, 55, 47, 39, 31, 23, 15,  7, 62, 54, 46, 38, 30, 22, //d0
					 14,  6, 61, 53, 45, 37, 29, 21, 13,  5, 28, 20, 12,  4 };
	vector<bool> res(56);
	for (int i = 0; i < 56; i++)
		res[i] = key[c0d0[i] - 1];
	return res;
}

vector<bool> key48(vector<bool> key)
{
	int p[48] = { 14, 17, 11, 24,  1,  5,  3, 28, 15,  6, 21, 10, 23, 19, 12, 4,
				  26,  8, 16,  7, 27, 20, 13,  2, 41, 52, 31, 37, 47, 55, 30, 40,
		          51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32 };
	vector<bool> res(48);
	for (int i = 0; i < 48; i++)
		res[i] = key[p[i] - 1];
	return res;
}

vector<bool> shift_key(vector<bool> key, int k)
{
	int shift[16] = { 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1 };
	vector<bool> c = key, d;
	c.resize(28);				  // c <- key[0:27]
	for (int i = 28; i < 56; i++) // d <- key[28:55]
		d.push_back(key[i]);
	rotate(c.begin(), c.begin() + shift[k], c.end());
	rotate(d.begin(), d.begin() + shift[k], d.end());
	return add_vector(c, d);
}

vector<bool> xor(vector<bool> a, vector<bool> b)
{
	vector<bool> res(a.size());
	for (int i = 0; i < (int)res.size(); i++)
		res[i] = (bool)(a[i] ^ b[i]);
	return res;
}

vector<bool> expansion(vector<bool> block)
{
	int e[48] = { 32,  1,  2,  3,  4,  5,
				   4,  5,  6,  7,  8,  9,
				   8,  9, 10, 11, 12, 13,
		          12, 13, 14, 15, 16, 17,
		          16, 17, 18, 19, 20, 21,
		          20, 21, 22, 23, 24, 25,
		          24, 25, 26, 27, 28, 29,
		          28, 29, 30, 31, 32, 1 };
	vector<bool> res(48);
	for (int i = 0; i < 48; i++)
		res[i] = block[e[i] - 1];
	return res;
}

vector<bool> conversion_s(vector<bool> block)
{
	int s[8][4][16] = {
		//s1
		{ { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7 },
		  { 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8 },
		  { 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0 },
		  { 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 } },
		//s2
		{ { 15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10 },
	 	  { 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5 },
		  { 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15 },
		  { 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9 } },
		//s3
		{ { 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8 },
		  { 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1 },
		  { 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7 },
	   	  { 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12 } },
		//s4
		{ { 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 1, 12, 4, 15 },
   		  { 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9 },
	   	  { 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4 },
		  { 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14 } },
		//s5
		{ { 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9 },
		  { 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6 },
		  { 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14 },
		  { 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3 } },
		//s6
		{ { 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11 },
		  { 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8 },
		  { 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6 },
		  { 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 10, 0, 8, 13 } },
		//s7
		{ { 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1 },
		  { 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6 },
		  { 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2 },
		  { 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12 } },
		//s8
		{ { 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7 },
		  { 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 10, 14, 9, 2 },
		  { 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 10, 15, 3, 5, 8 },
		  { 2, 1, 14, 7, 4, 10, 5, 13, 15, 19, 9, 9, 3, 5, 6, 11 } }
	};
	vector<vector<bool> > sub_blocks(8);
	int k = 0;
	for (int i = 0; i < 8; i++)
	{
		vector<bool> cur_sub_block(6);
		for (int j = 0; j < 6; j++, k++)
			cur_sub_block[j] = block[k];
		sub_blocks[i] = cur_sub_block;
	}
	for (int i = 0; i < 8; i++)
	{
		int x = 0, y = 0;
		x = 2 * (int)sub_blocks[i][0] + (int)sub_blocks[i][5];
		for (int j = 1, t = 8; j <= 4; j++, t /= 2)
			y += (int)sub_blocks[i][j] * t;
		int n = s[i][x][y];
		sub_blocks[i].clear();
		for (int j = 0; j < 4; j++)
			sub_blocks[i].push_back((n % 2) == 1), n /= 2;
		reverse(sub_blocks[i].begin(), sub_blocks[i].end());
	}
	vector<bool> res;
	for (int i = 0; i < 8; i++)
		res = add_vector(res, sub_blocks[i]);
	return res;
}

vector<bool> shuffle_p(vector<bool> block)
{
	int p[32] = { 16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10,
		          2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25 };
	vector<bool> res(32);
	for (int i = 0; i < 32; i++)
		res[i] = block[p[i] - 1];
	return res;
}

vector<bool> des_function(vector<bool> block, vector<bool> key)
{
	return shuffle_p(conversion_s(xor(expansion(block), key)));
}

vector<vector<bool> > encrypt(vector<vector<bool> > data, vector<bool> key)
{
	for (int i = 0; i < (int)data.size(); i++)
		data[i] = shuffle_one(data[i]);
	vector<bool> cur_key = key56(key);
	for (int it = 0; it < 16; it++)
	{
		cur_key = shift_key(cur_key, it);
		vector<bool> new_key = key48(cur_key);
		/*cout << "key: " << it << " ";
		for (int i = 0; i < new_key.size(); i++)
			cout << (int)new_key[i];*/
		//cout << endl;

		for (int j = 0; j < (int)data.size(); j++)
		{
			/*for (int i = 0; i < 64; i++)
				cout << (int)data[j][i];
			cout << endl;*/
			vector<bool> l0, r0, l1, r1;
			l0 = data[j];
			l0.resize(32);
			for (int i = 32; i < 64; i++)
				r0.push_back(data[j][i]);
			l1 = r0;
			r1 = xor(l0, des_function(r0, new_key));
			/*
			for (int i = 0; i < l0.size(); i++)
				cout << (int)l0[i];
			cout << endl;
			for (int i = 0; i < r0.size(); i++)
				cout << (int)r0[i];
			cout << endl;
			for (int i = 0; i < l1.size(); i++)
				cout << (int)l1[i];
			cout << endl;
			for (int i = 0; i < r1.size(); i++)
				cout << (int)r1[i];
			cout << endl << endl;
			*/
			if (it == 15)
				swap(l1, r1);
			data[j] = add_vector(l1, r1);
		}
	}
	for (int i = 0; i < (int)data.size(); i++)
		data[i] = shuffle_end(data[i]);
	return data;
}

vector<vector<bool> > decrypt(vector<vector<bool> > data, vector<bool> key)
{
	vector<vector<bool> > keys(16);
	vector<bool> new_key = key56(key);
	for (int i = 0; i < 16; i++)
	{
		new_key = shift_key(new_key, i);
		keys[i] = key48(new_key);
	}
	reverse(keys.begin(), keys.end());
	for (int i = 0; i < (int)data.size(); i++)
		data[i] = shuffle_one(data[i]);
	for (int it = 0; it < 16; it++)
	{
		for (int j = 0; j < (int)data.size(); j++)
		{
			vector<bool> l0, r0, l1, r1;
			l0 = data[j];
			l0.resize(32);
			for (int i = 32; i < 64; i++)
				r0.push_back(data[j][i]);
			l1 = r0;
			r1 = xor(l0, des_function(r0, keys[it]));
			if (it == 15)
				swap(l1, r1);
			data[j] = add_vector(l1, r1);
		}
	}
	for (int i = 0; i < (int)data.size(); i++)
		data[i] = shuffle_end(data[i]);
	return data;
}

