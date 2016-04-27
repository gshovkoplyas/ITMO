#include<cstdio>
using namespace std;

int main()
{
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    char c;
    int d = 5; //סהגטד ג רטפנו
    while(scanf("%c", &c) > 0)
    {
        if (c >= 'א' && c <= 'ÿ')
        {
            int pos = c - 'א';
            pos = (pos + d) % 33;
            c = pos + 'א';
        }
        if (c >= 'À' && c <= '‗')
        {
            int pos = c - 'À';
            pos = (pos + d) % 33;
            c = pos + 'À';
        }
        printf("%c", c);    
    }
    return 0;
}

