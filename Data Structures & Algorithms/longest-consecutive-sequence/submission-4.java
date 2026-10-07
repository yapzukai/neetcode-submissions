class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] sorted = nums;
        Arrays.sort(sorted);
        int biggest = 1;
        int current = 1;
        for (int i = 0; i < nums.length - 1; i++){
            if (sorted[i] == sorted[i+1] - 1){
                current++;
            }else if(sorted[i] == sorted[i+1]){
                continue;
            }else {
                if(current > biggest){
                    biggest = current;
                }
                current = 1;
            }
        }
        return Math.max(current, biggest);
    }
}
