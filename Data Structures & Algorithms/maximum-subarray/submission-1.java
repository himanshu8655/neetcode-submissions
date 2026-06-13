class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int currMax = 0;
        for(int num : nums){
            currMax+=num;
            result = Math.max(result, currMax);
            if(currMax<0)
                currMax = 0;
        }
        return result;
    }
}

//2,-3,4,-2,2,1,-1,4
//currMax = -1
//res = 2
