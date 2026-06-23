class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int currSum = 0;
        for(int num : nums){
            currSum+=num;
            sum = Math.max(currSum, sum);
            if(currSum<0)
                currSum = 0;
        }

        return sum;
    }
}
