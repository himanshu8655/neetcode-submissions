class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int currSum = 0;
        for(int num : nums){
            currSum+=num;
            if(currSum<0)
                currSum = 0;
            
            sum = Math.max(sum, currSum);
        }

        return sum;
    }
}
