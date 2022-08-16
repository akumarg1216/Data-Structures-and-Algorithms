/*

Question Description: https://www.codingninjas.com/codestudio/problems/redundant-brackets_975473

* We have to return true if redundant brackets are found and false if not.

* Approach: 

* We will ignore the English characters. If the opening brace or any operator is found then we push it in the stack.
* When we encounter the closing bracket we search in the stack for the opening  bracket.
* While searching for opening bracket, if we find operator before then that; the brackets are not redundant.
* If we find the opening bracket without any operator, then the brackets are said to be redundant.

*/


#include <iostream>
#include <stack>
using namespace std;

bool findRedundantBrackets(string &s)
{

    stack<char> st;
    for (int i = 0; i < s.length(); i++)
    {
        char ch = s[i];

        if (ch == '(' || ch == '+' || ch == '-' | ch == '*' || ch == '/')
        {
            st.push(ch);
        }

        else
        {
            if (ch == ')')
            {
                bool isRedundant = true;

                while (st.top() != '(')
                {
                    char top = st.top();
                    if (top == '+' || top == '-' || top == '*' || top == '/')
                    {
                        isRedundant = false;
                    }
                    st.pop();
                }

                if (isRedundant == true)
                    return true;
                st.pop();
            }
        }
    }
}
