class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, List<Integer>> map = new TreeMap<>(Comparator.reverseOrder());
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                count++;
            } else {
                map.computeIfAbsent(count, c -> new ArrayList<>()).add(nums[i]);
                count = 1;
            }
        }
        return map.values().stream()
            .flatMap(List::stream)
            .limit(k)
            .mapToInt(Integer::intValue)
            .toArray();
    }
}