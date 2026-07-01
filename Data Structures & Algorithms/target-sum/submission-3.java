class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> dp = new HashMap<>();
        return helper(0, nums, 0, target, dp);
    }

    public int helper(int i, int[] nums, int sum, int target, HashMap<String, Integer> dp){
        if(i == nums.length)
            return sum == target ? 1 : 0;

        String key = i + "%" + sum;
        if(dp.containsKey(key))
            return dp.get(key);
        
        return helper(i+1, nums, sum + nums[i], target, dp) + helper(i+1, nums, sum - nums[i], target, dp);
    }
}
