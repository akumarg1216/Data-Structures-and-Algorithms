/*
*
* Question Description: https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

*
*/

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

vector<long long> printFirstNegativeInteger(long long int A[],
                                            long long int N, long long int K)
{

    deque<long long int> dq;
    vector<long long> ans;

    // processing for 1st window of 'k' size

    for (int i = 0; i < K; i++)
    {
        if (A[i] < 0)
            dq.push_back(i);
    }

    // store answer of first K sized window

    if (dq.size() > 0)
    {
        ans.push_back(A[dq.front()]);
    }

    else
    {
        ans.push_back(0);
    }

    // process for remaining windows

    for (int i = K; i < N; i++)
    {

        // removing extra elements

        if (!dq.empty() && i - dq.front() >= K)
            dq.pop_front();

        // adding elements

        if (A[i] < 0)
            dq.push_back(i);

        // answer store
        if (dq.size() > 0)
            ans.push_back(A[dq.front()]);
        else
            ans.push_back(0);
    }
    return ans;
}