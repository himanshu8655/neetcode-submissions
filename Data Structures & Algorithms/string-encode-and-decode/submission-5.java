class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for(String word : strs){
            str.append(word.length() + "%" + word);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int ptr = 0;

        while(ptr<str.length()){
            int delimeterIndex = str.indexOf("%", ptr);
            int strLen = Integer.parseInt(str.substring(ptr, delimeterIndex));
            String word = str.substring(delimeterIndex+1, delimeterIndex + 1 +strLen);
            ptr = delimeterIndex + 1 +strLen;
            res.add(word);
        }
        return res;
    }
}
