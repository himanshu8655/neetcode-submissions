class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;
        int maxProfit = 0;
        while(sell<prices.length){
            int sellPrice = prices[sell];
            int buyPrice = prices[buy];
            int currProfit = sellPrice - buyPrice;
            maxProfit = Math.max(maxProfit, currProfit);
            if(buyPrice>sellPrice){
                buy = sell;
            }
            sell++;
        }

        return maxProfit;
    }
}
