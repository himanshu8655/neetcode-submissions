class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;//3
        int n = matrix[0].length;//4
        int left = 0;
        int right = m*n - 1;

        while(left<=right){
            int mid = left + (right - left)/2;
            int num = matrix[mid/n][mid%n];
            if(num == target)
                return true;
            
            if(target>num){
                left = mid +1;
            }
            else right = mid - 1;
        }
    
    return false;
    }
}
