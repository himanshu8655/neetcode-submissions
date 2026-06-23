class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        List<int[]> filteredTriplets = new ArrayList<>();

        for(int[] triplet : triplets){
            if(target[0]>=triplet[0] && target[1]>=triplet[1] && target[2]>=triplet[2]){
                filteredTriplets.add(triplet);
            }
        }
        boolean[] checkTarget = new boolean[3];
        for(int[] triplet : filteredTriplets){
            if(triplet[0] == target[0])
                checkTarget[0] = true;
            if(triplet[1] == target[1])
                checkTarget[1] = true;
            if(triplet[2] == target[2])
                checkTarget[2] = true;
        }

        for(int i = 0; i<3; i++){
            if(!checkTarget[i])
                return false;
        }

        return true;
    }
}
