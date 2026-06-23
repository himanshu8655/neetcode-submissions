class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int currSum = 0;
        for(int num : nums){
            currSum+=num;
            if(currSum<=0)
                currSum = 0;
            else
            sum = Math.max(sum, currSum);
        }

        return sum;
    }
}
