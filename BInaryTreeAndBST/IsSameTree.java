// /IsSameTree
//Problem Link : https://leetcode.com/problems/same-tree/
class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){return true;}
        return p!=null&&q!=null&&p.val==q.val
            &&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}