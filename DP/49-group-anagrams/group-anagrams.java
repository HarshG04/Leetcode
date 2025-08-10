class Solution {
    public List<List<String>> groupAnagrams(String[] str) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(int i=0;i<str.length;i++){
            String key = makeKey(str[i]);
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(str[i]);
        }
        return new ArrayList<>(map.values());
    }
    public String makeKey(String s){
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-97]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++) {
            sb.append(freq[i]).append('$');
        }
        return sb.toString();
    }
}