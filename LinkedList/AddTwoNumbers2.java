//AddTwoNumbers2
//Problem Link : https://leetcode.com/problems/add-two-numbers-ii/
class AddTwoNumbers2 {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       if(l1==null){
       	return l2;
       }
       if(l2==null){
       	return l1;
       }
       Stack<Integer> s1=new Stack<>();
       Stack<Integer> s2=new Stack();
       while(l1!=null){
	       	s1.push(l1.val);
	       	l1=l1.next;
       }
       while(l2!=null){
       		s2.push(l2.val);
       		l2=l2.next;
       }
       ListNode result=null;
       int carry=0;
       while(!s1.isEmpty()||!s2.isEmpty()){
       		int sum=(s1.isEmpty()?0:s1.pop())+(s2.isEmpty()?0:s2.pop())+carry;
       		carry=sum/10;
       		sum%=10;
       		ListNode node=new ListNode(sum);
       		node.next=result;
       		result=node;
       }
       if(carry==1){
       	node.next=new ListNode(1);
       	result=node;
       }
       return result;
    }
}