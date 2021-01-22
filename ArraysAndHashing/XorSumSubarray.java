//XorSumSubarray
//Problem LInk :https://www.interviewbit.com/problems/subarray-with-given-xor/ 
public class XorSumSubarray {
     public int solve(ArrayList<Integer> A, int B) {
     	int ans=0;
     	Map<Integer,Integer> map=new HashMap<>();
     	int[] prefix_xor=new int[A.size()];
     	prefix_xor[0]=A.get(0);
     	for(int i=1;i<prefix_xor.length;i++){
     		prefix_xor[i]=prefix_xor[i-1]^A.get(i);
     	}
     	for(int i=0;i<prefix_xor.length;i++){
     		int tmp=prefix_xor[i]^B;
     		if(map.containsKey(tmp)){
     			ans+=map.get(tmp);
     		}
     		if(prefix_xor[i]==B){
     			ans++;
     		}
     		map.put(prefix_xor[i],map.getOrDefault(prefix_xor[i],0)+1);
     	}
     	return ans;
    }
}
