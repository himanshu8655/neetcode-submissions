class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left<right){
            int mid = left + (right - left)/2;

            if(nums[left]<nums[mid])
                right = mid - 1;
            else left = mid;
        }
        return nums[left];
    }
}
