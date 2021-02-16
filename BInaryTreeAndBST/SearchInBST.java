// /SearchInBST
//Problem LInk : https://leetcode.com/problems/search-in-a-binary-search-tree/	
class SearchInBST {

	//1.Recusrive approach
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null||root.val==val){
        	return root;
        }       
        else if(root.val<val){
        	return searchBST(root.right,val);
        }
        else{
        	return searchBST(root.left,val);
        }
    }

    //2.Iteartive Approach
       public TreeNode searchBSTIter(TreeNode root, int val) {
       	  if(root==null){
       	  	return null;
       	  }
       	  while(root!=null){
       	  	if(root.val==val){
       	  		return root;
       	  	}
       	  	else if(root.val<val){
       	  		root=root.right;
       	  	}
       	  	else{
       	  		root=root.left;
       	  	}
       	  }
       	  return null;
       }
}