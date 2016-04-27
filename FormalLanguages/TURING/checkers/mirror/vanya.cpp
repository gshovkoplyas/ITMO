#include <iostream>
#include <cmath>
#include <vector>
#include <map>
#include <set>
#include <string>
#include <cstring>
#include <queue>
#include <ctime>
#include <cassert>
#include <cstdio>
#include <algorithm>
#include <unordered_set>
#include <unordered_map>
#include <bitset>
 
using namespace std;
 
#define fr first
#define sc second
#define mp make_pair
#define pb push_back
#define epr(...) fprintf(stderr, __VA_ARGS__)
#define db(x) cerr << #x << " = " << x << endl
#define db2(x, y) cerr << "(" << #x << ", " << #y << ") = (" << x << ", " << y << ")\n"; 
#define all(a) (a).begin(), (a).end()
 
#define equal equalll
#define less lesss
const int N = -1;
const long long INF = 1e9 + 19;
 
struct Rule {
    string from;
    char ch;
    string to;
    char down;
    int dir;
    Rule(string from, char ch, string to, char down, int dir): from(from), ch(ch), to(to), down(down),  dir(dir) { }
};
 
set < string > st;
vector < Rule > r;
 
void addRule(string from, char ch, string to, char down, int dir) {
    assert(st.count(from) == 1);
    assert(st.count(to) == 1);
    r.pb(Rule(from, ch, to, down, dir));
}
 
void addState(string s) {
    assert(st.count(s) == 0);
    st.insert(s);
}
 
void solve() {
    addState("s"); 
    addState("ac"); 
    addState("rj"); 
    addRule("s", '0', "s", '0', 1); 
    addRule("s", '1', "s", '1', 1); 
    addState("w0");
    addState("w1");
    addState("back1");
    addState("back2");
    addState("detect");
    addRule("s", '_', "detect", '_', -1); 
 
    addRule("detect", '0', "w0", '2', 1); 
    addRule("detect", '1', "w1", '3', 1); 
 
 
    addRule("w0", '0', "w0", '0', 1); 
    addRule("w0", '1', "w0", '1', 1); 
    addRule("w0", '2', "w0", '2', 1); 
    addRule("w0", '3', "w0", '3', 1); 
    addRule("w0", '_', "back1", '0', -1); 
 
    addRule("w1", '0', "w1", '0', 1); 
    addRule("w1", '1', "w1", '1', 1); 
    addRule("w1", '2', "w1", '2', 1); 
    addRule("w1", '3', "w1", '3', 1); 
    addRule("w1", '_', "back1", '1', -1); 
 
    addRule("back1", '0', "back1", '0', -1); 
    addRule("back1", '1', "back1", '1', -1); 
 
    addRule("back1", '2', "back2", '2', -1); 
    addRule("back1", '3', "back2", '3', -1); 
 
    addRule("back2", '2', "back2", '2', -1); 
    addRule("back2", '3', "back2", '3', -1); 
 
    addRule("back2", '0', "detect", '0', 0); 
    addRule("back2", '1', "detect", '1', 0); 
 
    addState("update");
    addRule("back2", '_', "update", '_', 1); 
 
    addRule("update", '2', "update", '0', 1); 
    addRule("update", '3', "update", '1', 1); 
 
    addState("goback");
 
    addRule("update", '0', "goback", '0', -1); 
    addRule("update", '1', "goback", '1', -1); 
 
    addRule("goback", '1', "goback", '1', -1); 
    addRule("goback", '0', "goback", '0', -1); 
    addRule("goback", '_', "ac", '_', 1); 
 
 
}
 
void printAns() {
    puts("start: s");                   
    puts("accept: ac");
    puts("reject: rj");
    puts("blank: _   ");
    for (auto x: r)  {
        cout << x.from << " " << x.ch << " -> " << x.to << " " << x.down << " ";
        if (x.dir == 1) cout << ">";
        if (x.dir == 0) cout << "^";
        if (x.dir == -1) cout << "<";
        cout << endl;
    }
}
 
void stress() {
 
}
 
 
int main(){
#ifdef DEBUG
    freopen("in", "r", stdin);
    //freopen("out", "w", stdout);
    freopen("mirror.out", "w", stdout);
#else
    freopen("mirror.out", "w", stdout);
#endif
    if (1) {
        solve();
        printAns();
    }
    else {
        stress();
    }
 
    return 0;
}