class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> check = new HashMap<>();
        for(int i: nums){
            if(check.containsKey(i)){
                return true;
            }
            check.put(i, i);
        }
        return false;
    } 
}