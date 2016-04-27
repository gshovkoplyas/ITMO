#include <bits/stdc++.h>
 
using namespace std;
 
bool contains_K33(const vector <vector <bool>> &graph) {
  assert(graph.size() == 6);
  for (int mask = 0; mask < (1 << 6); ++mask) {
    if (__builtin_popcount(mask) != 3) {
      continue;
    }
    bool k33 = true;
    for (int i = 0; i < (int) graph.size(); ++i) {
      for (int j = 0; j < (int) graph.size(); ++j) {
        if (((mask >> i) & 1) == 1 && ((mask >> j) & 1) != 1) {
          k33 &= graph[i][j];
        }
      }
    }
    if (k33) {
      return true;
    }
  }
  return false;
}
 
bool contains_K5(const vector <vector <bool>> &graph) {
  assert(graph.size() == 5 || graph.size() == 6);
  vector <int> degrees(graph.size());
  int sum_degree = 0;
  for (int i = 0; i < (int) graph.size(); ++i) {
    degrees[i] = count(graph[i].begin(), graph[i].end(), true);
    sum_degree += degrees[i];
  }
  if (graph.size() == 5) {
    return sum_degree == 5 * 4;
  } // now graph.size() == 6;
  for (int to_delete = 0; to_delete < (int) graph.size(); ++to_delete) {
    sum_degree -= 2 * degrees[to_delete];
    for (int i = 0; i < (int) graph.size(); ++i) {
      for (int j = 0; j < (int) graph.size(); ++j) {
        int ad = 0;
        if (i != j && graph[i][to_delete] && graph[to_delete][j] && !graph[i][j]) {
          ad = 2;
        }
        if (sum_degree + ad == 5 * 4) {
          return true;
        }
      }
    }
    sum_degree += 2 * degrees[to_delete];
  }
  return false;
}
 
bool solveCase(string input) {
  int vertices = 0;
  while (vertices * (vertices - 1) / 2 != input.length()) {
    vertices++;
  }
  vector <vector <bool>> graph(vertices);
  for (auto &v : graph) {
    v.resize(vertices);
  }
  int ptr = 0;
  for (int i = 0; i < vertices; ++i) {
    for (int j = 0; j < i; ++j) {
      graph[j][i] = graph[i][j] = (input[ptr++] == '1');
    }
  }
  if (vertices < 5) {
    return true;
  }
  if (vertices == 6 && contains_K33(graph)) {
    return false;
  }
  return !contains_K5(graph);
}
 
void solve() {
  int tests;
  cin >> tests;
  for (int test = 0; test < tests; ++test) {
    string input;
    cin >> input;
    cout << (solveCase(input) ? "YES" : "NO") << '\n';
  }
}
 
/**
* Template starts here.
* Created by Vadim Semenov.
*/
 
static void redirect_input(char *file_name) {
  static filebuf input;
  input.open(file_name, ios::in);
  cin.rdbuf(&input);
  if (!cin) {
    cerr << "Failed to open '" << file_name << "'\n";
    exit(1);
  }
}
 
static void redirect_output(char *file_name) {
  static filebuf output;
  output.open(file_name, ios::out | ios::trunc);
  cout.rdbuf(&output);
  if (!cout) {
    cerr << "Failed to open '" << file_name << "'\n";
  }
}
 
static void redirect(char *input_file, char *output_file) {
  ios::sync_with_stdio(false);
  cin.tie(0);
  redirect_input(input_file);
  redirect_output(output_file);
}
 
int main() {
  redirect("planaritycheck.in", "stress.out");
  solve();
  return 0;
}