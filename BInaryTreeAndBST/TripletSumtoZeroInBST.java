// /TripletSumtoZeroInBST{}
//Problem Link : https://www.geeksforgeeks.org/find-if-there-is-a-triplet-in-bst-that-adds-to-0/
class TripletSumtoZeroInBST{
	TreeNode head=null,tail=null;;
	public void convertToSortedLL(TreeNode root){
		if(root==null){
			return;
		}
		convertToSortedLL(root.left);
		root.left=tail;
		if(tail!=null){
			head=root;
		}
		else{
			tail.right=root;
		}
		tail=root;
		convertToSortedLL(root.right);
	}
	public boolean checkSum(TreeNode x,TreeNode y,int sum){
		while(x!=y){
			if(x.val+y.val==sum){
				return true;
			}
			else if(x.val+y.val<sum){
				x=x.right;
			}
			else{
				y=y.left;
			}
		}
	}
	public boolean tripletSum(TreeNode root){
		convertToSortedLL(root);
		TreeNode ptr=root;
		while(ptr.right!=tail&&ptr.val<0){
			if(checkSum(ptr.right,tail,(-1)*ptr.val)){				
				return true;
			}
			else{
				ptr=ptr.right;
			}
		}
		return false;
	}
}