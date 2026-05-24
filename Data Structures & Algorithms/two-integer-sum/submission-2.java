class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hmp = new HashMap<Integer, Integer>();

        for(int i = 0; i<nums.length; i++){
            if(hmp.containsKey(nums[i]))
                return new int[]{hmp.get(nums[i]), i};
            else hmp.put(target - nums[i], i);
        }
        return new int[]{};
    }
}
