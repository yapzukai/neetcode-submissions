class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> holder = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            holder.put(target - nums[i], i);
        }
        for (int i = 0; i< nums.length; i++){
            if (holder.get(nums[i]) != null && holder.get(nums[i])!= i){
                return new int[]{i, holder.get(nums[i])};
            }
        }
        return null;
    }
}
