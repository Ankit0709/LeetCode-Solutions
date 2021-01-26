// /RemoveDuplicates2
//Problem Link : https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
class RemoveDuplicates2 {
     public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
        	return head;
        }
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        ListNode ptr=head;
        dummy.next=head;
        while(ptr!=null&&ptr.next!=null){
            while(ptr.next!=null&&curr.next.val==ptr.next.val){
                ptr=ptr.next;
            }
            if(curr.next==ptr){
                curr=curr.next;
            }
            else{
                curr.next=ptr.next;
            }
        }
        return dummy.next;

    }
}