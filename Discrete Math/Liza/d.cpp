#include<cstdio>
#include<cstring>
using namespace std;

int main()
{
    freopen("brackets.in", "r", stdin);
    freopen("brackets.out", "w", stdout);
    char request[10005];
    char stack[10005];
    while (scanf("%s", request) > 0)
    {
        int top = 0;
        int n = strlen(request);
        bool is_good = true;
        for (int i = 0; i < n && is_good; i++)
        {    
            switch(request[i]) 
            {
                case '(':
                    stack[top++] = '(';
                    break;
                case '[':
                    stack[top++] = '[';
                    break;
                case ')':
                    if (top == 0 || stack[top - 1] != '(') 
                        is_good = false;
                    else
                        top--;
                    break;
                case ']':
                    if (top == 0 || stack[top - 1] != '[') 
                        is_good = false;
                    else
                        top--;
                    break;
            }
        }
        if (top != 0)
            is_good = false;
        if (is_good)
            printf("YES\n");
        else
            printf("NO\n");
    }
    return 0;
}