class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left<=right){
            int mid = left + (right - left)/2;
            int midRight = mid + 1 == nums.length ? nums[0] : nums[mid + 1];
            int midLeft = mid - 1 < 0 ? nums[nums.length - 1] : nums[mid - 1];

            if(midLeft>=nums[mid] && nums[mid]<=midRight)
                return nums[mid];
            //4 5 1 2 3
            else if(nums[mid]>nums[right]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return nums[left];
    }
}
