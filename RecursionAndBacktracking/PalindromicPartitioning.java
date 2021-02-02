//PalindromicPartitioning
//Problem Link : https://leetcode.com/problems/palindrome-partitioning/
class Solution {
	 List<List<String>> ans=new ArrayList<>();

	public boolean isPalindrome(String s){
		int i=0,j=s.length()-1;
		while(i<j){
			if(s.charAt(i)!=s.charAt(j)){
				return false;
			}
            i++;
            j--;
		}
		return true;
	}
	public void palindromicPartitionDpOptimised(String s,int indx,int len,ArrayList<String> x){
		if(indx>=len){
			ans.add((ArrayList<String>)x.clone());
			return;
		}
		for(int i=indx;i<len;i++){
			String l=s.substring(indx,i+1);
			if((s.charAt(indx)==s.charAt(i))&&(i-indx<=2||dp[indx+1][i-1])){
                dp[indx][i]=true;
				x.add(l);
				palindromicPartitionDpOptimised(s,i+1,len,x);
                x.remove(x.size()-1);
			}
		}
	}
	public void palindromicPartition(String s,int indx,int len,ArrayList<String> x){
		if(indx==len){
			ans.add((ArrayList<String>)x.clone());
			return;
		}
		for(int i=indx;i<len;i++){
			String l=s.substring(indx,i+1);
			if(isPalindrome(l)){
				x.add(l);
				palindromicPartition(s,i+1,len,x);
                x.remove(x.size()-1);
			}
		}
	}
    public List<List<String>> partition(String s) {
        palindromicPartition(s,0,s.length(),new ArrayList<String>());
        return ans;
    }
}