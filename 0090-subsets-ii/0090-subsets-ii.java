class Solution {
    private ArrayList<List<Integer>> finalList = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, new ArrayList<Integer>(), nums);
        return finalList;
    }

    private void backtrack(int i, List<Integer> list, int[] nums) {
        finalList.add(new ArrayList<>(list));
        
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            
            list.add(nums[j]);
            backtrack(j + 1, list, nums);
            list.remove(list.size() - 1);
        }
    }
}