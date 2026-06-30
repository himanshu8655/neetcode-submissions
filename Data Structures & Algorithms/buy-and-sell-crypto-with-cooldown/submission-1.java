class Solution {
    public int maxProfit(int[] prices) {
        HashMap<String, Integer> map = new HashMap<>();
        return dfs(0, map, true, prices);
    }

    public int dfs(int i, HashMap<String, Integer> map,boolean isBuy,int[] prices){
        if(i>=prices.length)
            return 0;
        
        String key = i + "%" + isBuy;
        if(map.containsKey(key))
            return map.get(key);
        if(isBuy){
            int val1 = dfs(i+1, map, false, prices) - prices[i];
            int val2 = dfs(i+1, map, true, prices);
            map.put(key, Math.max(val1, val2));
        }
        else{
            int val1 = dfs(i+2, map, true, prices)+prices[i];
            int val2 = dfs(i+1, map, false, prices);
            map.put(key, Math.max(val1, val2));
        }

        return map.get(key);

    }
}
