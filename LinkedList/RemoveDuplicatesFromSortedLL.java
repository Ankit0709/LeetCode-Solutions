//RemoveDuplicatesFromSortedLL
//Problem LInk : https://leetcode.com/problems/remove-duplicates-from-sorted-list/
class RemoveDuplicatesFromSortedLL {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
        	return head;
        }
        ListNode ptr=head;
        while(ptr!=null&&ptr.next!=null){
        	if(ptr.val==ptr.next.val){
        		ptr.next=ptr.next.next;
        	}
        	else{
        		ptr=ptr.next;
        	}
        }
        return head;
    }
}