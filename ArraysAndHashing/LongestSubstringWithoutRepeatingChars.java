//LongestSubstringWithoutRepeatingChars
//Problem LInk :https://leetcode.com/problems/longest-substring-without-repeating-characters/ 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len=s.length();
        if(len==0||len==1){
        	return len;
        }
        int[] next_index=new int[128];
        int start=0,end=0;
        int max_len=0;
        while(end<len){
        	start=Math.max(start,next_index[s.charAt(end)]);
        	next_index[s.charAt(end)]=end+1;
        	max_len=Math.max(max_len,end-start+1);
        	end++;
        }
        return max_len;
    }
}