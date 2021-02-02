// /PermutationSeq
//Problem Link : https://leetcode.com/problems/palindrome-partitioning/
class Solution {
	Set<Integer> set=new TreeSet<>();
	public void swap(char[] ch,int i,int j){
		char tmp=ch[i];
		ch[i]=ch[j];
		ch[j]=tmp;
	}
	public void permutations(char[] ch,int l,int r){
		if(l>=r){
			set.add(new String(ch));
			return;
		}
		for(int i=l;i<r;i++){
			swap(ch,i,l);
			permutations(ch,i+1,r);
			swap(ch,i,l);
		}
	}
    public String getPermutation(int n, int k) {
        String x="";
        for(int i=1;i<=n;i++){
        	x+=i;
        }
        permutations(x.toCharArray(),n);
    }
}