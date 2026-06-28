class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(0, nums, 0, target);
    }

    public int dfs(int i, int[] nums, int sum, int target){
        if(i == nums.length)
            return target == sum ? 1 : 0;
        
        return dfs(i+1, nums, sum + nums[i], target) + dfs(i+1, nums, sum - nums[i], target);
    }
}
