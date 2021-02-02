//MinAddToMakeValidPara

//Problem LInk : https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
class MinAddToMakeValidPara {
    public int minAddToMakeValid(String S) {
        int cnt=0;
        int ans=0;
        for(int i=0;i<S.length();i++){
        	if(S.charAt(i)=='('){
        		cnt++;
        	}
        	else{
        		cnt--;
        	}
        	if(cnt<0){
        		ans++;
        		cnt=0;
        	}
        }
        ans+=cnt;
        return ans;
    }
}