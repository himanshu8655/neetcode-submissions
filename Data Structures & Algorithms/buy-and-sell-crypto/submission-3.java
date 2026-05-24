class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = 0;
        int sell = 1;
        int n = prices.length;

        while(sell<n){
            if(prices[buy]>prices[sell]){
                buy = sell;
                sell++;
                continue;
            }
            maxProfit = Math.max(prices[sell] - prices[buy], maxProfit);
            sell++;
        }
        return maxProfit;
    }
}
