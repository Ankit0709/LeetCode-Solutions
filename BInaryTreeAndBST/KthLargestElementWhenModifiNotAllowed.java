// /KthLargestElementWhenModifiNotAllowed
//Problem Link : https://www.geeksforgeeks.org/kth-largest-element-in-bst-when-modification-to-bst-is-not-allowed/
class KthLargestElementWhenModifiNotAllowed{
	//1.Approach using Morris Traversal for Reverse Inorder 
	public int kthLargestInBST(Node root,int k){
		if(root==null){
			return -1;
		}
		int cnt=0;
		int kthLargest=-1;
		while(root!=null){
			if(root.right==null){
				cnt++;
				if(cnt==k){
					kthLargest=root;
				}
				root=root.left;
			}
			else{
				Node succ=root.right;
				while(succ.left!=null&&succ.left!=root){
					succ=succ.left;
				}
				if(succ.left==null){
					succ.left=root;
					root=root.right;
				}
				else{
					succ.left=null;
					cnt++;
					if(cnt==k){
						kthLargest=root;
					}
					root=root.left;
				}
			}
		}
		return kthLargest;
	}

	//2.Argumented Approach
	//We need to maintain how many nodes are there in right subtree
	public int kthLargestInBSTArg(Node root,int k){
		if(root==null){
			return -1;
		}		
		while(root!=null){
			if(root.rightNodes+1==k){
				return root.val;
			}
			else if(root.rightNodes+1<k){
				k-=root.rightNodes+1;
				root=root.left;
			}
			else{
				root=root.right;
			}
		}
		return -1;
	}


	//3.When Modification Not allowed 
	// Do reverse Inorder traversal of bst and inc count when count ==k print data
	int cnt=0;
	int kthLargest=-1;
	public void kthLargestInNoMod(Node root,int k){
		if(root==null||count>k){
			return;
		}
		kthLargestInNoMod(root.right,k);
		cnt++;
		if(cnt==k){
			kthLargest=root.val;
			return;
		}
		kthLargestInNoMod(root.left,k);
	}


}