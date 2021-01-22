//DeleteNode
//Problem Link :https://leetcode.com/problems/delete-node-in-a-linked-list/
class DeleteNode {
    public void deleteNode(ListNode node) {
        if(node==null){
            return;
        }
        node.val=node.next.val;
        node.next=node.next.next;
    }
}