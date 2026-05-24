class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for(String str : strs){
            result.append(str.length()+"%"+str);
        }
        System.out.println(result);
        return new String(result);
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i<str.length(); i++){
            int idx = str.indexOf("%",i);
            int len = Integer.parseInt(str.substring(i, idx));
            int endIndex = idx + len + 1;
            String extractedString = str.substring(idx+1, endIndex);
            result.add(extractedString);
            i = endIndex - 1;
        }

        return result;
    }
}
