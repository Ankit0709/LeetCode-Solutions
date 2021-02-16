//KthSmallest
//Problem Link : https://leetcode.com/problems/kth-smallest-element-in-a-bst/
class Solution {
	//1.Stack Based
	public int kthSmallestStack(TreeNode root, int k) {
		if(root==null){
			return -1;
		}
		Stack<TreeNode> stack=new Stack<>();
		TreeNode curr=root;
		int cnt=0;
		while(!stack.isEmpty()||curr!=null){
			while(curr!=null){
				stack.push(curr);
				curr=curr.left;
			}
			TreeNode top=stack.pop();
			cnt++;
			if(cnt==k){
				return top.val;
			}
			curr=top.right;
		}
		return -1;
	}

	//2. Morris Traversal
    public int kthSmallest(TreeNode root, int k) {
        int cnt=0;
        while(root!=null){            
            if(root.left==null){
                cnt++;
                if(cnt==k){
                    return root.val;
                }
                root=root.right;
            }
            else{
                TreeNode pre=root.left;
                while(pre.right!=null&&pre.right!=root){
                     pre=pre.right;
                }
                if(pre.right==null){
                    pre.right=root;
                    root=root.left;
                }
                else{
                    cnt++;
                    pre.right=null;
                    if(cnt==k){
                        return root.val;
                    }
                    root=root.right;                    
                }
            }
                    
        }
        return -1;    
    }
}