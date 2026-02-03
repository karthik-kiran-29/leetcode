class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        Arrays.sort(nums);

        int i =0;
        int j =1;

        while(j<nums.length){
            if(nums[i]==nums[j]){
                i+=2;
                j+=2;
            }else{
                return nums[i];
            }
        }

        if (i < nums.length) {
            return nums[i];
}

        return -1;
        
    }
}