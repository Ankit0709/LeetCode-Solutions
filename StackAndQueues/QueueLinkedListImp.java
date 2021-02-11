//QueueLinkedListImp
//https://www.geeksforgeeks.org/queue-set-1introduction-and-array-implementation/
class Queue{
	Node front,rear;
	int size;
	Queue(){
		front=null;
		rear=null;
		size=0;
	}
	//Add At Front --> O(1)
	public void add(int ele){
		Node node=new Node(ele);
		if(rear!=null){
			rear.next=node;
			rear=node;
		}
		else{
			rear=node;
			front=rear;
		}		
		
		size++;	
	}
	//Delete From End --> O(1)
	public int delete(){
		int data=-1;
		try{
			if(front==null){
				throw new Exception("Stack Underflow!");
			}

			data=front.data;
			if(front==rear){
				front=null;
				rear=null;
				size=0;
			}
			else{
				front=front.next;
				size--;
			}		
		}
		catch(Exception ex){
			ex.printStackTrace();
		}	
		return data;
	}
	//Get Front Element--> O(1)
	public int peek(){
		int data=-1;
		try{
			if(front==null){
				throw new Exception("Stack Underflow!");
			}
			data=front.data;	
		}
		catch(Exception ex){
			ex.printStackTrace();
		}			
		return data;		
	}
	//Check Queue is Empty or Not --> O(1)
	public boolean isEmpty(){
		return rear==null;
	}
	//Get Queue Size  -> O(1)
	public int size(){
		return size;
	}
	//Display Queue Elements--> O(n)
	public void display(){
		Node tmp=front;
		while(tmp!=null){
			System.out.print(tmp.data+" ");
			tmp=tmp.next;
		}
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
public class QueueLinkedListImp{
	public static void main(String[] args) {
		Queue queue=new Queue();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.display();
		System.out.println();
		System.out.println(queue.delete());
		System.out.println(queue.isEmpty());
		System.out.println(queue.size());
		queue.display();
	}
}
