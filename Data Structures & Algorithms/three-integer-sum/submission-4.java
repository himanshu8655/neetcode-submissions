class Solution {
    public List<List<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);
        List<List<Integer>> res = new ArrayList<>();
        int n = numbers.length;
        for(int i = 0; i<n; i++){
            if(i>0 && numbers[i] == numbers[i - 1])
                continue;
            
            int num1 = numbers[i];
            int left = i + 1;
            int right = n - 1;

            while(left<right){
                int sum = num1 + numbers[left] + numbers[right];

                if(sum == 0){
                    res.add(new ArrayList<Integer>(Arrays.asList(num1,numbers[left], numbers[right])));
                    left++;
                    right--;
                    while(left<right && numbers[left] == numbers[left - 1]) left++;
                    while(left<right && numbers[right] == numbers[right + 1]) right--;
                }

                else if(sum<0)
                    left++;
                
                else
                    right--;
                
            }
        }
        return res;
    }
}
