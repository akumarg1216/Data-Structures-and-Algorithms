/*
 * Question Description: https://practice.geeksforgeeks.org/problems/circular-tour-1587115620/1
 */

#include <iostream>

using namespace std;

class Solution
{
public:
    struct petrolPump
    {
        int petrol;
        int distance;
    };

    // Function to find starting point where the truck can start to get through
    // the complete circle without exhausting its petrol in between.
    int tour(petrolPump p[], int n)
    {
        int balance = 0;
        int deficit = 0;
        int start = 0;

        for (int i = 0; i < n; i++)
        {
            balance += p[i].petrol - p[i].distance; // getting balance after each traversal

            if (balance < 0)
            {
                deficit += balance; // deficit of petrol after which we cannot move.
                start = i + 1;      // reset the start
                balance = 0;        // reset balance to zero
            }
        }

        if (deficit + balance >= 0)
        { // the sum of deficit and balance if greater than zero, circle possible.
            return start;
        }
        else
        {
            return -1; // if not circle not psossible.
        }
    }
};
