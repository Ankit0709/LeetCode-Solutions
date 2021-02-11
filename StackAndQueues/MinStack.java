// /MinStack
//Problem Link : https://leetcode.com/problems/min-stack/
class MinStack {
	Stack minStack;
	int minEle;
    /** initialize your data structure here. */
    public MinStack() {
        minStack=new Stack<>();
        minEle=Integer.MAX_VALUE;
    }
    
    public void push(int x) {
       if(minStack.isEmpty()){
       	  minStack.push(x);
       }  
       else{
       	 if(x<minEle){
       	 	minStack.push(2*x-minEle);
       	 	minEle=x;
       	 }
       	 else{
       	 	minStack.push(x);
       	 }
       }    
    }
    
    public void pop() {
        int x=minStack.pop();
        //restore back my previous min
        if(x<minEle){
        	int min=minEle;
        	minEle=2*minEle-x;
        	return min;
        }
        else{
        	return x;
        }
    }
    
    public int top() {
    	int x=minStack.peek();
        if(x<minEle){        		
        	return minEle;
        }
        else{
        	return x;
        }
    }
    
    public int getMin() {
        return minEle;
    }
}


class MinStack {
	Stack<int[]> minStack;
	int minEle;
    /** initialize your data structure here. */
    public MinStack() {
        minStack=new Stack<>();        
    }
    
    public void push(int x) {
       if(minStack.isEmpty()){
       	  minStack.push(new int[]{x,x});
       }  
       else{
       	   int curr_min=minStack.peek()[1];
           minStack.push(new int[]{x,Math.min(curr_min,x)});
       }    
    }
    
    public void pop() {
        minStack.pop();      
    }
    
    public int top() {
    	return minStack.peek()[0];
    }
    
    public int getMin() {
       return minStack.peek()[1];
    }
}