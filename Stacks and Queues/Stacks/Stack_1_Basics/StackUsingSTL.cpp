#include <iostream>
#include <stack>
using namespace std;

int main(){

    // stack bana rhe hain
    stack <int> stack;

    // push kr rhe
    stack.push(45);
    stack.push(99);

    // pop operation
    stack.pop();

    // check for empty
    if(stack.empty()){
        cout << "Stack is empty" << endl;
    }
    else{
        cout << "Stack is not empty" << endl;
    }

    cout << "Printing top element " << stack.top() << endl;

    return 0;
}
