// /ImplementQueueUsingStacks
//Problem LInk : https://leetcode.com/problems/implement-queue-using-stacks/
class MyQueue {
    Stack<Integer> s1,s2;
    int top;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
        top=-1;
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(s1.isEmpty()){
        	top=x;
        }
        s1.push(x);       

    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(s1.size()>1){
        	s2.push(s1.pop());
        }
        int data=s1.pop();
        if(!s2.isEmpty()){
        	top=s2.peek();
        }
        while(!s2.isEmpty()){
        	s1.push(s2.pop());
        }
        return data;
    }
    
    /** Get the front element. */
    public int peek() {
        return top;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.size()==0;
    }
}



//Amortized Pop operation O(1) and Push operation O(1)
class MyQueue {
    Stack<Integer> s1,s2;
    int front;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
        top=-1;
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(s1.isEmpty()){
        	front=x;
        }
        s1.push(x);       

    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s2.isEmpty()){
        	while(!s1.isEmpty()){
        		s2.push(s1.pop());
        	}
        }
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(!s2.isEmpty()){
        	return s2.peek();
        }
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.size()==0&&s2.size()==0;
    }
}



