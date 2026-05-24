class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String str : strs){
            res.append(str.length()).append("%").append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int ptr = 0;
        while(ptr<str.length()-1){
            int delimeter_idx = str.indexOf("%", ptr);
            int len_word = Integer.parseInt(str.substring(ptr, delimeter_idx));
            String word = str.substring(delimeter_idx+1, delimeter_idx + 1 + len_word);
            ptr = delimeter_idx + 1 + len_word;
            result.add(word);
        }
        return result;
    }
}
