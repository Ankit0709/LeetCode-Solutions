//CopyListWithRandomPointer
//Problem Link : https://leetcode.com/problems/copy-list-with-random-pointer/
class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Node newHead=null;
        if(head==null){
        	return null;
        }
        Node ptr=head;
        while(ptr!=null){
        	Node node = new Node(ptr.val);
        	node.next=ptr.next;
        	ptr.next=node;
        	ptr=ptr.next.next;
        }
        ptr=head;
        while(ptr!=null&&ptr.next!=null){
            if(ptr.random!=null){
                ptr.next.random=ptr.random.next;
            }
            else{
                ptr.next.random=null;
            }        	
        	ptr=ptr.next.next;
        }
        ptr=head;
        Node ptr2=ptr.next;
        newHead=ptr.next;
        while(ptr!=null){
        	Node next=ptr.next.next;
            if(next!=null){
                ptr2.next=next.next;
            }
            else{
                ptr2.next=null;
            }        	
        	ptr.next=next;
        	ptr=ptr.next;
        	ptr2=ptr2.next;
        }
        return newHead;
    }
}