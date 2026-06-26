class Solution {
    public int maxProduct(int[] nums) {

        int result = 0;
        int currMax = 1;

        for(int num : nums){
            currMax*=num;
            result = Math.max(result, currMax);
            if(currMax == 0)
                currMax = 1;
        }

        return result;
    }
}
