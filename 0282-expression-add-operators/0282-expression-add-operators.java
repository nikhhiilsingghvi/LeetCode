class Solution {
    private List<String> ans = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        dfs(0,"",0,0,num,target);
        return ans;
    }

    private void dfs(int i, String path, long resSoFar, long prevNum, String num, int target){
        if(i == num.length()){
            if(resSoFar == target) ans.add(path);
            return;
        }

        for(int j=i;j<num.length();j++){
            if(j>i && num.charAt(i)=='0') break; // this is for skipping leading zero number
            long currNum = Long.parseLong(num.substring(i,j+1));
            if(i==0){
                dfs(j+1, path+currNum, currNum, currNum, num, target);
            }
            else{
                dfs(j+1, path + "+" + currNum, resSoFar + currNum, currNum, num, target);
                dfs(j+1, path + "-" + currNum, resSoFar - currNum, -currNum, num, target);
                dfs(j+1, path + "*" + currNum, resSoFar - prevNum + prevNum * currNum, prevNum * currNum, num, target);
            }
        }
    }
}