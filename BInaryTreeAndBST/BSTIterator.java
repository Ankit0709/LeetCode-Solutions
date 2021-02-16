// /BSTIterator
//Problem LInk : https://leetcode.com/problems/binary-search-tree-iterator/
class BSTIterator {

	//1.Approach For BST USing Inorder traversal
    ArrayList<Integer> list;
    int indx;
    public void inorder(TreeNode root){
        if(root==null){return;}
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
        indx=0;
    }
    public BSTIterator(TreeNode root) {
        list=new ArrayList<>();
        inorder(root);
    }
    
    public int next() {
        return list.get(indx++);
    }
    
    public boolean hasNext() {
        return indx!=list.size();
    }


   
}

 //2. Approach Using Custom Stack
class BSTIteratorCustom {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack=new Stack<>();
        helper(root);
    }
    public void helper(TreeNode root){
        while(root!=null){
            stack.add(root);
            root=root.left;
        }
    }
    
    public int next() {
        TreeNode x=stack.pop();   
        if(x.right!=null){
            helper(x.right);
        }
        return x.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}