class Solution {
    public int maxProfit(int[] prices) {
        HashMap<String, Integer> hmp = new HashMap<>();
        return dfs(0, hmp, prices, true);
    }

    public int dfs(int i, HashMap<String, Integer> map, int[] prices, boolean isBuying){
        if(i>=prices.length)
            return 0;
        String key = i + "," + isBuying;
        if(map.containsKey(key))
            return map.get(key);
        
        if(isBuying){
            int buy = dfs(i+1, map, prices, false) - prices[i];
            int cooldown = dfs(i+1, map, prices, true);
            map.put(key, Math.max(buy, cooldown));
        }
        else{
            int sell = dfs(i+2, map, prices, true) + prices[i];
            int cooldown = dfs(i+1, map, prices, false);
            map.put(key, Math.max(sell, cooldown));
        }
        return map.get(key);
    }
}
