/*
*
* Question Description: https://www.codingninjas.com/codestudio/problems/sort-a-stack_985275

* The challenge is to sort the stack elements.

* We first take out the top element and keep it stored.

* We then recursively call the stack to sort itself.

* While sorting the array first gets empty and then on it's way of return call back, it takes the elements stored.

* Now the recursion will have the array sorted.

* But in recursion we only do things for a single case.

* In this case let us say that we are taking a single element and we want to insert it in sorted manner.

* So the stack is again popped till the element less than the number to be inserted is found.\

* We insert the element on top of that smaller element.

* On the way back again we take the element popped and insert it back to the stack.

*/

# include <iostream>
# include <stack>
using namespace std;

void sortedInsert(stack <int> &stack, int num){
    
    // base case
    if(stack.empty() || (!stack.empty() && stack.top() < num)){     // checking if the element is greater than prev.
        stack.push(num);                                      // inserting the element at its sorted position.         
        return;
    }
    
    int n = stack.top();            // keeping the element stored in a memory.
    stack.pop();                            // taking the top element out till the element less than insert is found.
    
    // recursive call
    sortedInsert(stack, num);
    stack.push(n);                      // after insertion at correct place taking back the elements removed.
}


void sortStack(stack<int> &stack)
{
    // base case
    if(stack.empty())
        return;
    
    int num = stack.top();          // taking the top element and storing that in the variable
    stack.pop();                       // deleting the top element from the stack
    
    // recursive call
    sortStack(stack);               // sorting the stack
    sortedInsert(stack, num);           // inserting the elements in the sorted manner.
}