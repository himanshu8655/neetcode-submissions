class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder("");

        for(String str : strs){
            res.append(str.length()).append("%").append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        int left = 0;
        List<String> res = new ArrayList<>();
        while(left<str.length()){
            int delimeteIdx = str.indexOf("%", left);
            int strLen = Integer.parseInt(str.substring(left, delimeteIdx));
            String decodedString = str.substring(delimeteIdx + 1, delimeteIdx + strLen + 1);
            left = delimeteIdx + strLen + 1;
            res.add(decodedString);
        }
    return res;
    }
}
