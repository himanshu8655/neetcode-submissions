class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int n = matrix.length;
        int right = n - 1;
        int row = 0;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(target>=matrix[mid][0]){
                if(mid == n - 1 || target<matrix[mid+1][0]){
                    row = mid;
                    break;
                }
                else{
                    left = mid+1;
                }
            }

            else{
                right = mid - 1;
            }
        }

        int[] selectedRow = matrix[row];
        left = 0;
        right = selectedRow.length - 1;

        while(left<=right){
            int mid = left + (right - left)/2;
            if(target == selectedRow[mid])
                return true;
            else if(target>selectedRow[mid]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return false;
    }
}
