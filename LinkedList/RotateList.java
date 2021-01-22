//RotateList
//Problem Link :https://leetcode.com/problems/rotate-list/
class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0){
        	return head;
        }         
        ListNode slow=head,fast=head,ptr=head,prev=null;
        int len=0;

        while(ptr!=null){
        	len++;
        	ptr=ptr.next;
        }
        k%=len;
        if(k==0){
            return head;
        }
        while(fast!=null&&k--!=0){
        	fast=fast.next;
        }
        while(fast!=null){
        	prev=slow;
        	fast=fast.next;
        	slow=slow.next;
        }
        prev.next=null;
        ListNode newHead=slow;
        while(slow!=null&&slow.next!=null){
        	slow=slow.next;
        }
        slow.next=head;
        return newHead;

    }
}