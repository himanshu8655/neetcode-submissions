class Solution {
    public int maxProduct(int[] nums) {

        int result = Integer.MIN_VALUE;
        int currMax = 1;

        for(int num : nums){
            currMax*=num;
            result = Math.max(result, currMax);
            if(currMax == 0)
                currMax = 1;
        }
        currMax = 1;
         for(int i = nums.length - 1; i>=0; i--){
            currMax*=nums[i];
            result = Math.max(result, currMax);
            if(currMax == 0)
                currMax = 1;
        }

        return result;
    }
}
