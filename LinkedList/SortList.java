//SortList
//Problem Link : https://leetcode.com/problems/sort-list/
class SortList {
	 public ListNode midPoint(ListNode head){
		ListNode slow=head,fast=head.next;
		while(fast!=null&&fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
		}
		return slow;
	}
	public ListNode merge(ListNode A,ListNode B){
		if(A==null){
			return B;
		}
		if(B==null){
			return A;
		}
		if(A.val<B.val){
			A.next=merge(A.next,B);
			return A;
		}
		else{
			B.next=merge(A,B.next);
			return B;
		}
	}
	public ListNode mergeSort(ListNode head){
		if(head==null||head.next==null){
			return head;
		}
		ListNode mid=midPoint(head);
        ListNode A=head;
        ListNode B=mid.next;
        mid.next=null;
        A=mergeSort(A);
        B=mergeSort(B);
        A=merge(A,B);
        return A;
	}
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
        	return head;
        }
        return mergeSort(head);
	       
    }
}