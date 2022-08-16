# include <iostream>
using namespace std;

class Stack{

    // properties
    public:
        int *arr;
        int top;
        int size;

    // behaviour
    Stack (int size){
        this -> size = size;
        arr = new int [size];
        top = -1;
    }

    void push (int element){
        if(size - top > 1){
            top++;
            arr[top] = element;
        }
        else{
            cout << "Stack Overflow" <<endl;
        }
    }

    void pop(){
        if(top >= 0){
            top--;
        }
        else{
            cout << "Stack Underflow - Stack khali hai" <<endl;
        }
    }

    int peek(){
        if(top >= 0){
            return arr[top];
        }
        else{
            cout << "Stack khali hai" <<endl;
            return -1;
        }
    }

    bool isEmpty(){
        if(top == -1)
            return true;
        else
            return false;
    }
};

int main(){

    Stack st(6);

    st.pop();

    st.push(99);
    st.push(199);
    st.push(499);
    st.push(1099);

    cout << st.peek() <<endl;

    st.pop();

    cout << st.peek() <<endl;

    st.pop();
    if(st.isEmpty()){
        cout << "Stack mein koi element nahi hai" <<endl;
    }
    else{
        cout << "Stack mein elements hai" << endl;
    }

    cout << st.peek() <<endl;

    cout << st.peek() <<endl;
}