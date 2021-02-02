//WordBreak2
//Problem Link : https://leetcode.com/problems/word-break-ii/
class Solution {
	List<String> ans=new ArrayList<>();
	HashSet<String> dict=new HashSet<>();
	public void wordBreakUtil(String s,int n,int pos,String x){
		//base case
		if(pos==n+1){
			ans.add(x);
			return;
		}
		for(int i=pos+1;i<=n;i++){
			String sub=s.substring(pos,i+1);
			if(dict.contains(sub)){
				//break point
				wordBreakUtil(s,n,i+1,x+sub+" ");
			}
		}
		return;
	}
    public List<String> wordBreak(String s, List<String> wordDict) {
        int len=s.length();
        if(len==0){
        	return ans;
        }
        for(String x:wordDict){
        	dict.add(x);
        }
        wordBreakUtil(s,len,0,"");
        return ans;
    }
}