// /InorderPredecessorAndSuccessorInBSt
//Problem LInk : https://www.geeksforgeeks.org/inorder-predecessor-and-successor-for-a-given-key-in-bst-iterative-approach/
class InorderPredecessorAndSuccessorInBSt{
	//1.Find the inorder of bst and so its sorted in order so find indx by binary search
	// and return indx-1 as pre and ind+1 as succ
	ArrayList<Integer> list=new ArrayList<>();
	public void inorder(TreeNode root){
		if(root==null){return;}
		inorder(root.left);
		list.add(root.val);
		inorder(root.right);
	}
	public void inorderPreAndSucc(TreeNode root,int key){
		if(root==null){
			return;
		}
		inorder(root);
		int indx=Collections.binarySearch(list,key);
		int pre=indx>0?list.get(indx-1):-1;
		int succ=indx<list.size()-1?list.get(indx+1):-1;
		System.out.println(pre+" : "+succ);
	}


	//2 Itearative 
	public void inorderPreAndSucc(Node root,int key){
		Node pre=null,succ=null;
		while(root!=null){
			if(root.val==key){
				//find pre and succ of that key				
				if(root.left!=null){
					pre=root.right;
					while(pre!=null){
						pre=pre.right;
					}
					
				}
				if(root.right!=null){
					succ=root.right;
					while(succ!=null){
						succ=succ.left;
					}
				}	
			
			}
			else if(root.val<key){
				   pre=root;
				   root=root.right;
			}
			else{
				succ=root;
				root=root.left;
			}

		}
	}
}