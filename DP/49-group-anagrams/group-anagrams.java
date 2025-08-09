class Solution {
    public List<List<String>> groupAnagrams(String[] str) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0;i<str.length;i++){
            char[] ch = str[i].toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(str[i]);
        }
        return new ArrayList<>(map.values());
    }
}