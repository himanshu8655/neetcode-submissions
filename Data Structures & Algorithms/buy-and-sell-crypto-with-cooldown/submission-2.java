class Solution {
    public int maxProfit(int[] prices) {
        HashMap<String, Integer> map = new HashMap<>();
        return helper(0, map, prices, true);
    }

    public int helper(int i, HashMap<String, Integer> map, int[] prices, boolean isBuy){
        if(i>=prices.length)
            return 0;
        String key = i + "%" + isBuy;
        
        if(map.containsKey(key))
            return map.get(key);
        
        if(isBuy){
            int skip = helper(i+1, map, prices, true);
            int buy = helper(i+1, map, prices, false) - prices[i];
            map.put(key, Math.max(skip, buy));
        }
        else{
            int skip = helper(i + 1, map, prices, false);
            int sell = helper(i + 2, map, prices, true) + prices[i];
            map.put(key, Math.max(skip, sell));
        }
        return map.get(key);
    }
}
