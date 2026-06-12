class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize!=0)
            return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num : hand){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while(!map.isEmpty()){
            if(map.size()<groupSize)
                return false;
            Map.Entry<Integer, Integer> num1 = map.firstEntry();
            if(num1.getValue() == 1)
                map.pollFirstEntry();
            else map.put(num1.getKey(), num1.getValue()-1);
            for(int i = num1.getKey()+1; i<num1.getKey() + groupSize; i++){
                if(!map.containsKey(i))
                    return false;
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
