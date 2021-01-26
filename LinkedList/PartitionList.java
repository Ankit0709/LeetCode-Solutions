//PartitionList
//Problem Link : https://leetcode.com/problems/partition-list/
class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null){
        	return head;
        }
        ListNode before=new ListNode(-1);
        ListNode after=new ListNode(-1);
        ListNode ptr=head;
        ListNode ptr1=before,ptr2=after;
        while(ptr!=null){
        	ListNode next=ptr.next;
        	if(ptr.val<x){
        		ptr1.next=ptr;
        		ptr1=ptr1.next;
        		ptr1.next=null;
        	}
        	else{
        		ptr2.next=ptr;
        		ptr2=ptr2.next;
        		ptr2.next=null;
        	}
        	ptr=next;

        }
        ptr1.next=after.next;
        return before.next;
    }
}