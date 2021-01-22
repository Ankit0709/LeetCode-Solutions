//IntersectionOfTwoLL
//////Problem Link : https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionOfTwoLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||head2==null){
        	return null;
        }
        ListNode curr1=headA,curr2=headB;
        while(curr1!=null||curr2!=null){
        	if(curr1==null){
        		curr1=headB;
        	}
        	if(curr2==null){
        		curr2=headA;
        	}
        	if(curr1==curr2){
        		return curr1;
        	}
        	curr1=curr1.next;
        	curr2=curr2.next;
        	
        }
        return null;
    }
}