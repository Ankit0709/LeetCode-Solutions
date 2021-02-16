// /CountCompleteNodes
//Problem LInk : https://leetcode.com/problems/count-complete-tree-nodes/


class CountCompleteNodes {
	//1.Approach Perform DFS and count nodes in left ,right subtree
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftNodes=countNodes(root.left);
        int rightNodes=countNodes(root.right);
        return leftNodes+rightNodes+1;        
    }

    //2.Opti Approach check in left subtree,right subtree that levels of both matches or not 
    //if matches means it is perfect binary tree so no of nodes are pow(2,lvl)-1
    //else return 1+left+right;
    public int countNodesOpti(TreeNode root) {
      if(root==null){
          return 0;
      }  
      return countHelper(root);
    }
     public int countHelper(TreeNode root){
        if(root==null){
            return 0;
        }
        int ln=1,rn=1;;
        TreeNode leftDir=root.left,rightDir=root.right;
        while(leftDir!=null){
            leftDir=leftDir.left;
            ln++;
        }
        while(rightDir!=null){
            rightDir=rightDir.right;
            rn++;
        }
        if(ln==rn){
            return (int)Math.pow(2,ln)-1;
        }
        return 1+countHelper(root.left)+countHelper(root.right);
    }
}