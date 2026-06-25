class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;//3
        int n = matrix[0].length;//4
        int left = 0; // 0
        int right = m*n - 1; // 11

        while(left<=right){
            int mid = left + (right - left)/2;//5
            int num = matrix[mid/n][mid%n];
            //i = 1; j = 5
            if(num == target){
                return true;
            }
            else if(target>num){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return false;
    }
}
