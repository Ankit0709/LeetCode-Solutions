// /StackImplementation
//Problem Link : https://www.geeksforgeeks.org/stack-data-structure-introduction-program/
class Stack{
	int[] stack;
	int size;
	int top;
	Stack(int size){
		stack=new int[size];
		this.size=size;
		top=-1;
	}
	public boolean isEmpty(){
		return top==-1;
	}
	public void push(int ele){
		if(top==size-1){
			System.out.println("Stack Overflow!");
			return ;
		}
		stack[++top]=ele;

	}
	public int pop(){
		if(top==-1){
			System.out.println("Stack Underflow");
			return -1;
		}
		int ele=stack[top];
		top--;
		return ele;
	}
	public int peek(){
		if(top==-1){
			System.out.println("Stack Underflow");
			return -1;
		}
		else{
			return stack[top];
		}
	}
	public int size(){
		return top+1;
	}
	public void display(){
		for(int i=0;i<=top;i++){
			System.out.print(stack[i]+" ");
		}
	}
}
class StackImplementation{
	public static void main(String[] args) {
		Stack stack=new Stack(100);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.display();
		System.out.println();
		System.out.println("Top Element   "+stack.peek());
		stack.display();
	}
	
}
