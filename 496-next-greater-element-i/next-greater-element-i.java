class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nge=new int[nums1.length];

        for(int i=0;i<nums1.length;i++){
            int j=0;

            while(nums2[j]!=nums1[i]){
                j++;
            }

            int k;
            for(k=j+1;k<nums2.length;k++){
                if(nums2[k]>nums1[i]){
                    nge[i]=nums2[k];
                    break;
                }
            }

            if(k==nums2.length) nge[i]=-1;
        }
        return nge;
    }
}