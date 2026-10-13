class Solution {
    public int search(int[] nums, int target) {
        int lower = 0;
        int upper = nums.length - 1;
        int index = nums.length / 2;
        if(nums[upper] == target){
            return upper;
        }else if(nums[lower] == target){
            return lower;
        }
        while(true){
            int curr = nums[index];
            int prev = index;
            if(curr == target){
                return index;
            }else if(curr < target){
                lower = index;
                index = (upper + index) / 2;
            }else if(curr > target){
                upper = index;
                index = (lower + index) / 2;
            }
            if(index == prev){
                return -1;
            }
        }
    }
}
