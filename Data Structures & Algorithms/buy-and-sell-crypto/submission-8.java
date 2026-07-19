class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int maxProfit = 0;

        for(int sell = 1; sell<prices.length; sell++){
            int buyPrice = prices[buy];
            int sellPrice = prices[sell];
            int profit = sellPrice - buyPrice;
            if(profit>0){
                maxProfit = Math.max(maxProfit, profit);
            }
            else{
                buy = sell;
            }
        }
        return maxProfit;
    }
}
