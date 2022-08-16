/*
* Question Link:
https://www.codingninjas.com/codestudio/problems/design-a-stack-that-supports-getmin-in-o-1-time-and-o-1-extra-space_842465
*
* Approach:
* 1. We take a variable mini.
* 2. In case of push operation, we take 2*data - mini --> to get the prevMin value and update that to the newest min.
* 3. In case of pop operation, we take 2*mini - curr --> to get the nextMin value after the pop operation.
*/

#include <iostream>
#include <stack>

using namespace std;

class SpecialStack
{
    // Define the data members.

    stack<int> s;
    int mini;
    /*----------------- Public Functions of SpecialStack -----------------*/
public:
    void push(int data)
    {
        if (s.empty())
        {
            s.push(data);
            mini = data;
        }
        else
        {
            if (data < mini)
            {
                s.push(2 * data - mini);
                mini = data;
            }
            else
            {
                s.push(data);
            }
        }
    }

    int pop()
    {
        if (s.empty())
            return -1;

        int curr = s.top();
        s.pop();

        if (curr > mini)
        {
            return curr;
        }
        else
        {
            int prevMin = mini;
            int val = 2 * mini - curr;
            mini = val;
            return prevMin;
        }
    }

    int top()
    {
        if (s.empty())
            return -1;

        int curr = s.top();
        if (curr < mini)
        {
            return mini;
        }
        else
        {
            return curr;
        }
    }

    bool isEmpty()
    {
        return s.empty();
    }

    int getMin()
    {
        if (s.empty())
            return -1;

        return mini;
    }
};