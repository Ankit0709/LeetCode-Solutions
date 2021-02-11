// /RemoveAdjacentDuplicates
//Problem LInk : https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
class RemoveAdjacentDuplicates {
    public String removeDuplicates(String s) {
        Stack<Character> stack=new Stack<>();
        int len=s.length();
        for(int i=0;i<len;i++){
            boolean flag=false;
            while(!stack.isEmpty()&&stack.peek()==s.charAt(i)){
                stack.pop();
                flag=true;
            }
            if(!flag){
                stack.push(s.charAt(i));
            }
        }
        StringBuilder ans=new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}