class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int profit = 0;
        int n = prices.length;
        for(int sell = 1; sell<prices.length; sell++){
            if(prices[sell-1]>prices[sell]){
                continue;
            }
            else{
                profit+=prices[sell] - prices[sell-1];
            }
        }
        return profit;
    }
}