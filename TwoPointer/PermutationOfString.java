//PermutationOfString
//Problem LInk:https://leetcode.com/problems/permutation-in-string/
class Solution {
	 public boolean checkInclusionSliding(String s1, String s2) {
	 	int n=s1.length();
        int m=s2.length();
        int[] freq1=new int[26];    
        int[] freq2=new int[26];    
        for(int i=0;i<n;i++){
        	freq1[s1.charAt(i)-'a']++;
        }
        int j=0,start=0;
        while(j<Math.min(n,m)){
        	freq2[s2.charAt(j)-'a']++;
        	j++;
        }
        if(Arrays.equals(freq1,freq2)){
        	return true;
        }
        while(j<m){
        	freq2[s2.charAt(start)-'a']--;
        	start++;
        	freq2[s2.charAt(j)-'a']++;
        	j++;
        	if(Arrays.equals(freq1,freq2)){
        		return true;
        	}
        }
        return false;

	 }
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int[] freq1=new int[26];        
        for(int i=0;i<n;i++){
        	freq1[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<n-m;i++){
        	String x=s1.substring(i,i+m);
        	int[] freq2=new int[26];
        	for(int j=0;j<x.length();j++){
        		freq2[s2.charAt(i)-'a']++;
        	}
        	if(Arrays.equals(freq1,freq2)){
        		return true;
        	}
        }
        return false;
        
    }
}