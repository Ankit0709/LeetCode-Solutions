// /NearestSmallerElement
//Problem LInk : https://www.interviewbit.com/problems/nearest-smaller-element/
public class NearestSmallerElement {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
    	int len=A.size();
    	int[] ans=new int[len];
    	Stack<Integer> stack=new Stack<>();
    	stack.add(len-1);
    	for(int i=len-2;i>=0;i--){
    		int curr=A.get(i);
    		while(!stack.isEmpty()&&curr<A.get(stack.peek())){
    			ans[stack.pop()]=curr;
    		}
    		stack.add(i);
    	}
    	while(!stack.isEmpty()){
    		ans[stack.pop()]=-1;
    	}
    	ArrayList<Integer> list=new ArrayList<>();
    	for(int i=0;i<ans.length;i++){
    		list.add(ans[i]);
    	}
    	return list;
    }
}
