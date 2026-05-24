class Solution {
 public int[] topKFrequent(int[] nums, int k) {
	        HashMap<Integer, Integer> freq = new HashMap<>();
            int[] res = new int[k];
	        for(int num : nums){
	            int currNum = freq.getOrDefault(num, 0);
	            freq.put(num, currNum+1);
	        }

	        ArrayList<ArrayList<Integer>> lst = new ArrayList<>(nums.length+1);
            for(int i = 0; i<nums.length+1; i++){
                lst.add(new ArrayList<Integer>());
            }
	        for(Map.Entry<Integer, Integer> map : freq.entrySet()){
	            	lst.get(map.getValue()).add(map.getKey());
	            
	        }
            int idx = 0;
            for(int i = lst.size()-1; i>=0; i--){
                ArrayList<Integer> arr = lst.get(i);
                    for(Integer num : arr){
                        if(k == idx)
                            return res;
                        res[idx] = num;
                        idx++;
                        }
                
            }

            return res;
	    }
}
