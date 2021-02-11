// /QueueArrayImplementation
//LInk : https://www.geeksforgeeks.org/queue-set-1introduction-and-array-implementation/
class Queue{
	int[] arr;
	int size;
	int front,rear;
	Queue(int size){
		arr=new int[size];
		this.size=size;
		front=-1;
		rear=-1;
	}
	//O(1) Add at Rear --> Last 
	public void add(int ele){
		try{
			if(rear==size-1){
				throw new Exception("Stack Overflow!");
			}
			arr[++rear]=ele;
			if(front==-1){
				front=rear;
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	//O(1) Delete at front -> Beg
	public int delete(){
		int data=-1;
		try{
			if(front==-1){
				throw new Exception("Stack Underflow!");
			}
			data=arr[front];
			if(front==rear){
				front=rear=-1;
			}
			else
			front++;			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return data;		
	}
	//O(1)--> Peek -> Element at front
	public int peek(){
		int data=-1;
		try{
			if(front==-1){
				throw new Exception("Stack Underflow!");
			}
			data=arr[front];						
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return data;		
	}
	//O(1) --> Empty check
	public boolean isEmpty(){
		return rear==-1;
	}
	//O(1)--> Size of Queue
	public int size(){
		if(rear==-1){
			return 0;
		}
		return rear-front+1;
    }
	public void display(){
		for(int i=front;i<=rear;i++){
			System.out.print(arr[i]+" ");
		}
	}

}
class QueueArrayImplementation{
	public static void main(String[] args) {
		Queue queue=new Queue(1000);
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		System.out.println(queue.isEmpty());
		System.out.println(queue.size());
		queue.display();
		System.out.println();
		System.out.println(queue.delete());
		System.out.println(queue.size());
		queue.display();

	}
}