//AddTwoNumbers
////Problem Link : https://leetcode.com/problems/add-two-numbers/
class AddTwoNumbers {
      public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       if(l1==null&&l2==null){
       	  return null;
       }
       int carry=0,sum=0;
       ListNode head=null;
       ListNode curr=null;
       while(l1!=null||l2!=null){
       	  sum=(l1==null?0:l1.val)+(l2==null?0:l2.val)+carry;
       	  carry=sum/10;
       	  sum=sum%10;
       	  if(head==null){
       	  	head=new ListNode(sum);
       	  	curr=head;
       	  }
       	  else{
       	  	curr.next=new ListNode(sum);
       	  	curr=curr.next;
       	  }
			
			if(l1!=null){
				  l1=l1.next;
			}
			if(l2!=null){
				  l2=l2.next;
			}	         
       }
      if(carry==1){
      	curr.next=new ListNode(1);
      	curr=curr.next;
      }
      return head;
    }
}