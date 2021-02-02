//MinPlatformsRequired
//Problem LInk : https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
class MinPlatformsRequired{
	public int minPlatforms(int[] arr,int[] dep,int n){
		Arrays.sort(arr);
		Arrays.sort(dep);
		int minPlatforms=0;
		int i=0,j=0;
		int maxAns=0;
		while(i<arr.length&&j<dep.length){
			if(arr[i]<dep[j]){
				minPlatforms++;
				i++;
			}
			else{
				minPlatforms--;
				j++;
			}
			maxAns=Math.max(maxAns,minPlatforms);
		}
		return maxAns;
	}
}