class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0;
        int right = Arrays.stream(piles).max().orElse(0);
        int result = Integer.MAX_VALUE;
        while(left<=right){
            int mid = left + (right - left)/2;

            if(checkEatingRate(piles, mid, h)){
                result = Math.min(result, mid);
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return result;
    }

    public boolean checkEatingRate(int[] piles, int k, int h){
        if(k == 0)
            return false;
        int actualTime = 0;
        for(int pile : piles){
            int quotient = pile/k;
            int remainder = pile%k;
            actualTime+=quotient;
            if(remainder != 0)
                actualTime+=1;
        }

        return actualTime<=h;
    }
}
