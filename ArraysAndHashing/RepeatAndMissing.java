//RepeatAndMissing
//Problem LInk :https://www.interviewbit.com/problems/repeat-and-missing-number-array/
public class RepeatAndMissing {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
     public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int result=0;
        for(Integer x:A){
        	result^=x;
        }
        int n=A.size();
        for(int i=1;i<=n;i++){
        	result^=i;
        }
        //result  -> 3^4
        int setBit=(int)(Math.log10(n&-n)/Math.log10(2))+1;
        int xor_sum=0;
        //divide them into group on basid of set bit
        for(Integer x:A){
        	if((x&setBit)==1){
        		xor_sum^=x;
        	}
        	
        }
        for(int i=1;i<=n;i++){
        	if((i&setBit)==1){
        		xor_sum^=i;
        	}
        }
        int ele1=xor_sum;
        int ele2=result^xor_sum;
        ArrayList<Integer> ans=new ArrayList<>();
        boolean flag=false;
        for(Integer x:A){
        	if(x==ele1){
        		ans.add(ele1);
        		flag=true;
        	}
        }
        if(!flag){
        	ans.add(ele2);
        	ans.add(ele1);
        }
        else{
        	ans.add(ele2);
        }
     
        return ans;


    }
}
