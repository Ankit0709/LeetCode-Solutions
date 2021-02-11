// /SumOfSubarraysMin
//Problem Link : https://leetcode.com/problems/sum-of-subarray-minimums/
class SumOfSubarraysMin {
	//Brute Force T(n)=O(n2) S(n)=O(1) 
    public int sumSubarrayMins(int[] A) {
    	 int sum=0;
        int MOD=(int)1e9+7;
        for(int i=0;i<A.length;i++){
        	int min=A[i];
        	for(int j=i;j<A.length;j++){
        		min=Math.min(min,A[j]);
        		sum=(sum%MOD)+(min%MOD);
                sum%=MOD;
        	}
        }
        return sum;  
    }
    //Stack based Solution T(n)=O(n) S(n)=O(n)
    public int sumSubarrayMins(int[] A) {
    	int sum=0;
        int MOD=(int)1e9+7;
        int len=A.length;
        int[] presmaller=new int[len];
        int[] nextsmaller=new int[len];
        Stack<Integer> s1=new Stack;
        Stack<Integer> s2=new Stack;
        for(int i=0;i<len;i++){
        	nextsmaller[i]=len-i-1;
        	presmaller[i]=i;
        }
        for(int i=0;i<len;i++){
        	while(!s1.isEmpty()&&A[s1.peek()]>=A[i]){
        		nextsmaller[s1.peek()]=i-s1.peek()-1;
        		s1.pop();
        	}
        	s1.add(i);
        }
        for(int i=len-1;i>=0;i--){
        	while(!s2.isEmpty()&&A[s2.peek()]>=A[i]){
        		presmaller[s2.peek()]=s2.peek()-i-1;
        		s2.pop();
        	}
        	s2.add(i);
        }
        for(int i=0;i<len;i++){
        	sum+=(A[i]*(presmaller[i]+1)*(nextsmaller[i]+1));
        	sum%=MOD;
        }
        return sum;
    }
}