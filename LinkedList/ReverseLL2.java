//ReverseLL2
//Problem Link : https://leetcode.com/problems/reverse-linked-list-ii/
class Solution {
	public ListNode reverse(ListNode head){
		if(head==null||head.next==null){
			return head;
		}
		ListNode newHead=reverse(head.next);
		ListNode curr=head;
		curr.next.next=head;
		curr.next=null;
		return newHead;
	}
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pos1=head,pos2=head,prev=null;
        if(head==null||head.next==null){
        	return head;
        }
        while(m>1||n>1){
        	if(m>1){
        		prev=pos1;
        		pos1=pos1.next;
        		m--;
        	}
        	if(n>1){
        		pos2=pos2.next;
        		n--;
        	}
        }
        ListNode curr=pos2.next;
        pos2.next=null;
        ListNode newHead=reverse(pos1);
        if(prev!=null){
        	prev.next=newHead;        	
        }
        else{
        	head=newHead;
        }
        pos1.next=curr;
        return head;
    }
}