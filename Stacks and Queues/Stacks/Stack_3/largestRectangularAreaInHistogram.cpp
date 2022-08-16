/*
* The question is to find the largest area of the histogram in rectangular shape.
* The catch is that we take a bar and look to the left & right of that.
* 
* If to the left the height of the bar is same or large then we continue till we find the small bar. We store the 
* index of the smaller bar called as prevSmallestBar and assign it to "previous". 
* Else if no bar is present on left p = -1.
*
* Similarly, we move to the right till we find a bar smaller than the current bar. We call that the nextSmallestBar
* and assign it to the "next". Else next = -1.
*
* Since the length will be constant and only width will change, so to get the actual width we use the formula:
* next - previous - 1.
*
* For the area we multiply the length with the width obtained using above formula and store that to the variable called
* newArea and compare the maximum of area & newArea.
*
* Time Complexity: O(n)
* Space Complexity: O(n)
*
* Question Description: https://leetcode.com/problems/largest-rectangle-in-histogram/
*
*/

#include <iostream>
#include <vector>
#include <stack>
#include <limits.h>

using namespace std;

class Solution {
    
private:
    
    vector <int> nextSmallerElement(vector<int>arr, int n){
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
    
    vector <int> prevSmallerElement(vector<int>arr, int n){
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
    
public:
    int largestRectangleArea(vector<int>& heights) {
        
        int n = heights.size();
        
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
};