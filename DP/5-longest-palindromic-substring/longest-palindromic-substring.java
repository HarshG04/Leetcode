class Solution {
    public String longestPalindrome(String str) {
        if(str=="") return str;
        int s=0, e=0;
        for(int i=0;i<str.length();i++){
            int odd = expand_around_center(str,i,i);
            int even = expand_around_center(str,i,i+1);
            int max = Math.max(odd,even);
            if(max>(e-s)){
                s = i-(max-1)/2;
                e = i+max/2;
            }
        }

        return str.substring(s,e+1);
    }
    public int expand_around_center(String s,int l,int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return (r-l-1);

    }
}