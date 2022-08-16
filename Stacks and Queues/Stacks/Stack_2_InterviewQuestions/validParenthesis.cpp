/*

* Question Description: https://www.codingninjas.com/codestudio/problems/valid-parenthesis_795104

* We have to return true if the given expression has balanced braces else return false if they are unbalanced.

* Whenever we encounter an opening brace we push them to the stack.

* For the braces to be balanced, whenever we encounter the closing braces we should look at the top of the stack.

* If the corresponding opening brace is found then we have to pop that and continue till stack becomes empty.

* If the stack becomes empty then the expression is balanced else not.

* Suppose we are getting "}" as the brace and the top of the stack contains "[" or "(" that means the expression is
* not balanced.

*/

#include <iostream>
#include <stack>
using namespace std;

bool isValidParenthesis(string expression)
{
    stack <char> s;
    
    for(int i = 0; i < expression.length(); i++){
        char ch = expression[i];
        
        // checking for opening bracket
        if(ch == '(' || ch == '{' || ch == '['){
            s.push(ch);
        }
        // for closing bracket, check stack top & pop
        else
        {
            if(!s.empty()){
                char top = s.top();
                if((ch == ']' && top == '[') || 
                   (ch == '}' && top == '{') || 
                   (ch == ')' && top == '(')){
                        s.pop();
                }
                
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
    }
    
    if(s.empty())
        return true;
    else
        return false;
}