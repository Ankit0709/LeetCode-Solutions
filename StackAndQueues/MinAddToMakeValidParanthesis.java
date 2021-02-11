// /MinAddToMakeValidParanthesis
//Problem Link : https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
class MinAddToMakeValidParanthesis {
	//T(n)-O(n) S(n)-O(n)
	public int minAddToMakeValidStack(String S){
		Stack<Character> stack=new Stack<>();
		int ans=0;
		int len=S.length();
		for(int i=0;i<len;i++){
			if(S.charAt(i)=='('){
				stack.add('(');
			}
			else{
				if(stack.isEmpty()){
					ans++;
				}
				else{
					stack.pop();
				}
			}
		}   
		ans+=stack.size();
		return ans;
	}
	//Optimised Solution T(n)-O(n) S(n)-O(1)
   public int minAddToMakeValid(String S) {
        int cnt=0;
        int ans=0;
        int len=S.length();
        for(int i=0;i<len;i++){
            if(S.charAt(i)=='('){
                cnt++;
            }
            else{
                if(cnt==0){
                    ans++;                    
                }
                else
                    cnt--;
            }
        }
        if(cnt>0){
            ans+=cnt;
        }
        return ans;
    }
}