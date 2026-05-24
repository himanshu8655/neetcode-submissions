class Solution {
    public int maxProfit(int[] prices) {
        int buyPointer = 0;
        int result = 0;
        int n = prices.length;
        for(int i = 1; i<n; i++){
            if(prices[i]<prices[buyPointer]){
                buyPointer = i;
            }
            else{
                result = Math.max(result, prices[i] - prices[buyPointer]);
            }
        } 

        return result;       
    }
}
