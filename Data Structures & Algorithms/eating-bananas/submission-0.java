class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = Arrays.stream(piles).max().getAsInt();
        int left = 1;
        int maxi = 0;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(isValid(piles, mid, h)){
                right = mid - 1;
                maxi = mid;
            }
            else{
                left = mid + 1;
            }

        }
        return maxi;
    }

    public boolean isValid(int[] piles, int ratePerHr, int h){
        int res = 0;
        for(int pile : piles){
            res+=pile/ratePerHr;
            if(pile%ratePerHr!=0)
                res++;
        }
        return res<=h;
    }
}
