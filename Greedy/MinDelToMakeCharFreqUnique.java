//MinDelToMakeCharFreqUnique
//Problem Link : https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
class MinDelToMakeCharFreqUnique {
     public int minDeletions(String s) {
        int del=0;
        int[] freq=new int[26];
        int len=s.length();
        for(int i=0;i<len;i++){
            freq[s.charAt(i)-'a']++;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                while(freq[i]!=0&&set.contains(freq[i])){
                    freq[i]--;
                    del++;
                }
                if(freq[i]!=0)
                    set.add(freq[i]);
                
            }
        }
        return del;
    }
    public int minDelOptimised(String s){
    	 int del=0;
        int[] freq=new int[26];
        int len=s.length();
        for(int i=0;i<len;i++){
            freq[s.charAt(i)-'a']++;
        }
        freq = Arrays.stream(freq).boxed()
                            .sorted(Collections.reverseOrder())
                            .mapToInt(Integer::intValue)
                            .toArray();
        int prev=freq[0];
        for(int i=1;i<26;i++){
        	if(freq[i]==0){
        		break;
        	}
        	else if(freq[i]<prev){
        		prev=freq[i];
        	}
        	else{
        		del+=freq[i]-prev+1;
        		prev=Math.max(prev-1,1);
        	}
        }
        return del;
    }
}