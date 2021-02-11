//RemoveAllAdjacentsInString2
//Problem Link : https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
class RemoveAllAdjacentsInString2 {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character,Integer>> stack=new Stack<>();
        int len=s.length();       
        for(int i=0;i<len;i++){
        	char ch=s.charAt(i);
        	if(stack.isEmpty()){
        		stack.push(new Pair(s.charAt(i),1));
        	}
        	else{
        		if(ch==stack.peek().getKey()){
	        		stack.push(new Pair(s.charAt(i),stack.peek().getValue()+1));
	        		if(stack.peek().getValue()==k){
	        			//repeatedely pop from stack
	        			char x=stack.peek().getKey();
	        			while(!stack.isEmpty()&&x==stack.peek().getKey()){
	        				stack.pop();
	        			}
	        		}
	        	}
	        	else{
	        		stack.push(new Pair(s.charAt(i),1));
	        	}

        	} 	
        		
        }
        StringBuilder result=new StringBuilder();
        while(!stack.isEmpty()){
        	result.append(stack.pop().getKey());
        }
        return result.reverse().toString();
    }
}
