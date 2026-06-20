class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            if(i>0 && nums[i] == nums[i-1])
                continue;
            int num1 = nums[i];
            int left = i+1;
            int right = nums.length - 1;

            while(left<right){
                int num2 = nums[left];
                int num3 = nums[right];
                int sum = num1 + num2 + num3;
                if(sum == 0){
                    result.add(new ArrayList<Integer>(Arrays.asList(num1, num2, num3)));
                    left++;
                    right--;
                    while(left<right && nums[left] == nums[left-1]){left++;}
                    while(left<right && nums[right] == nums[right+1]){right--;}

                }
                else if(sum<0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return result;
    }
}
