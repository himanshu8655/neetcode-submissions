class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for(int num : nums){
            set.add(num);
        }

        for(int i = 0; i<nums.length; i++){
            int num = nums[i];
            if(set.contains(num - 1))
                continue;
            int currSum = 1;
            while(set.contains(num + 1)){
                currSum++;
                num++;
            }
            sum = Math.max(sum, currSum);
        }

        return sum;
    }
}
