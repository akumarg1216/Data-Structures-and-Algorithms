/*
* Question: https://practice.geeksforgeeks.org/problems/max-rectangle/1
*
* We have to find the maximum area of rectangle formed by the element: 1.
* We are given a 2-D matrix with 0's and 1's.
* 
* Approach: First start from the first row and move to the next row.
* Add the elements going to the next row.
* Now imagine the numbers on a graph. This will be similar to making histograms.
* We can now simply follow the problem solution of "LARGEST AREA OF HISTOGRAM.cpp"
* Do so where we get 1's and in place of zero we do not add but simply put as 0 since area is only from 1.
* We store the ans in a var called "newArea".
* Compare the newArea and the area.
* Finally return the area.
*/

#include <iostream>
#include <vector>
#include <limits.h>
#include <stack>

using namespace std;
#define MAX[1000];

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;
#define MAX 1000


// } Driver Code Ends
/*You are required to complete this method*/

class Solution{
    
    private:

    vector <int> nextSmallerElement(int *arr, int n){
        stack <int> s;
        s.push(-1);
        vector <int> ans (n);

        for(int i = n-1; i >= 0; i--){
            int curr = arr[i];
            while(s.top()!=-1 && arr[s.top()] >= curr){
                s.pop();
            }
            ans[i] = s.top();
            s.push(i);
        }
        return ans;
    }

    vector <int> prevSmallerElement(int *arr, int n){
        stack <int> s;
        s.push(-1);
        vector <int> ans (n);

        for(int i = 0; i < n; i++){
            int curr = arr[i];
            while(s.top()!=-1 && arr[s.top()] >= curr){
                s.pop();
            }
            ans[i] = s.top();
            s.push(i);
        }
        return ans;
    }

    int largestRectangleArea(int* heights, int n) {

        // int n = heights.size();
        vector<int> next(n);
        next = nextSmallerElement(heights, n);

        vector<int> prev(n);
        prev = prevSmallerElement(heights, n);

        int area = INT_MIN;

        for(int i = 0; i < n; i++){
            int l = heights[i];

            if(next[i] == -1)
                next[i] = n;

            int b = next[i] - prev[i] - 1;
            int newArea = l*b;
            area = max(area, newArea);
        }
        return area;
    }
    
  public:
    int maxArea(int M[MAX][MAX], int n, int m) {
        int area = largestRectangleArea(M[0], m);
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                
                // update row by adding previous values
                if(M[i][j] != 0)
                    M[i][j] = M[i][j] + M[i-1][j];
                    
                else
                    M[i][j] = 0;
            }
        
            // entire row is now added with previous
            int newArea = largestRectangleArea(M[i], m);
            area = max(newArea, area);
        }
        return area;
    }
};