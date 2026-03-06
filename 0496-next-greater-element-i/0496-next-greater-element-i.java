class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack <Integer> stack = new Stack<>();
        HashMap <Integer,Integer> map = new HashMap<>();
        
        for(int i = nums2.length - 1;i>=0;i--){
            int currValue = nums2[i];

            while(!stack.isEmpty() && stack.peek() <= currValue){
                stack.pop();
            }

            if(!stack.isEmpty()){
                map.put(currValue,stack.peek());
            }

            stack.push(currValue);
        }

        int[] newArr = new int[nums1.length];

        for(int i =0;i<nums1.length;i++){
            newArr[i] = map.getOrDefault(nums1[i],-1);
        }

        return newArr;
    }
}