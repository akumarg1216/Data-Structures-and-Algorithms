/*
 * problem
 * The problem statement states that there are n houses in a circle.
 * We are given an array consisting of amounts present in each house.
 * Our target is to make the robber get the max amount.
 * 
 * Problem-1: The houses adjacent cannot be robbed since they have a security system attached that will ring the alarm if 2 adjacent houses are broken.
 * 
 * Note: Since the houses are in circle the first & last houses will be adjacent.
 * 
 * We will use the approach of maximum Sum of Adjacent Numbers, taking the case:
 * 
 * (1). If the last house is robbed, we eliminate the first and get --> solution_1
 * (2). If the first house is robbed, we eleminate the last and get --> solution_2
 * 
 * Finally the max(solution1, solution2) gives us the answer.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)// for arraylist + O(n)// for function call ~~ O(n) 
 */