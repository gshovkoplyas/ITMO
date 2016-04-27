#include<cstdio>
#include<cstring>
using namespace std;

int main()
{
    freopen("postfix.in", "r", stdin);
    freopen("postfix.out", "w", stdout);
    int stack[100];
    int top = 0;
    char cur[15];
    while (scanf("%s", cur) > 0)
    {
        if (cur[0] >= '0' && cur[0] <= '9')
        {
            int res = 0;
            int n = strlen(cur);
            for (int i = 0; i < n; i++)
                res = res * 10 + (cur[i] - '0');
            stack[top++] = res;
        } else {
            int a = stack[top - 2];
            int b = stack[top - 1];
            top -= 2;
            switch(cur[0]) 
            {
                case '+':
                    stack[top++] = a + b;
                    break;
                case '*':
                    stack[top++] = a * b;
                    break;
                case '-':
                    stack[top++] = a - b;
                    break;
            }
        }
    }
    printf("%i\n", stack[0]);
    return 0;
}