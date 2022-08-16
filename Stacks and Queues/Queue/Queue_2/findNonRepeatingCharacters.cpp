/*
 *
 * Question Description: https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1
 *
 */

#include <iostream>

using namespace std;

#include <bits/stdc++.h>

class Solution
{
public:
    string FirstNonRepeating(string A)
    {

        queue<char> q;
        unordered_map<char, int> count;
        string ans = "";

        for (int i = 0; i < A.length(); i++)
        {

            char ch = A[i]; // fetching the char
            count[ch]++;    // increaing the count of char to keep track of occurances

            q.push(ch);

            while (!q.empty())
            {
                if (count[q.front()] > 1)
                { // check for repeat
                    q.pop();
                }
                else
                {
                    ans.push_back(q.front()); // not repeating store in ans
                    break;
                }
            }
            if (q.empty())
            { // repeat mein sare pop ho gye th q empty push #
                ans.push_back('#');
            }
        }
        return ans;
    }
};