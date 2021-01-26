//ConvertBSTToSortedLL
//Problem LInk : https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
class ConvertBSTToSortedLL{
	ListNode head=null,curr=null;
	public void inorder(TreeNode root){
		if(root==null){
			return ;
		}
		inorder(root.left);
		ListNode node=new ListNode(root.val);
		if(head==null){
			head=node;
			curr=head;
		}
		else{
			curr.next=node;
			curr=curr.next;
		}
		inorder(root.right);
	}
	public ListNode convertBSTToLL(TreeNode root){
		if(root==null){
			return null;
		}
		inorder(root);
		return head;

	}
}