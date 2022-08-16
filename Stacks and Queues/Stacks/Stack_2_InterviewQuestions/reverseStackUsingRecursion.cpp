/*
*Question Description: https://www.codingninjas.com/codestudio/problems/reverse-stack-using-recursion_631875
*
* The question is same as insertAtBottom.
* First we are taking the top element and to reverse we have to put that element at the bottom of the stack.
* We are solving this for the first 1 element and all the rest will be handled by recursion itself.
*
* We take the top element and follow the insertAtBottom approach to reverse the stack using recursion.

*/

#include <iostream>
#include <stack>
using namespace std;

void insertAtBottom(stack<int> &s, int element){
    
    // base case
    if(s.empty()){
        s.push(element);
        return;
    }
    
    int num = s.top();
    s.pop();
    
    insertAtBottom(s, element);
    s.push(num);
}

void reverseStack(stack<int> &s) {
    // base case
    if(s.empty())
        return;
    
    int num = s.top();
    s.pop();
    
    reverseStack(s);
    insertAtBottom(s, num);
}