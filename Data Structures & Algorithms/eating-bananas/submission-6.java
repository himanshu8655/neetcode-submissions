class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().orElse(0);
        int left = 1;
        int right = max;
        int res = Integer.MAX_VALUE;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(canEat(piles, mid, h)){
                res = mid;
                right = mid - 1;
                
            }
            else{
                left = mid + 1;
            }
        }
        return res;
    }

    public boolean canEat(int[] piles, int noOfBanana, int h){
        int res = 0;
        for(int pile : piles){
            int quotient = pile/noOfBanana;
            int remainder = pile%noOfBanana;
            res+=quotient;
            if(remainder!=0)
                res+=1;
        }
        return res<=h;
    }
}
