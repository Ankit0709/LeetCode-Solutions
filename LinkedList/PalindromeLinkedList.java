//PalindromeLinkedList
////Problem Link :https://leetcode.com/problems/palindrome-linked-list/
class PalindromeLinkedList {
	 public ListNode reverse(ListNode head){
		if(head==null||head.next==null){
			return head;
		}
		ListNode newHead=reverse(head.next);
		head.next.next=head;
		head.next=null;
		return newHead;
	}
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
        	return true;
        }
        ListNode curr=head;
        ListNode slow=head,fast=head.next;
        while(fast!=null&&fast.next!=null){
        	slow=slow.next;
        	fast=fast.next.next;
        }       
        ListNode newHead=slow.next;
        slow.next=null;       
        newHead=reverse(newHead);
        while(head!=null&&newHead!=null){
        	if(head.val!=newHead.val){
        		return false;
        	}
        	head=head.next;
        	newHead=newHead.next;
        }
        return true;
    }
}