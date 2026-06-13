class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1)
            return 0;
        int farthest = 0;
        int currFar = 0;
        int n = nums.length;
        int jump = 0;
        for(int left = 0; left<n; left++){
            farthest = Math.max(farthest, nums[left] + left);
            if(currFar == left){
                currFar = farthest;
                jump++;
            }
            if(currFar>=n-1)
                return jump;
        }

        return jump;
    }
}
