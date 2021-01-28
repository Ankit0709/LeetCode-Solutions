//MaxConsecutiveOnes3
//Problem Link : https://leetcode.com/problems/max-consecutive-ones-iii/
class MaxConsecutiveOnes3 {
    public int longestOnes(int[] A, int K) {
        int len=A.length;
        int max_len=0;
        int start=0,end=0;
        int zeroCount=0;
        while(end<len){
            if(A[end]==0){
                zeroCount++;
            }
            while(zeroCount>K){
                if(A[start]==0){
                    zeroCount--;                    
                }
                start++;
            }
            max_len=Math.max(max_len,end-start+1);
            end++;
        }
        return max_len;
    }
}