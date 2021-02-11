// /MinRemoveToMakeValidParan
//Problem Link : https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
class Solution {
     public String minRemoveToMakeValid(String s) {
        int len=s.length();
        StringBuilder ans=new StringBuilder();
        int brackets=0;
        for(char c:s.toCharArray()){        	
        	if(c=='('){
        		brackets++;        		
        	}
        	else if(c==')'){
        		if(brackets==0) continue;
                brackets--;
        	}        	
            ans.append(c);        	
       }
       StringBuilder result=new StringBuilder();        
        if(brackets==0){
        	return ans.toString();
        }
        else{           
        	for(int i=ans.length()-1;i>=0;i--){
                if(ans.charAt(i)=='(' && brackets>0){ brackets--;continue;}
        		result.append(ans.charAt(i));               
            }            
        	
        }
        return result.reverse().toString();
    }
}