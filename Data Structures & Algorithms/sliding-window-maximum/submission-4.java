class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int start = nums[0];
        int largest = nums[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++){
            pq.add(nums[i]);
            largest = Math.max(largest, nums[i]);
        }
        res.add(largest);
        for (int i = 1; i < nums.length - k +1; i++){
            pq.add(nums[i+k-1]);
            pq.remove(start);
            res.add(pq.peek());
            start = nums[i];
        }
    int[] answer = res.stream()
        .mapToInt(Integer::intValue)
        .toArray();
    return answer;
    }
}
