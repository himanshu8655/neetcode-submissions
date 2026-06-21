class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int n = matrix.length;
        int right = n - 1;
        int row = -1;
        while(left<=right){
            int mid = left + (right - left)/2;

            if(target>=matrix[mid][0]){
               if(mid + 1 == n || matrix[mid + 1][0]<target){
                row = mid;
                break;
               }
               else{
                left = mid + 1;
               }
            }
            else{
                right = mid - 1;
            }
            
        }
        if(row == -1)
            return false;

        left = 0;
        int[] rowMatrix = matrix[row];
        right = rowMatrix.length - 1;

        while(left<=right){
            int mid = left + (right - left)/2;

            if(rowMatrix[mid] == target)
                return true;
            if(rowMatrix[mid]>=target){
                right = mid - 1;
            }
            else left = mid + 1;
        }
    return false;
    }
}
