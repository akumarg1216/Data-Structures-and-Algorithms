int minimumCoins(int n, vector <int> days, vector <int> cost){
    
    int ans = 0;

    queue<pair<int,int> > month;
    queue<pair<int, int> > week;

    for(int day: days){

        // step:1 - remove expired days
        while(!month.empty() && month.front().first + 30 <= day)
            month.pop();
        
        while(!week.empty() && week.front().first + 7 <= day)
            week.pop();

        // step:2 - add cost for current day
        week.push(make_pair(day, ans + cost[1]));
        month.push(make_pair(day, ans + cost[2]));

        // step:3 - update answer
        ans = min(ans+cost[0] , min(week.front().second, month.front(),second))
    }
    return ans;
}