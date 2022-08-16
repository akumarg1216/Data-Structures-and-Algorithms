#include <iostream>
#include <queue>

using namespace std;

int main(){

    queue <int> q;

    q.push(99);
    q.push(499);
    q.push(4999);
    q.push(19999);

    cout << "The size of queue is " << q.size() << endl;

    q. pop();

    cout << "The new size is " << q.size() << endl;

    q. pop();

    cout << "The front element in queue is " << q.front() << endl;

    if(q.empty())
        cout << "Queue is Empty" <<endl;
}