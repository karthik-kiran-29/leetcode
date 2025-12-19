class Solution {
    public List<List<Integer>> mainList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        backtrack(0,new ArrayList<>(),candidates,target,0);

        return mainList;
    }

    private void backtrack(int i,List<Integer> list,int[] candidates,int target,int sum){
        if(sum==target){
            mainList.add(new ArrayList<>(list));
            return;
        }

        if(i>candidates.length-1 || sum > target){
            return;
        }
        

        list.add(candidates[i]);

        backtrack(i,list,candidates,target,sum+candidates[i]);

        list.remove(list.size() - 1);

        backtrack(i+1,list,candidates,target,sum);

        return;
    }
}