class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>(); // value -> list of indices
        
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int complement = -(nums[i] + nums[j]);
                
                if (map.containsKey(complement)) {
                    // check if any stored index is different from i and j
                    for (int idx : map.get(complement)) {
                        if (idx != i && idx != j) {
                            List<Integer> combined = new ArrayList<>();
                            combined.add(nums[i]);
                            combined.add(nums[j]);
                            combined.add(complement);
                            Collections.sort(combined);
                            if (!answer.contains(combined)) {
                                answer.add(combined);
                            }
                            break;  // one valid index is enough
                        }
                    }
                }
                
                // store both indices
                map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
                map.computeIfAbsent(nums[j], k -> new ArrayList<>()).add(j);
            }
        }
        return answer;
    }
}