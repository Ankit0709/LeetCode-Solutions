// /DecodeString
//Problem Link : https://leetcode.com/problems/decode-string/
class DecodeString {
	//Using 2 Stacks 
     public String decodeString(String s) {
        Stack<Integer> counts=new Stack<>();
        Stack<String> result=new Stack<>();
        String res="";
        int num=0;
        int len=s.length();
        int i=0;

        while(i<len){
        	if(Character.isDigit(s.charAt(i))){
        		int number=0;
        		while(Character.isDigit(s.charAt(i))){
        			number=number*10+(s.charAt(i)-'0');
        			i++;
        		}
        		num=number;
        	}
        	else if(s.charAt(i)=='['){
        		counts.push(num);
        		result.push(res);
        		res="";
        		num=0;   
        		i++;     		
        	}
        	else if(s.charAt(i)==']'){
        		StringBuilder temp=new StringBuilder(result.pop());
        		int cnt=counts.pop();
        		for(int j=0;j<cnt;j++){
        			temp.append(res);
        		}
        		res=temp.toString();
        		i++;
        	}
        	else{
        		res+=s.charAt(i);
        		i++;
        	}
        }
        return res;

    }

    //USing One Stack
    public String decodeStringOnStack(String s) {
    	Stack<Pair<Integer,String>> stack=new Stack<>();
    	int len=s.length();
    	String res="";
    	int num=0;
    	for(int i=0;i<len;i++){
    		if(Character.isDigit(s.charAt(i))){
    			num=num*10+(s.charAt(i)-'0');
    		}
    		else if(s.charAt(i)=='['){
    			stack.add(new Pair(num,res));
    			res="";
    			num=0;
    		}
    		else if(s.charAt(i)==']'){
    			Pair<Integer,String> rp=stack.pop();
    			int times=rp.getKey();
    			StringBuilder tmp=new StringBuilder();
    			tmp.append(rp.getValue());
    			for(int j=0;j<times;j++){
    				tmp.append(res);
    			}
    			res=tmp.toString();
    		}
    		else{
    			res+=s.charAt(i);
    		}
    	}
    	return res;
    }
}