class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> tempList = new ArrayList<>();

        backtrack(0,tempList,nums);

        return list;
    }

    private void backtrack(int i,List<Integer> tempList,int[] nums){
        if(i>=nums.length){
            list.add(new ArrayList<>(tempList));
            return;
        }

        backtrack(i+1,tempList,nums);

        tempList.add(nums[i]);

        backtrack(i+1,tempList,nums);

        tempList.remove(tempList.size() - 1);
    }
}