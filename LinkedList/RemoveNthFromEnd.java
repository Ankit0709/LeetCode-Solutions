//RemoveNthFromEnd
//Problem Link : https://leetcode.com/problems/remove-nth-node-from-end-of-list/
class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       if(head==null){
        	return head;
        }
        ListNode slow=head,fast=head,prev=null;
        while(n>0){
        	fast=fast.next;
        	n--;
        }
        while(fast!=null){
            prev=slow;
        	slow=slow.next;
        	fast=fast.next;
        }
        if(prev==null){
            head=head.next;
        }
        else{
            prev.next=slow.next;
        }
        return head;
    
    }
}
