#include <iostream>
#include <cmath>
#include <cstdio>
#include <vector>
#include <fstream>
#include <string>
#include <algorithm>
using namespace std;
ofstream fout("out.txt");

struct messageBlock
{
    vector <bool> left;
    vector <bool> rigth;
};

void printKey(vector <bool> key, string s)
{
    fout << endl << s << endl;
    for (int i = 0; i < key.size(); ++i)
    {
        if (key[i])
            fout << 1;
        else
            fout << 0;
    }
    fout << endl << endl;
}

vector <bool> charToByteArray(char c) {
    vector <bool> result;
    int mask[8] = { 1, 2, 4, 8, 16, 32, 64, 128 };
    for (int i = 0; i < 8; ++i) {
        result.push_back(c&mask[i]);
    }
    reverse(result.begin(), result.end());
    return result;
}

string byteArrayToChar(vector <bool> block)
{
    int mask[8] = { 128, 64, 32, 16, 8, 4, 2, 1 };
    string result;
    int pos = 0;
    char c = 0;
    int count = 8;
    while (count != 0)
    {
        for (int i = 0; i < 8; ++i, ++pos)
            c += (int)(pow(2, 7 - i) * block[pos]) & mask[i];
        --count;
        result += c;
        c = 0;
    }

    return result;
}

vector <bool> firstShuffle(vector <bool> block)
{
    vector <bool> result(64);
    int m[64] = { 58, 50, 42, 34, 26, 18, 10, 2,
        60, 52, 44, 36, 28, 20, 12, 4,
        62, 54, 46, 38, 30, 22, 14, 6,
        64, 56, 48, 40, 32, 24, 16, 8,
        57, 49, 41, 33, 25, 17, 9, 1,
        59, 51, 43, 35, 27, 19, 11, 3,
        61, 53, 45, 37, 29, 21, 13, 5,
        63, 55, 47, 39, 31, 23, 15, 7 };

    for (int i = 0; i < 64; ++i)
    {
        result[i] = block[m[i] - 1];
    }

    return result;
}

vector <bool> keyTransforming(vector <bool> key)
{
    vector <bool> result(56);
    int m[56] = { 57, 49, 41, 33, 25, 17, 9,
        1, 58, 50, 42, 34, 26, 18,
        10, 2, 59, 51, 43, 35, 27,
        19, 11, 3, 60, 52, 44, 36,
        63, 55, 47, 39, 31, 23, 15,
        7, 62, 54, 46, 38, 30, 22,
        14, 6, 61, 53, 45, 37, 29,
        21, 13, 5, 28, 20, 12, 4 };

    for (int i = 0; i < 56; ++i)
    {
        result[i] = key[m[i] - 1];
    }
    return result;
}

vector <bool> makeKeyCycleShiftLeft(vector <bool> key, int iter)
{
    int m[16] = { 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1 };
    vector <bool> l, r;
    for (int i = 0; i < 28; ++i)
        l.push_back(key[i]);
    for (int i = 28; i < 56; ++i)
        r.push_back(key[i]);
    rotate(l.begin(), l.begin() + m[iter], l.end());
    rotate(r.begin(), r.begin() + m[iter], r.end());

    vector <bool> result;
    for (int i = 0; i < l.size(); ++i)
        result.push_back(l[i]);
    for (int i = 0; i < r.size(); ++i)
        result.push_back(r[i]);

    //fout << "C" << iter + 1 << endl;
    //printKey(l);
    //fout << "D" << iter + 1 << endl;
    //printKey(r);

    return result;
}

vector <bool> keyShuffleWithCompressing(vector <bool> key)
{
    vector <bool> result(48);
    int m[48] = { 14, 17, 11, 24, 1, 5,
        3, 28, 15, 6, 21, 10,
        23, 19, 12, 4, 26, 8,
        16, 7, 27, 20, 13, 2,
        41, 52, 31, 37, 47, 55,
        30, 40, 51, 45, 33, 48,
        44, 49, 39, 56, 34, 53,
        46, 42, 50, 36, 29, 32 };

    for (int i = 0; i < 48; ++i)
    {
        result[i] = key[m[i] - 1];
    }

    return result;  
}

vector <bool> msgShuffleWithExtension(vector <bool> block)
{

    //printKey(block, "Rn-1");
    vector <bool> result(48);
    int m[48] = { 32, 1, 2, 3, 4, 5,
        4, 5, 6, 7, 8, 9,
        8, 9, 10, 11, 12, 13,
        12, 13, 14, 15, 16, 17,
        16, 17, 18, 19, 20, 21,
        20, 21, 22, 23, 24, 25,
        24, 25, 26, 27, 28, 29,
        28, 29, 30, 31, 32, 1};

    for (int i = 0; i < 48; ++i)
    {
        result[i] = block[m[i] - 1];
    }
    //printKey(result, "E(Rn-1)");
    return result;
}

vector <bool> makeXor(vector <bool> a, vector <bool> b)
{
    //printKey(a, "BLOCK");
    //printKey(b, "KEY");
    vector <bool> result(a.size());
    for (int i = 0; i < a.size(); ++i)
    {
        result[i] = a[i] ^ b[i];
    }
    //printKey(result, "XOR");
    return result;
}

vector <bool> getBytesFromSblock(vector <bool> in, int s[4][16])
{
    int row, column, result;
    row = 1 * (int)in[5] + 2 * (int)in[0];
    column = 1 * (int)in[4] + 2 * (int)in[3] + 4 * (int)in[2] + 8 * (int)in[1];
    result = s[row][column];
    vector <bool> byteResult;

    for (int i = 0; i < 4; ++i)
    {
        byteResult.push_back(result % 2);
        result /= 2;        
    }
    reverse(byteResult.begin(), byteResult.end());
    return byteResult;
}

vector <bool> shuffleInSblock(vector <bool> in)
{
    int s1[4][16] = {   { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7 },
                        { 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8 },
                        { 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0 },
                        { 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 } };

    int s2[4][16] = { { 15, 1,  8,  14, 6,  11, 3,  4,  9,  7,  2,  13, 12, 0,  5,  10 },
    { 3,    13, 4,  7,  15, 2,  8,  14, 12, 0,  1,  10, 6,  9,  11, 5 },
    { 0,    14, 7,  11, 10, 4,  13, 1,  5,  8,  12, 6,  9,  3,  2,  15 },
    { 13,   8,  10, 1,  3,  15, 4,  2,  11, 6,  7,  12, 0,  5,  14, 9 } };

    int s3[4][16] = {   { 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8 },
                        { 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1 },
                        { 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7 },
                        { 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12 } };

    int s4[4][16] = {   { 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 1, 12, 4, 15 },
                        { 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9 },
                        { 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4 },
                        { 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14 } };

    int s5[4][16] = {   { 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9 },
                        { 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6 },
                        { 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14 },
                        { 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3 } };

    int s6[4][16] = {   { 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11 },
                        { 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8 },
                        { 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6 },
                        { 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 10, 0, 8, 13 } };

    int s7[4][16] = {   { 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1 },
                        { 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6 },
                        { 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2 },
                        { 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12 } };

    int s8[4][16] = {   { 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7 },
                        { 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 10, 14, 9, 2 },
                        { 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 10, 15, 3, 5, 8 },
                        { 2, 1, 14, 7, 4, 10, 5, 13, 15, 19, 9, 9, 3, 5, 6, 11 } };

    //make 8 subblocks
    vector < vector <bool> > subBlocks;
    int pos = 0;
    int counter = 6;
    vector <bool> temp;
    for (int i = 0; i < 8; ++i)
    {
        while (counter > 0)
        {
            temp.push_back(in[pos]);
            pos++;
            counter--;
        }
        counter = 6;
        subBlocks.push_back(temp);
        temp.clear();
    }

    //make 4 byte from each 8 byte subblock
    subBlocks[0] = getBytesFromSblock(subBlocks[0], s1);
    subBlocks[1] = getBytesFromSblock(subBlocks[1], s2);
    subBlocks[2] = getBytesFromSblock(subBlocks[2], s3);
    subBlocks[3] = getBytesFromSblock(subBlocks[3], s4);
    subBlocks[4] = getBytesFromSblock(subBlocks[4], s5);
    subBlocks[5] = getBytesFromSblock(subBlocks[5], s6);
    subBlocks[6] = getBytesFromSblock(subBlocks[6], s7);
    subBlocks[7] = getBytesFromSblock(subBlocks[7], s8);
    vector <bool> result;
    for (int i = 0; i < subBlocks.size(); ++i)
    {
        for (int j = 0; j < subBlocks[i].size(); ++j)
            result.push_back(subBlocks[i][j]);
    }
    return result;
}

vector <bool> shuffleInPblock(vector <bool> block)
{
    int m[32] = { 16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10,
        2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25 };

    vector <bool> result(32);
    for (int i = 0; i < 32; ++i)
    {
        result[i] = block[m[i] - 1];
    }

    return result;
}

vector <bool> makeMsgFinalShuffle(vector <bool> block)
{
    int m[64] = { 40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31,
        38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, 13, 53, 21, 61, 29,
        36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51, 19, 59, 27,
        34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25 };

    vector <bool> result(64);
    for (int i = 0; i < 64; ++i)
    {
        result[i] = block[m[i] - 1];
    }

    return result;
}

void printBlock(int number, vector <bool> left, vector <bool> rigth)
{
    fout << "L" << number << endl;
    for (int i = 0; i < left.size(); ++i)
    {
        if (left[i])
            fout << 1;
        else
            fout << 0;
    }
    fout << endl;

    fout << "R" << number << endl;
    for (int i = 0; i < rigth.size(); ++i)
    {
        if (rigth[i])
            fout << 1;
        else
            fout << 0;
    }
}

void printMsg(vector <bool> msg)
{
    fout << endl;
    fout << "MSG" << endl;
    for (int i = 0; i < msg.size(); ++i)
    {
        if (msg[i])
            fout << 1;
        else
            fout << 0;
    }

    fout << endl;
}

vector <bool> desF(vector <bool> part, vector <bool> key)
{
    part = msgShuffleWithExtension(part);
    part = makeXor(part, key);
    part = shuffleInSblock(part);
    part = shuffleInPblock(part);
    return part;
}


int main()
{
    FILE *f = fopen("des.in", "r");
    FILE *k = fopen("key.in", "r");
    
    char c;
    vector <vector <bool> > msg;
    vector <bool> key;
    vector <bool> block;
    vector <bool> byteArray;
    vector < vector <bool> > keys;
    vector <messageBlock> copyOfMessage;
    vector <messageBlock> message;
    vector <vector <bool> > keys_archive;
    bool flag = false;
    

    //reading message
    fout << "ORIGINAL MESSAGE" << endl;
    while (fscanf(f, "%c", &c) > 0)
    {
        fout << c;
        byteArray = charToByteArray(c);
        for (int i = 0; i < byteArray.size(); ++i)
            block.push_back(byteArray[i]);
        if (block.size() == 64)
        {
            msg.push_back(block);
            block.clear();
        }
    }
    fout << endl << endl;
    if (block.size() > 0)
    {
        while (block.size() % 64 != 0)
            block.push_back(false);
        msg.push_back(block);
    }

    //!!!!!!!MY MESSAGE BLOCK!!!!!!!
    //msg[0] = { 0,0,0,0, 0,0,0,1, 0,0,1,0, 0,0,1,1, 0,1,0,0, 0,1,0,1, 0,1,1,0, 0,1,1,1, 1,0,0,0, 1,0,0,1, 1,0,1,0, 1,0,1,1, 1,1,0,0, 1,1,0,1, 1,1,1,0, 1,1,1,1 };
    //printKey(msg[0], "MSG");
    //reading key
    while (fscanf(k, "%c", &c) > 0)
    {
        byteArray = charToByteArray(c);
        for (int i = 0; i < byteArray.size(); ++i)
            key.push_back(byteArray[i]);
    }
    while (key.size() < 64)
        key.push_back(false);

    //Step 1, shuffle message blocks and make left/rigth parts of each block
    for (int i = 0; i < msg.size(); ++i)
    {
        msg[i] = firstShuffle(msg[i]);
    }

    messageBlock temp;
    for (int i = 0; i < msg.size(); ++i)
    {
        for (int j = 0; j < 32; ++j)
        {
            temp.left.push_back(msg[i][j]);
        }
        for (int j = 32; j < 64; ++j)
        {
            temp.rigth.push_back(msg[i][j]);
        }
        message.push_back(temp);
        temp.left.clear();
        temp.rigth.clear();
    }

    //!!!!!!!MY KEY!!!!!!!!!!!
    //key = { 0,0,0,1,0,0,1,1, 0,0,1,1,0,1,0,0, 0,1,0,1,0,1,1,1, 0,1,1,1,1,0,0,1, 1,0,0,1,1,0,1,1, 1,0,1,1,1,1,0,0, 1,1,0,1,1,1,1,1, 1,1,1,1,0,0,0,1 };

    //Step 2, key transforming
    key = keyTransforming(key);
    //Step3, making 16 keys
    vector <bool> cyclicShift;
    cyclicShift = key;
    for (int i = 0; i < 16; ++i)
    {
        cyclicShift = makeKeyCycleShiftLeft(key, i);
        keys.push_back(cyclicShift);
        key = cyclicShift;
    }
    
    //Step4, shuffle keys with compression
    for (int i = 0; i < 16; ++i)
    {
        keys[i] = keyShuffleWithCompressing(keys[i]);
        printKey(keys[i], "KEY");
    }

    //printBlock(0, message[0].left, message[0].rigth);
    fout << endl << endl;
    //ENCODING
    
    for (int it = 0; it < 16; ++it)
    {
        for (int i = 0; i < message.size(); ++i)
        {
            vector <bool> r0 = message[i].rigth;
            vector <bool> l1 = r0;

            vector <bool> l0 = message[i].left;
            vector <bool> r1 = makeXor(l0, desF(r0, keys[it]));
            
            //
            for (int i = 0; i < l0.size(); i++)
                fout << (int)l0[i];
            fout << endl;
            for (int i = 0; i < r0.size(); i++)
                fout << (int)r0[i];
            fout << endl;
            for (int i = 0; i < l1.size(); i++)
                fout << (int)l1[i];
            fout << endl;
            for (int i = 0; i < r1.size(); i++)
                fout << (int)r1[i];
            fout << endl << endl;
            //
            
            message[i].rigth = r1;
            message[i].left = l1;
        }
        //printBlock(it + 1, message[0].left, message[0].rigth);
        //printKey(keys[it], "KEY");
    }

    for (int i = 0; i < message.size(); ++i)
        swap(message[i].left, message[i].rigth);
    //finalShuffle
    for (int i = 0; i < message.size(); ++i)
    {
        msg[i].clear();
        for (int j = 0; j < message[i].left.size(); ++j)
        {
            msg[i].push_back(message[i].left[j]);
        }
        for (int j = 0; j < message[i].rigth.size(); ++j)
        {
            msg[i].push_back(message[i].rigth[j]);
        }
        msg[i] = makeMsgFinalShuffle(msg[i]);
    }
    fout << "shit" << endl;
    printMsg(msg[0]);

    //Print result
    fout << "ENCRIPTION" << endl;
    for (int i = 0; i < msg.size(); ++i)
    {
        string s = byteArrayToChar(msg[i]);
        fout << s;
    }
    fout << endl;

    //DECODING
    reverse(keys.begin(), keys.end());
    for (int i = 0; i < msg.size(); ++i)
    {
        msg[i] = firstShuffle(msg[i]);
    }

    temp.left.clear();
    temp.rigth.clear();
    message.clear();
    for (int i = 0; i < msg.size(); ++i)
    {
        for (int j = 0; j < 32; ++j)
        {
            temp.left.push_back(msg[i][j]);
        }
        for (int j = 32; j < 64; ++j)
        {
            temp.rigth.push_back(msg[i][j]);
        }
        message.push_back(temp);
        temp.left.clear();
        temp.rigth.clear();
    }

    //printBlock(16, message[0].left, message[0].rigth);
    

    fout << endl << endl;
    for (int it = 0; it < 16; ++it)
    {
        for (int i = 0; i < message.size(); ++i)
        {
            vector <bool> r0 = message[i].rigth;
            vector <bool> l1 = r0;

            vector <bool> l0 = message[i].left;
            vector <bool> r1 = makeXor(l0, desF(r0, keys[it]));


            message[i].rigth = r1;
            message[i].left = l1;
        }
        //printBlock(16 - it - 1, message[0].left, message[0].rigth);
        //printKey(keys[it], "KEY");
    }

    for (int i = 0; i < message.size(); ++i)
        swap(message[i].left, message[i].rigth);


    //finalShuffle
    for (int i = 0; i < message.size(); ++i)
    {
        msg[i].clear();
        for (int j = 0; j < message[i].left.size(); ++j)
        {
            msg[i].push_back(message[i].left[j]);
        }
        for (int j = 0; j < message[i].rigth.size(); ++j)
        {
            msg[i].push_back(message[i].rigth[j]);
        }
        msg[i] = makeMsgFinalShuffle(msg[i]);
    }
    printKey(msg[0], "MSG");
    //Print result
    fout << "DECRIPTION" << endl;
    for (int i = 0; i < msg.size(); ++i)
    {
        string s = byteArrayToChar(msg[i]);
        fout << s;
    }
    fout << endl;

}


