class Solution {
    public int maxSubArray(int[] nums) {
     int result = Integer.MIN_VALUE;
     int currSum = 0;

     for(int num : nums){
        currSum+=num;
        if(currSum<num)
            currSum = num;
        result = Math.max(currSum, result);
     }
     return result;   
    }
}
