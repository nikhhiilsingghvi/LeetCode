class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> ans=new HashSet<>();
        fnc(0,nums,new ArrayList<>(),ans);
        return new ArrayList<>(ans);
    }

    private void fnc(int ind,int[] nums,List<Integer> ds,HashSet<List<Integer>> ans){
        ans.add(new ArrayList<>(ds));
    
        for(int i=ind;i<nums.length;i++){
            if(i > ind && nums[i]==nums[ind])
            continue;
            ds.add(nums[i]);
            fnc(i+1,nums,ds,ans);
            ds.remove(ds.size()-1);
        }
    }
}