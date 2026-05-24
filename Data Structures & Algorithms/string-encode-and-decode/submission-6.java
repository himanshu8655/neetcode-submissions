class Solution {

    public String encode(List<String> strs) {
        String res = "";

        for(String str : strs){
            res = res + str.length() + "%" + str;
        }

        return res;
    }

    public List<String> decode(String str) {
        List<String> arr = new ArrayList<>();
        int ptr = 0;

        while(ptr<str.length()){
            int delimeterIdx = str.indexOf("%", ptr);
            int len = Integer.parseInt(str.substring(ptr, delimeterIdx));
            String res = str.substring(delimeterIdx + 1, delimeterIdx + 1 + len);
            ptr = delimeterIdx + 1 + len;
            arr.add(res);
        }
        return arr;
    }
}
