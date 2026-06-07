class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for(String str : strs){
            builder.append(str.length()).append("&").append(str);
        }
    return builder.toString();
    }

    public List<String> decode(String s) {
        int ptr = 0;
        List<String> list = new ArrayList<>();
        while(ptr<s.length()){
            int delimeterIndex = s.indexOf("&",ptr);
            int n = Integer.parseInt(s.substring(ptr, delimeterIndex));
            list.add(s.substring(delimeterIndex+1, delimeterIndex+1+n));
            ptr+=delimeterIndex+1+n;
        }

        return list;
    }
}
