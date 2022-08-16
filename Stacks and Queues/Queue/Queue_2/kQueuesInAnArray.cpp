#include <iostream>

using namespace std;

class kQueue{
    
    public:
        int n;
        int k;
        int *front;
        int *rear;
        int *arr;
        int *next;
        int freeSpot;

    public:
        kQueue(int n, int k){
            this -> n = n;
            this -> k = k;
            front = new int[k];
            rear = new int [k];

            for(int i = 0; i < k; i++){
                front[i] = -1;
                rear[i] = -1;
            }

            next = new int[n];
            for(int i = 0; i < n; i++){
                next[i] = i+1;
            }
            next[n-1] = -1;

            arr = new int[n];
            freeSpot = 0;
        }

    void enqueue(int data, int qn){

        // check for overflow
        if(freeSpot == -1){
            cout << "Queue is Full. Cannot push." <<endl;
            return;
        }

        // find first free index
        int index = freeSpot;

        // update freeSpot
        freeSpot = next[index];

        // is the element enquing the first element?
        if(front[qn-1] == -1)
            front[qn-1] = index;
        else
            // link new element to the previous element
            next[rear[qn-1]] = index;

        // update next
        next[index] = -1;

        // update rear
        rear[qn-1] = index;

        // push element
        arr[index] = data;    
    }

    int dequeue(int qn){

        // check underflow
        if(front[qn-1] == -1){
            cout << "Queue Underflow. No element in Queue to pop." << endl;
            return -1;
        }

        // find index to delete
        int index = front[qn-1];

        // front ko update karo
        front[qn-1] = next[index];

        // freeSlot ko update karo
        next[index] = freeSpot;
        freeSpot = index;

        return arr[index];    
    }

};

int main(){

    kQueue q(10, 3);

    q.enqueue(99, 1);
    q.enqueue(499, 2);
    q.enqueue(999, 3);
    q.enqueue(5999, 1);
    q.enqueue(199, 2);
    q.enqueue(3999, 1);

    cout << q.dequeue(1) <<endl;
    cout << q.dequeue(3) <<endl;
    cout << q.dequeue(1) <<endl;

    return 0;
}