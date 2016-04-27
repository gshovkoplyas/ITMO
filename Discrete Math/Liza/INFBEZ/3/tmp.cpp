#include <iostream>
#include <cstdio>
#include <vector>

using namespace std;

int main() {
    freopen("file.in", "w", stdout);
    vector <bool> c(1, 1);
    vector <bool> b(1, 1);
    vector <bool> t;
    bool nev;
    bool z[19] = { 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1 };
    vector <bool> temp;
    for (int r = 1; r < 19; ++r) {
        
        cout << "Step " << r << endl;
        nev = 0;
        for (int i = 1; i <= r - 1; ++i) {
            nev ^= c[i - 1] * z[r - i];
        }
        nev = nev ^ z[r];
        cout << "Nev " << nev << endl;
        temp.assign(c.size() + 1, 0);
        for (int i = 1; i <= c.size(); ++i) {
            temp[i] = c[i - 1];
        }
        c = temp;
        if (nev != 0) {
            temp.assign(b.size() + 1, 0);
            for (int i = 0; i < b.size(); ++i) {
                temp[i] = b[i];
            }
            t.assign(temp.size(), 0);
            for (int i = 0; i < temp.size(); ++i) {
                t[i] = c[i]^temp[i];
            }
            b = c;
            c = t;
        }
        else if (nev == 0) {
            vector <bool> temp(b.size() + 1, 0);
            for (int i = 0; i < b.size(); ++i) {
                temp[i] = b[i];
            }
            b = temp;
        }
        cout << "c: ";
        for (int i = 0; i < c.size(); ++i) {
            cout << c[i] << " ";
        }
        cout << endl;
        cout << "b: ";
        for (int i = 0; i < b.size(); ++i) {
            cout << b[i] << " ";
        }
        cout << endl << endl;
    }

    for (int i = 0; i < c.size(); ++i) {
        cout << c[i] << " ";
    }
    return 0;
}