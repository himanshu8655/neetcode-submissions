class Solution {
    public int jump(int[] nums) {
        int currentEnd = 0;
        int farthest = 0;
        int left = 0;
        int n = nums.length - 1;
        int jump = 0;
        while(currentEnd<n){
            int num = nums[left]; //1
            farthest = Math.max(farthest, num+left); //4
            if(left == currentEnd){
                currentEnd = farthest;//2//4
                jump++;//1//2
            }
            left++;//3
        }

        return jump;   
    }
}
