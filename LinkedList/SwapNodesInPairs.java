// /SwapNodesInPairs
//Problem LInk : https://leetcode.com/problems/swap-nodes-in-pairs/
class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
        	return head;
        }
        ListNode next=head.next;
        head.next=next.next;
        next.next=head;
        head.next=swapPairs(head.next.next);
        return next;
    }
    public ListNode  swapPairsIter(ListNode head){
    	if(head==null||head.next==null){
    		return head;
    	}
    	ListNode prev=head,curr=head.next;
    	head=curr;
    	while(curr!=null){
    		ListNode next=curr.next;
    		if(next==null||next.next==null){
    			prev.next=next;
    			break;
    		}
    		prev.next=next.next;
    		curr.next=prev;
    		prev=next;
    		curr=prev.next;
    	}
    	return head;
    }
}