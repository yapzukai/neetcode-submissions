class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++){
            int curr = temperatures[i];
            while(!stack.isEmpty() && stack.peek()[0] < curr){
                int[] arr = stack.pop();
                int position = arr[1];
                res[position] = i - position;
            }
            stack.push(new int[]{curr, i});
        }
        return res;
    }
}
