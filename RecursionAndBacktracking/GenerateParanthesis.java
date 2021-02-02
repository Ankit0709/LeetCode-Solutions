//GenerateParanthesis
//Problen Link : https://leetcode.com/problems/generate-parentheses/
class GenerateParanthesis {
	 List<String> ans=new ArrayList<>();
	public void generateParanthesisUtil(int n,String str,int open,int close){
		if(str.length()==2*n){
			ans.add(str);
			return;
		}
		if(open<n){
			generateParanthesisUtil(n,str+'(',open+1,close);
		}
		if(close<open){
			generateParanthesisUtil(n,str+')',open,close+1);		
		}
	}
    public List<String> generateParenthesis(int n) {
    	generateParanthesisUtil(n,"",0,0);
        return ans;
    }
}