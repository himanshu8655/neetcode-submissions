class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int result = 0;

        for(int sell = 1; sell<prices.length; sell++){
            if(prices[buy]<prices[sell]){
                result = Math.max(result, prices[sell] - prices[buy]);
            }
            else{
                buy = sell;
            }
        }
        return result;
    }
}
