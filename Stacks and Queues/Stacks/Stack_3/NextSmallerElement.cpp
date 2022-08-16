#include <iostream>
#include <stack>
#include <vector>
#include <string>

using namespace std;

vector<int> nextSmallerElement(vector<int> &arr, int n)
{
    stack <int> s;
    s.push(-1);
    
    vector <int> ans(n);
    
    for(int i = n-1; i >=0; i--){
        int curr = arr[i];
        
        while(s.top() >= curr){
            s.pop();
        }
        
        ans[i] = s.top(); 
        s.push(curr);
    }
    return ans;
}

// int main(){
//     vector<int> vect{ 2, 1, 5, 6, 2, 3 };
//     int n = vect.size();

//     vector<int> ret = nextSmallerElement(vect, n);

//     // cout << "Answer: " << ret << endl;
// }