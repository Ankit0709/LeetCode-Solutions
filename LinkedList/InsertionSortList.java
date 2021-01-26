//InsertionSortList
//Problem Link: https://leetcode.com/problems/insertion-sort-list/
class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null){
        	return head;
        }
        ListNode newHead=head;
        ListNode ptr=head.next;
        head.next=null;
        while(ptr!=null){
        	ListNode temp=newHead,prev=null,next=ptr.next;        	
        	while(temp!=null&&temp.val<ptr.val){
        		prev=temp;
        		temp=temp.next;
        	}
        	if(prev==null){
        		ptr.next=newHead;      
        		newHead=ptr;
        		  		
        	}        	
        	else{
        		ptr.next=prev.next;
        		prev.next=ptr;
        	}
        	ptr=next;
        }
        return newHead;
    }
}