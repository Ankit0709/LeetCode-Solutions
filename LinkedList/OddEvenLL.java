//OddEvenLL
//Problem Link :https://leetcode.com/problems/odd-even-linked-list/
class OddEvenLL {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd=null,even=null,oddHead=null,evenHead=null;
        if(head==null||head.next==null){
        	return head;
        }
        ListNode ptr=head;
        while(ptr!=null){
        	if((ptr.val&1)==1){
        		if(oddHead==null){
        			oddHead=ptr;
        			odd=ptr;
        		}else{
        			odd.next=ptr;
        			odd=odd.next;
        		}
        	}
        	else{
        		if(evenHead==null){
        			evenHead=ptr;
        			even=ptr;
        		}
        		else{
        			even.next=ptr;
        			even=even.next;
        		}        		
        	}
        	ptr=ptr.next;
        }
        odd.next=evenHead;
        return oddHead;
    }
}
