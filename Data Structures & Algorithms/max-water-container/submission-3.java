class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxi = 0;
        while(left<right){
            int minHeight = Math.min(heights[left], heights[right]);
            int currArea = minHeight * (right - left);
            maxi = Math.max(currArea, maxi);
            if(heights[left]<heights[right])
                left++;
            else right--;
        }
    return maxi;
    }
}
