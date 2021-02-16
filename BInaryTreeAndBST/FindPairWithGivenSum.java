// /FindPairWithGivenSum
//Problem LInk : https://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/
class FindPairWithGivenSum{
	public void findPair(TreeNode root,int sum){
		Stack<TreeNode> stack1=new Stack<>();
		Stack<TreeNode> stack2=new Stack<>();
		boolean flag1=false,flag2=false;
		TreeNode curr1=root,curr2=root;
		int val1=-1,val2=-1;
		boolean  ans=false;
		//inorder simple
		while(true){
			while(!flag1){
				if(curr1!=null){
					stack1.add(curr1);
					curr1=curr1.left;
				}
				else{
					if(stack1.isEmpty()){
						flag1=false;
					}
					else{
						curr1=stack1.pop();
						val1=curr1.val;
						curr1=curr1.right;
						flag1=true;
					}

				}
			}

			while(!flag2){
				if(curr2!=null){
					stack2.add(curr2);
					curr2=curr2.left;
				}
				else{
					if(stack2.isEmpty()){
						flag2=true;
					}
					else{
						curr2=stack.pop();
						val2=curr2.val;
						curr2=curr2.right;
						flag2=true;
					}
				}
			}

			if(val1!=val2&&val1+val2==sum){
				System.out.println(val1+":"+val2);
				return;
			}
			else if(val1+val2>sum){
				flag2=false;
			}
			else if(val1+val2<num){
				flag1=false;
			}

			if(val1>=val2){
				return;
			}

		}	
	}
}