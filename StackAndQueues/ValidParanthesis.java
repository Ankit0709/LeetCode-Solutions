// /ValidParanthesis
//Problem Link : https://leetcode.com/problems/valid-parentheses/

class Solution {
     public boolean isValid(String s) {
        int count=0;
      Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            switch(s.charAt(i)){
                case '(':
                case '{':
                case '[':stack.push(s.charAt(i));break;
                case ')':if(stack.isEmpty()||stack.peek()!='('){
                    return false;
                }
                stack.pop();
                    break;
                case '}':if(stack.isEmpty()||stack.peek()!='{'){
                    return false;
                }
                stack.pop();
                    break;
                case ']':if(stack.isEmpty()||stack.peek()!='['){
                    return false;
                }
                stack.pop();
                    break;
            }
        }
        return stack.isEmpty();
    }
}