class TimeMap {
    Map<String, List<Pair>> store;
    class Pair{
        String value;
        int timestamp;

        Pair(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k->new ArrayList<Pair>()).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!store.containsKey(key))
            return "";
        List<Pair> list = store.get(key);
        if(list.get(list.size() - 1).timestamp<=timestamp)
            return list.get(list.size() - 1).value;
        else return binarySearch(list, timestamp);
    }

    public String binarySearch(List<Pair> list, int timestamp){
        int left = 0;
        int right = list.size() - 1;
        Pair result = null;
        while(left<=right){
            int mid = left + (right - left)/2;
            Pair pair = list.get(mid);
            if(timestamp == pair.timestamp)
                return pair.value;
            else if(pair.timestamp<timestamp){
                result = pair;
                left = mid + 1;
            }
            else right = mid - 1;
        }

        return result == null ? "" : result.value;
    }
}
