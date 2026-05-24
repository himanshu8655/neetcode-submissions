class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(Integer num : nums)
            sum+= num;
        return dfs(0, sum, nums, new boolean[nums.length]);
    }
    public boolean dfs(int sum1, int sum2, int[] nums, boolean[] visited){
        if(sum1 == sum2)
            return true;
        
        for(int i = 0; i<nums.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            if(dfs(sum1+nums[i], sum2 - nums[i], nums, visited))
                return true;
            visited[i] = false;
        }        

        return false;
    }
}