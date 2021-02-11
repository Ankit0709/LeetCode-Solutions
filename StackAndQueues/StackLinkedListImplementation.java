// /StackLinkedListImplementation
// https://www.geeksforgeeks.org/stack-data-structure-introduction-program/

class Stack{
	Node top;
	int size=0;
	Stack(){
		top=null;
	}
	//PUsh --> O(1)
	public void push(int ele){
		Node node=new Node(ele);
		node.next=top;
		top=node;
		size++;
	}
	//Pop --> O(1)
	public int pop(){
		int data=-1;
		try{
			if(top==null){
			throw new Exception("Stack Underflow!");
			}
			data=top.data;
			top=top.next;
			size--;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}		
		return data;
	}
	//Size  --> O(1)
	public int size(){
		return size;
	}
	//Peek--> O(1)
	public int peek(){
		int data=-1;
		try{
			if(top==null){
				throw new Exception("Stack Underflow!");
			}
		 	data=top.data;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}		
		return data;
	}
	//O(n)
	public void display(){
		Node tmp=top;
		while(tmp!=null){
			System.out.print(tmp.data+" ");
			tmp=tmp.next;
		}
	}
	//Empty>> O(1)
	public boolean isEmpty(){
		return top==null;
	}
	static class Node{
		int data;
		Node next;
		Node(int x){
			data=x;
			next=null;
		}
	}
}
public class StackLinkedListImplementation{
	public static void main(String[] args) {
		Stack stack=new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.display();
		System.out.println();
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}
}