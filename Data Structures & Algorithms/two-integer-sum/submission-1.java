class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hmp = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            int num = nums[i];
            int diff = target - num;
            if(hmp.containsKey(num))
                return new int[]{hmp.get(num), i};
            hmp.put(diff, i);
        }

        return new int[]{};   
    }
}
