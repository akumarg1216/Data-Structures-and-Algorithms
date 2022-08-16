
// Question Description: https://www.codingninjas.com/codestudio/problems/delete-middle-element-from-stack_985246

#include <iostream>
#include <stack>
using namespace std;

void solve(stack <int> &inputStack, int count, int size){

    // base case
    if(count == size/2){
        inputStack.pop();
        return;
    }

    int num = inputStack.top();
    inputStack.pop();

    // Recursive Call
    solve(inputStack, count+1, size);

    inputStack.push(num);
}

void deleteMiddleStack(stack <int> &inputStack, int N){
    
    int count = 0;
    solve(inputStack, count, N);
}