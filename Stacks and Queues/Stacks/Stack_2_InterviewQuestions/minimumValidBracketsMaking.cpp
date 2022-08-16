/*

* Question Description: https://www.codingninjas.com/codestudio/problems/minimum-cost-to-make-string-valid_1115770

* First to make the valid pair; we check if the string length is even. If not return -1 (not possible valid pairs).
*
* Now there will be 3 types of invalid even pairs left that we need to make valid.
* 1. All opening even number of {
* 2. All closing even number of }
* 3. Starting with close and follwing by open even braces. Example: }}} {{{

* In all these cases the number of valid pairs possible are (a+1)/2 + (b+1)/2, where a denotes the count of closing
* braces and b denotes the count of opening braces.

* We store the result in a variable and return it.

*/


#include <iostream>
using namespace std;
#include <stack>


int findMinimumCost(string str)
{

    // string length odd condition
    if (str.length() % 2 == 1)
        return -1;

    stack<char> s;

    for (int i = 0; i < str.length(); i++)
    {
        char ch = str[i];

        if (ch == '{')
        {
            s.push(ch);
        }
        else
        { // ch is closing ) brace
            if (!s.empty() && s.top() == '{')
            {
                s.pop();
            }
            else
            {
                s.push(ch);
            }
        }
    }

    // stack k andar ab invalid expression hai

    int a = 0, b = 0;
    while (!s.empty())
    {
        if (s.top() == '{')
            b++;

        else
            a++;

        s.pop();
    }

    int ans = (((a + 1) / 2) + ((b + 1) / 2));
    return ans;
}