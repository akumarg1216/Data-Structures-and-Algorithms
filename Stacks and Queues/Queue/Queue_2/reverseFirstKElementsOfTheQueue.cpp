/*
 *
 * Question Description: https://practice.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1
 *
 */

#include <bits/stdc++.h>
using namespace std;

// Function to reverse first k elements of a queue.
queue<int> modifyQueue(queue<int> q, int k)
{
    // add code here.

    stack<int> s;

    // put first 'k' elements into the stack

    for (int i = 0; i < k; i++)
    {
        int val = q.front();
        q.pop();
        s.push(val);
    }

    // fetch from stack and add to queue
    while (!s.empty())
    {
        int val = s.top();
        s.pop();
        q.push(val);
    }

    // now fetch n-k elements from the queue and push_back to get the desired output

    int index = q.size() - k;

    while (index--)
    {
        int val = q.front();
        q.pop();
        q.push(val);
    }

    return q;
}