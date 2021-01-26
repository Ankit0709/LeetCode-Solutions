//SwappingNodesInLL
//Problem Link : https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
class SwappingNodesInLL {
     public ListNode swapNodes(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode prev1=null,prev2=null,next2=null;
        ListNode slow=head,fast=head;
        while(fast!=null&&k>1){
            fast=fast.next;           
            k--;
        }
        ListNode firstkthNode=fast;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        ListNode lastkthNode=slow;
       int temp=firstkthNode.val;
       firstkthNode.val=lastkthNode.val;
       firstkthNode.val=temp;
       return head;

    }   
}