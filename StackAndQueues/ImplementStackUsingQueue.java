//ImplementStackUsingQueue
//Problem Link : https://leetcode.com/problems/implement-stack-using-queues/

///Making Push O(1) ANd POp O(n)
class MyStack {
 Queue<Integer> queue1,queue2;
    int top;
	
    /** Initialize your data structure here. */
    public MyStack() {
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();
        top=-1;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
        top=x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(queue1.size()>1){
            int data=queue1.poll();
        	queue2.add(data);
            top=data;
        }
        int data=queue1.poll();
       	Queue<Integer> temp=queue1;
        queue1=queue2;
        queue2=temp;
        return data;
    }
    
    /** Get the top element. */
    public int top() {
      return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.size()==0;
    }
}


///Making Push O(n) ANd POp O(1)
class MyStack {
   Queue<Integer> queue1,queue2;
    int top;
	
    /** Initialize your data structure here. */
    public MyStack() {
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();
        top=-1;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
       queue2.add(x);
       top=x;
       while(!queue1.isEmpty()){
       	  queue2.add(queue1.poll());
       }
       Queue<Integer> temp=queue1;
       queue1=queue2;
       queue2=temp;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       int data=queue1.poll();
       if(queue1.isEmpty()){
       		top=queue1.peek();
       }
       return data;
    }
    
    /** Get the top element. */
    public int top() {
      return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.size()==0;
    }
}

//Using One Queue

class MyStack {
   Queue<Integer> queue1;
    int top;
	
    /** Initialize your data structure here. */
    public MyStack() {
        queue1=new LinkedList<>();        
        top=-1;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
      queue1.add(x);
      int size=queue1.size();
      while(size>1){
      	queue1.add(queue1.poll());
      }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
      return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.size()==0;
    }
}