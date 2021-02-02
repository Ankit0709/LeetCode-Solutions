//MInNoOfCoinsGreedy
//LInk : https://www.geeksforgeeks.org/greedy-algorithm-to-find-minimum-number-of-coins/
class MInNoOfCoinsGreedy{
	public int minCoins(int amount){
		int[] coins={1,2,5,10,20,50,100,1000};
		int ans=0;
		for(int i=coins.length-1;i>=0;i--){
			while(amount>=coins[i]){
				amount-=coins[i];
				ans++;
			}
		}
		return ans;
	}
	//Exponential
	public int minCoinsRec(int amount,int[] coins){
		if(amount==0){return 0;}
		int res=Integer.MAX_VALUE;
		for(int i=0;i<coins.length;i++){
			if*(coins[i]<=amount){
				int ans=minCoinsRec(amount-coins[i],coins);
				if(ans!=Integer.MAX_VALUE&&ans+1<res){
					res=ans+1;
				}
			}
		}
		return res;
	}
	public int minCoinsDP(int amount){
		int[] dp=new int[amount+1];
		Arrays.fill(dp,Integer.MAX_VALUE);
				dp[0]=0;
		for(int i=1;i<=amount;i++){
			for(int j=0;j<coins.length;j++){
				if(coins[j]<=i){
					int sub=dp[i-coins[i]];
					if(sub!=Integer.MAX_VALUE&&sub+1<dp[i]){
						dp[i]=sub+1;
					}
				}
			}
		}
		return dp[amount];
	}
}