#include <iostream>
#include <queue>

using namespace std;

int main(){

    deque <int> q;

    q.push_back(99);
    q.push_back(499);
    q.push_front(4999);
    q.push_front(19999);

    cout << "The size of queue is " << q.size() << endl;

    q. pop_back();

    cout << "The new size is " << q.size() << endl;

    q. pop_front();

    cout << "The front element in queue is " << q.front() << endl;

    if(q.empty())
        cout << "Queue is Empty" <<endl;
}