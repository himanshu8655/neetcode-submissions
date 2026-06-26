class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2 == 1)
            return false;
        int target = sum/2;
        Set<Integer> set1 = new HashSet<>();
        set1.add(0);
        //0 1
        //0 1 2 3
        //0 1 2 3 4 5 6
        for(int num : nums){
            HashSet<Integer> newSet = new HashSet<>();
            for(int val : set1){
                if(val + num == target)
                    return true;
                newSet.add(val);
                newSet.add(val + num);
            }
            set1 = newSet;
        }
        return false;
    }
}
