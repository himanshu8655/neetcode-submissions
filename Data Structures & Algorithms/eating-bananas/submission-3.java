class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = Arrays.stream(piles).max().orElse(0);
        int left = 0;
        int result = h;
        while(left<=right){
            int mid = left + (right - left)/2;

            if(canEat(piles, mid, h)){
                right = mid - 1;
                result = Math.min(result, mid);
            }
                
            else left = mid + 1;
        }

        return result;
    }

    public boolean canEat(int[] piles, int k, int h){
        int noOfHours = 0;
        if(k == 0)
            return false;
        for(int pile : piles){
            int quotient = pile/k;
            int remainder = pile%k;
            noOfHours+=quotient;
            if(remainder!=0)
                noOfHours+=1;
        }

        return noOfHours<=h;
    }
}
