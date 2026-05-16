class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<List<Integer>> ans=new HashSet<>();
        fnc(0,candidates,target,ans,new ArrayList<>());
        return new ArrayList<>(ans);
    }

    private void fnc(int ind,int[] arr,int target,HashSet<List<Integer>> ans,List<Integer> ds){
        
        if(target==0){ 
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;

            ds.add(arr[i]);
            fnc(i+1,arr,target-arr[i],ans,ds);
            ds.remove(ds.size()-1);
        }
    }
}