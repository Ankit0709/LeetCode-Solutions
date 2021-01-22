//ReverseLL
//Problem Link :https://leetcode.com/problems/reverse-linked-list/
class Solution {
	public ListNode reverseListRec(ListNode head){
		if(head==null||head.next==null){
			return head;
		}
		ListNode newHead=reverseListRec(head.next);
		ListNode curr=head;
		curr.next.next=curr;
		curr.next=null;
		return newHead;
	}
    public ListNode reverseList(ListNode head) {
        ListNode curr=head,prev=null,next=null;
        while(curr!=null){
        	next=curr.next;
        	curr.next=prev;
        	prev=curr;
        	curr=next;
        }
        return prev;
    }
    public ListNode reverseListTwoPointer(ListNode head){
    	if(head==null||head.next==null){
            return head;
        }
    	ListNode curr=head,next=null;
    	while(curr.next!=null){
    		next=curr.next;
    		curr.next=next.next;
    		next.next=head;
    		head=next;
    	}
    	return head;
    }
}