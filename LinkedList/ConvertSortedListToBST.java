//ConvertSortedListToBST
//Problem LInk :https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
class ConvertSortedListToBST {
    public ListNode midPoint(ListNode head){
    	ListNode slow=head,fast=head,prev=head;
    	while(fast!=null&&fast.next!=null){
    		prev=slow;
    		slow=slow.next;
    		fast=fast.next.next;
    	}
    	prev.next=null;
    	return slow;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
        	return null;
        }
        if(head.next==null){
        	TreeNode root=new TreeNode(head.val);
        	return root;
        }
        ListNode mid=midPoint(head);
        ListNode A=head;
        ListNode B=mid.next;
        mid.next=null;
        TreeNode root=new TreeNode(mid.val);
        root.left=sortedListToBST(A);
        root.right=sortedListToBST(B);
        return root;        
    }
}