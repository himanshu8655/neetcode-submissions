class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int num : hand)
            map.put(num,map.getOrDefault(num,0)+1);
        //{ 2:1; 3:1; 4:1; 5:1}
        while(!map.isEmpty()){
            int startValue = map.firstEntry().getKey();

            for(int i = startValue; i<startValue+groupSize; i++){
                if(!map.containsKey(i))
                    return false;
                int value = map.get(i);
                if(value == 1)
                    map.remove(i);
                else map.put(i, value-1);
            }
        }
        return true;
    }
}
