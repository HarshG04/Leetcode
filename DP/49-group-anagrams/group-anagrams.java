class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String s = strs[i];
            int[] freq = new int[26];
            for(int j=0;j<s.length();j++) freq[s.charAt(j)-97]++;
            StringBuilder sb = new StringBuilder(Arrays.toString(freq));
            String key = sb.toString();
            System.out.println(s+" "+key);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}