#include <iostream>
#include <stack>
#include <queue>

using namespace std;

//function Template for C++

//Function to reverse the queue.
queue<int> rev(queue<int> q)
{
    // add code here.
    stack <int> s;
    
    int n = q.size();
    
    while(!q.empty()){
        int ans = q.front();
        q.pop();
        s.push(ans);
    }
    
    while(!s.empty()){
        int ans = s.top();
        s.pop();
        q.push(ans);
    }
    return q;
}