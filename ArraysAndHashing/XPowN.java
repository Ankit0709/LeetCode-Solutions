// /XPowN
//Problem LInk :https://leetcode.com/problems/powx-n/
class XPowN {
	 public double binaryExp(double x,int n){
		if(n==0){
			return 1;
		}
		double ans=0;
		double pow=x;
		while(n>0){
			//if bit is set
			if((n&1)==1){
				ans+=pow;
			}
			n>>=1;
			pow*=x;
		}
		return ans;

	}
    public double myPow(double x, int n) {        
        double ans=binaryExp(x,Math.abs(n));
        if(n<0){
            ans=1/ans;
        }
        return ans;
        
    }	
}