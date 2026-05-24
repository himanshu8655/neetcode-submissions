class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            int num = nums[i];
            if(freq.containsKey(num))
                return new int[]{freq.get(num), i};
            else
                freq.put(target - num, i);
        }
    return new int[]{};
    }
}
