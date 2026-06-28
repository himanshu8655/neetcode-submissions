class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> map = new HashMap<>();
        return dfs(0, nums, 0, target, map);
    }

    public int dfs(int i, int[] nums, int sum, int target,  HashMap<String, Integer> map){
         String key = i + "%" + sum;
        if(map.containsKey(key))
            return map.get(key);
            
        if(i == nums.length)
            return target == sum ? 1 : 0;
        
       
        
        int ways = dfs(i+1, nums, sum + nums[i], target, map) + dfs(i+1, nums, sum - nums[i], target, map);
        map.put(key, ways);
        return map.get(key);
    }
}
