class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int top = 0;
        int left = 0;
        int bottom = n-1;
        int m = matrix[0].length;
        int right = m-1;
        List<Integer> result = new ArrayList<Integer>();
        while(top<=bottom && left<=right){
            //travserse L -> R
            for(int i = left; i<=right; i++){
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse T -> B
            for(int i = top; i<=bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;

            // Traverse R -> L
             if (top <= bottom) {
            for(int i = right; i>=left; i--){
                result.add(matrix[bottom][i]);
            }
            bottom--;
            }
            // Traverse B -> T
            if (left <= right) {
            for(int i = bottom; i>=top; i--){
                result.add(matrix[i][left]);
            }
            left++;
            }
        }
        return result;
    }
}
