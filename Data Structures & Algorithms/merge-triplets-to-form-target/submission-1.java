class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        List<int[]> list = new ArrayList<>();
        for(int[] triplet : triplets){
            if(triplet[0]<=target[0] && triplet[1]<=target[1] && triplet[2]<=target[2])
                list.add(triplet);
        }
        boolean[] checkTriplet = new boolean[3];
        for(int[] triplet : list){
            for(int i = 0; i<3; i++){
                if(triplet[i] == target[i])
                    checkTriplet[i] = true;
            }
        }

        for(int i = 0; i<3; i++){
            if(!checkTriplet[i])
                return false;
        }
    return true;
    }
}
