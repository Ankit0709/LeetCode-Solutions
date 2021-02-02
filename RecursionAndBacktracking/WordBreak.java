//WordBreak
//Problem link : https://leetcode.com/problems/word-break/
class WordBreak {
	 int[] dp;
    HashSet<String> words=new HashSet<>();
	public boolean wordBreakUtil(String str,int indx,HashSet<String> wordDict){
		// base case 
		if(indx==str.length()){			 
			 return true;
		}
        if(dp[indx]!=-1){
            return dp[indx]==1;
        }
		for(int i=indx+1;i<=str.length();i++){
			String word=str.substring(indx,i);
			//if that word is present in dict we will check for other words
			if(wordDict.contains(word)&& wordBreakUtil(str,i,wordDict)){
				dp[indx]=1;
                return true;
			}
		}
        dp[indx]=0;
		return false;
	}
    public boolean wordBreak(String s, List<String> wordDict) {
         for(String x:wordDict){
         	words.add(x);
         }
        dp=new int[s.length()+1];
        Arrays.fill(dp,-1);      
        
        return wordBreakUtil(s,0,words);
    }
}