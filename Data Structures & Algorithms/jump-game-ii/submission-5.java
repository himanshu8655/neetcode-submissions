class Solution {
    public int jump(int[] nums) {
        int maxJump = 0;
        int noOfJumps = 0;//1
        int currInterval = 0;//2
        if(nums.length == 1)
            return 0;
        for(int i = 0; i<nums.length; i++){
            maxJump = Math.max(maxJump,i + nums[i]);//2, 5
            if(currInterval == i){
                currInterval = maxJump;
                noOfJumps++;
            }
            if(currInterval>=nums.length - 1)
                break;
        }

        return noOfJumps;
    }
}
