/*
*Question Description: 
* https://www.codingninjas.com/codestudio/problems/insert-an-element-at-its-bottom-in-a-given-stack_1171166
*
* We are given an element and we have to push that element at the bottom of the stack.
* For that we are simply taking out every element from the stack till the stack becomes empty.
* We are performing these operations by recursion.

* When the stack gets empty, we simply push the elements and on your way returning we pick up the elements that we   discarded during recursion.

* Hence our insertAtBottom operation is successful with all test cases passing.
*
* 
*/

#include <iostream>
#include <stack>
using namespace std;

void solve(stack<int>& s, int x){
    
    // base case
    if(s.empty())
    {
        s.push(x);
        return;
    }
    
    int num = s.top();
    s.pop();
    
    solve(s, x);
    s.push(num);
}

stack<int> pushAtBottom(stack<int>& myStack, int x) 
{
    solve(myStack, x);
    return myStack;
}
