class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < heights.length; i++){
            int curr = heights[i];
            res = Math.max(res, curr);
            int index = i;
            while(!stack.isEmpty() && curr < stack.peek()[1]){
                int[] temp = stack.pop();
                index = temp[0];
                int height = temp[1];
                int area = height * (i - index);
                res = Math.max(area, res);
            }
            stack.push(new int[]{index, curr});
        }
        while(!stack.isEmpty()){
                int[] temp = stack.pop();
                int index = temp[0];
                int height = temp[1];
                int area = height * (heights.length - index);
                res = Math.max(area, res);
        }
        return res;
    }
}
