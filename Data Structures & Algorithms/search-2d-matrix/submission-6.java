class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        int i = 0;
        while(left<=right){
            int mid = left + (right - left)/2;

            if(matrix[mid][0]<=target){
                i = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        System.out.println(i);
        left = 0;
        right = matrix[0].length - 1;
        while(left<=right){
            int mid = left + (right - left)/2;

            if(matrix[i][mid] == target)
                return true;
            
            else if(matrix[i][mid]<target)
                left = mid + 1;
            else right = mid - 1;
        }
    
    return false;
    }
}
