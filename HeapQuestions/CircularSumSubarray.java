import java.util.*;
class CircularSumSubarray{
	public int kadeneAlgo(int[] A,int len){
		int curr_sum=0,max_end=0;
		for(int i=0;i<len;i++){
			curr_sum+=A[i];
			if(curr_sum<0){
				curr_sum=0;
			}
			else{
				max_end=Math.max(curr_sum,max_end);
			}
		}
		return max_end;
	}
	public int maxSubarraySumCircular(int[] A) {
        // when corner elements do not include sum of array elements
        int sum1=kadeneAlgo(A,A.length);

        //when corner elements include
        int total_sum=0;
        for(int i=0;i<A.length;i++){
        	total_sum+=A[i];
        	A[i]*=-1;
        }
        int sum2=kadeneAlgo(A,A.length);
        sum2=total_sum+sum2;
        return Math.max(sum1,sum2);
    }
	public static void main(String[] args) {
	   }
	}