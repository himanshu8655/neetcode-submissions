class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;
        int maxProfit =  0;
        while(sell<prices.length){
            int sellPrice = prices[sell];
            int buyPrice = prices[buy];
            int profit = sellPrice - buyPrice;
            maxProfit = Math.max(profit, maxProfit);
            if(sellPrice<buyPrice){
                buy = sell;
            }
            sell++;
        }

        return maxProfit;
    }
}
