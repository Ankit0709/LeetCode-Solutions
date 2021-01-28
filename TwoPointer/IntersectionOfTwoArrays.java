//IntersectionOfTwoArrays
//Problem Link : https://leetcode.com/problems/intersection-of-two-arrays/
class IntersectionOfTwoArrays {
   public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans=new ArrayList<>();
        int i=0,j=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i<nums1.length&&j<nums2.length){
        	if(nums1[i]==nums2[j]){
        		ans.add(nums1[i]);
                i++;
                j++;
        		while(i!=0&&i<nums1.length&&nums1[i]==nums1[i-1]){
        			i++;
        		}
        		while(j!=0&&j<nums2.length&&nums2[j]==nums2[j-1]){
        			j++;
        		}
        	}
        	else if(nums1[i]<nums2[j]){
        		i++;
        	}
        	else{
        		j++;
        	}
        }
        System.out.println(ans);
        int[] val=new int[ans.size()];
        i=0;
        for(Integer x:ans){
        	val[i++]=x;
        }
        return val;
    }
}