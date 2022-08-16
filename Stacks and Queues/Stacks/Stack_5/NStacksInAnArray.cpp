/*
* Question Description: https://www.codingninjas.com/codestudio/problems/n-stacks-in-an-array_1164271
*
* Given N representing the no of stacks,
* S = size of array
* Q = no of queries (operations i.e, push or pop)
*
* We have to implement the N stacks in an array if S size.
*
* Approach:
* Next array: stores the next free index
* top array: stores the top element for each stack
* arr: stores the stack elements
* freespot: indicates the next index for insertion.
*
* Flow for push operation:
*
* 1. Check for overflow --> if(freespot == -1)
* 2. Find empty index ----> int index = freespot
* 3. update freespot -----> freespot = next[index];
* 4. insert element ------> arr[index] = x; 
* 5. update next  --------> next[index] = top[m-1]; 
* 6. update top ----------> top[m-1] = index;
*
* Flow for Pop operation:
* 1. Check for underflow.
* 2. Write the bottom - up for the push operation with reverse operands.
* 3. Ignore the insert element step.
*
* Time Complexity: O(1)
* Space Complexity: O(n + s + s) --> O(2s + n) --> Ignoring constant --> O(n + s)
*
*/

#include <iostream>
#include <stack>

using namespace std;

class NStack
{
    int *arr;
    int *top;
    int *next;
    
    int n, s;
    int freespot;
    
public:
    // Initialize your data structure.
    NStack(int N, int S)
    {
        n = N;
        s = S;
        arr = new int[s];
        next = new int[s];
        top = new int[n];
        
        // top initialise
        for(int i = 0; i < n; i++){
            top[i] = -1;
        }
        
        // next initialise
        for(int i = 0; i < s; i++){
            next[i] = i+1;
        }
        
        // updating last index of next to -1
        next[s-1] = -1;
        
        // initialising freespot
        freespot = 0;
    }

    // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack, and false otherwise.
    bool push(int x, int m)
    {
        // check for overflow
        if(freespot == -1)
            return false;
        
        // find empty index
        int index = freespot;
        
        // update freespot
        freespot = next[index];
        
        // insert element
        arr[index] = x;
        
        // update next
        next[index] = top[m-1];
        
        // update top
        top[m-1] = index;
        
        return true;
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
    int pop(int m)
    {
        // check for underflow
        if(top[m-1] == -1)
            return -1;
        
        // move opposite of push operation
        int index = top[m-1];
        
        top[m-1] = next[index];
        
        next[index] = freespot;
        
        freespot = index;
        
        return arr[index];
    }
};
