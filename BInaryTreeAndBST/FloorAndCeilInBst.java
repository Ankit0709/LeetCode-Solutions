//FloorAndCeilInBst
//Problem Link : https://www.geeksforgeeks.org/floor-and-ceil-from-a-bst/
class FloorAndCeilInBst{
	//1.Recursive Approach for Ceil 
	int floor=-1,ceil=-1;
	public void ceil(TreeNode root,int key){
		if(root==null){
			return;
		}
		if(root.val==key){
			floor=root.val;
			ceil=root.val;
			return;
		}
		else if(root.val<key){
			floor=root.val;
			ceil(root.right,key);
		}
		else{
			ceil=root.val;
			ceil(root.left,key);
		}
	}
	//2,Iteartive Approach For ceil
	public void floorAndCeil(TreeNode root,int key){
		int floor=-1,ceil=-1;
		while(root!=null){
			if(root.val==key){
				floor=root.val;
				ceil=root.val;
				break ;
			}
			if(root.val>key){
				ceil=root.val;
				root=root.left;
			}
			else{
				floor=root.val;
				root=root.right;
			}
		}
		System.out.println(ceil+" : "+floor);
	}
}