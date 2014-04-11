def add(a, b):
  if len(a) != len(b):
    print("error: need same size")
    return []
  c = []
  for i in range(len(a)):
    if len(a[i]) != len(b[i]):
      print("error: need same size")
      return []
    c.append([])
    for j in range(len(a[i])):
      c[i].append(a[i][j] + b[i][j])
  return c

def read_matrix(name = "a"):
  n = int(raw_input("Input " + name + "'s n: "))
  m = int(raw_input("Input " + name + "'s m: "))
  a = []
  for i in range(n):
    a.append([])
    for j in range(m):
      a[i].append(int(raw_input("Input " + name + "[" + str(i + 1) + "][" + str(j + 1) + "]: "))) 
  return a

def print_matrix(a, name = "a"):
  if len(a) == 0:
    print("Matrix " + name + " is empty")
    return 
  print("Matrix " + name + "[" + str(len(a)) + "][" + str(len(a[0])) + "]:")
  for i in range(len(a)):
    for j in range(len(a[i])):
      print a[i][j],
    print

def dot(a, b):
  m = len(a)
  n = len(a[0])
  q = len(b[0])
  if len(a[0]) != len(b):
    print("Incorrect request for dot")
    return []
  m = len(a)
  n = len(a[0])
  q = len(b[0])
  c = []
  for i in range(m):
    c.append([])
    for j in range(q):
      c[i].append(0)
  for i in range(m):
    for j in range(q):
      for k in range(n):
        c[i][j] += a[i][k] * b[k][j]
  return c

def transpose(a):
  c = []
  for i in range(len(a[0])):
    c.append([])
    for j in range(len(a)):
      c[i].append(a[j][i])
  return c

def copy_matrix(a):
  c = []
  for i in range(len(a)):
    c.append([])
    for j in range(len(a[0])):
      c[i].append(a[i][j])
  return c

def gen_matrix(n, m):
  c = []
  for i in range(n):
    c.append([])
    for j in range(m):
      c[i].append(i * n + j + 1)
  return c

def abs(n):
  if n < 0:
    return -n
  return n 

def swap(a, b):
  tmp = a
  a = b
  b = a

def det(a):
  c = copy_matrix(a)
  n = len(a)
  m = len(a[0])
  if n != m:
    print("This is not square matrix")
    return 0
  ans = 1.0
  for i in range(n):
    k = i
    for j in range(i + 1, n):
      if abs(c[j][i]) > abs(c[k][i]):
        k = j
    if abs(c[k][i]) < 10**(-6):
      ans = 0
      break
    for j in range(n):
      swap(c[i][j], c[k][j])
    if i != k:
      ans = -ans
    ans *= c[i][i]
    for j in range(i + 1, n):
      c[i][j] /= c[i][i] * 1.0
    for j in range(n):
      if j != i and abs(c[j][i]) > 10**(-6):
        for k in range(i + 1, n):
          c[j][k] -= c[i][k] * c[j][i] 
  return ans 

def solve(a):
  c = copy_matrix(a)
  n = len(c)
  m = len(c[0]) - 1
  if m == 0:
    return 3, []
  where = []
  for i in range(m):
    where.append(-1)
  col = 0
  row = 0
  while col < m and row < n:
    sel = row
    for i in range(row, n):
      if abs(c[i][col]) > c[sel][col]:
        sel = i
    if abs(c[sel][col]) < 10 ** (-6):
      col += 1
      continue
    for i in range(col, m + 1):
      swap(c[sel][i], c[row][i])
    where[col] = row
    for i in range(n):
      if i != row:
        k = 1.0 * c[i][col] / c[row][col]
        for j in range(col, m + 1):
          c[i][j] -= c[row][j] * k
    row += 1
    col += 1
  ans = []
  for i in range(m):
    ans.append(0)
    if where[i] != -1:
      ans[i] = 1.0 * c[where[i]][m] / c[where[i]][i]
  for i in range(n):
    sum = 0.0
    for j in range(m):
      sum += ans[j] * c[i][j]
    if abs(sum - c[i][m]) > 10 ** (-6):
      return 0, []
  for i in range(m):
    if where[i] == -1:
      return 2, ans
  return 1, ans

def solution(a):
  k, ans = solve(a)
  if k == 0:
    print("This matrix isn't has any solution")
  if k == 1:
    print("This matrix has one solution:")
    for i in range(len(ans)):
      print("x" + str(i + 1) + "=" + str(ans[i]))
  if k == 2:
    print("This matrix has infinitive solutions, for example:")
    for i in range(len(ans)):
      print("x" + str(i + 1) + "=" + str(ans[i]))

def inv(a):
  c = copy_matrix(a)
  n = len(a)
  if len(a[0]) != n:
    print("Incorrect request for inv")
    return []
  if det(a) == 0:
    print("det = 0")
    return []
  e = []
  for i in range(n):
    e.append([])
    for j in range(n):
      e[i].append(0)
    e[i][i] = 1
  for k in range(n):
    temp = 1.0 * c[k][k]
    if abs(temp) > 10 ** (-6):
      for j in range(n):
        c[k][j] /= temp
        e[k][j] /= temp
    for i in range(k + 1, n):
      temp = 1.0 * c[i][k] 
      for j in range(n):
        c[i][j] -= c[k][j] * temp
        e[i][j] -= e[k][j] * temp
  for k in range(n - 1,  0, -1):
    for i in range(k - 1, -1, -1):
      temp = 1.0 * c[i][k]
      for j in range(n):
        c[i][j] -= c[k][j] * temp
        e[i][j] -= e[k][j] * temp
  for i in range(n):
    for j in range(n):
      if abs(e[i][j]) < 10 ** (-6):
        e[i][j] = 0
  return e;





