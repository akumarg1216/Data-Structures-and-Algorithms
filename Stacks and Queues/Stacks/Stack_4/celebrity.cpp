/*
* Question: https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1
*
* The problem states that there are n number of person in a party.
* In that party one celebrity is present.
* 
* The condition is given as:
* 1. The celebrity is known by everyone denoted as 1.
* 2. The celebrity knows none of the people and it is denoted as 0.
* We are given a 2-D matrix of 0's & 1's.
*
* Approach: 
* 1. We push each item to the stack and pop them and check if A knows B or B knows A.
* 2. We continue the process till only a single item is left in the stack.
* 3. We have to check the row that has all the elements as 0.
* 4. We have to check the col corresponding to the row that has all the elements as 1 except for the diagnol element.
*/

#include <iostream>
#include <stack>
#include <vector>
using namespace std;

class Solution 
{
    public:
    //Function to find if there is a celebrity in the party or not.
    int celebrity(vector<vector<int> >& M, int n) 
    {
        stack <int> s;
    
    // step-1: push all the elements into the stack
    for (int i = 0; i < n; i++)
    {
        s.push(i);
    }
    
    // step-2: get 2 elements from the stack and compare them.
    while(s.size() > 1){

        int a = s.top();
        s.pop();

        int b = s.top();
        s.pop();

        if(M[a][b] == 1){
            s.push(b);
        }
        else{
            s.push(a);
        }
    }
        
    int ans = s.top();

    // step-3: now only a single element is left in stack that can be a celebrity after the below checks.
    // 1. The row must contain all '0' and the column must have all '0' except a single case.

    int rowZeroCount = 0;

    for(int i = 0; i < n; i++){
        if(M[ans][i] == 0)
            rowZeroCount++;
    }

    // check for all zeros in the row.
    if(rowZeroCount != n)
        return -1;

    int colZeroCount = 0;

    for(int i = 0; i < n; i++)
    {
        if(M[i][ans] == 1)
            colZeroCount++;
    }

    if(colZeroCount != n-1)
        return -1;

    return ans;
    }
};