class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize != 0)
            return false;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int num : hand){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while(!map.isEmpty()){
                Map.Entry<Integer, Integer> entry = map.firstEntry();
                int startValue = entry.getKey();
                if(entry.getValue() == 1)
                    map.remove(startValue);
                else
                    map.put(startValue, map.get(startValue) - 1);

                for(int i = startValue+1; i<startValue+groupSize; i++){
                    if(!map.containsKey(i)){
                        return false;
                    }
                        
                    int val = map.get(i);
                    if(val == 1)
                        map.remove(i);
                    else
                        map.put(i, val - 1);
                }
            
        }
        return true;
    }
}
