/*
*
* Question: https://www.codingninjas.com/codestudio/problems/deque_1170059?leftPanelTab=1
*
* Deque ----> Doubly Ended Queue
*
* In this type of queue 4 operations can be performed
*
* 1. Insert from rear -----> push_back
* 2. Insert from front ----> push_front
* 3. Delete from rear -----> pop_back
* 4. Delete from front ----> pop_front
*
*/

#include <iostream>
#include <queue>

using namespace std;

class Deque
{
    int *arr;
    int front;
    int rear;
    int size;
    
public:
    // Initialize your data structure.
    Deque(int n)
    {
        size = n;
        front = -1;
        rear = -1;
        arr = new int[n];
    }

    // Pushes 'X' in the front of the deque. Returns true if it gets pushed into the deque, and false otherwise.
    bool pushFront(int x)
    {
        if(isFull())
            return false;
        
        else if(isEmpty())
            front = rear = 0;
        
        else if(front == 0 && rear != size-1)
            front = size-1;
        
        else
            front--;
        
        arr[front] = x;
        return true;
            
    }

    // Pushes 'X' in the back of the deque. Returns true if it gets pushed into the deque, and false otherwise.
    bool pushRear(int x)
    {
        if(isFull())
            return false;
        
        else if (isEmpty())
            front = rear = 0;
        
        else if(rear == size - 1 && front != 0)
            rear = 0;
        
        else
            rear++;
        
        arr[rear] = x;
        return true;
            
    }

    // Pops an element from the front of the deque. Returns -1 if the deque is empty, otherwise returns the popped element.
    int popFront()
    {
        if(isEmpty())                // check for empty
            return -1;
        
        int ans = arr[front];
        arr[front] = -1;
        
        if(front == rear)            // if single element
            front = rear = -1;
            
        else if(front == size-1)    // to maintain cyclicity
            front = 0;
        
        else                        // normal flow
            front++;
        
        return ans;
    }

    // Pops an element from the back of the deque. Returns -1 if the deque is empty, otherwise returns the popped element.
    int popRear()
    {
        if(isEmpty())                // check empty
            return -1;
        
        int ans = arr[rear];
        arr[rear] = -1;
        
        if(front == rear)            // for single element
            front = rear = -1;
        
        else if(rear == 0)            // to maintain cyclicity
            rear = size - 1;
        
        else
            rear --;                // normal flow
        
        return ans;
    }

    // Returns the first element of the deque. If the deque is empty, it returns -1.
    int getFront()
    {
        if(isEmpty())
            return -1;
        else
            return arr[front];
            
    }

    // Returns the last element of the deque. If the deque is empty, it returns -1.
    int getRear()
    {
        if(isEmpty())
            return -1;
        else
            return arr[rear];
    }

    // Returns true if the deque is empty. Otherwise returns false.
    bool isEmpty()
    {
        if(front == -1)
            return true;
        else
            return false;
    }

    // Returns true if the deque is full. Otherwise returns false.
    bool isFull()
    {
        if((front == 0 && rear == size-1) || (front != 0 && rear == (front-1) % (size-1)))
            return true;
        else
            return false;
    }
};