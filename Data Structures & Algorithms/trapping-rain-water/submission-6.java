class Solution {
    public int trap(int[] height) {
        int res = 0;
        int start = 0;
        for (int i = 0; i < height.length; i++){
            if (height[i] > 0){
                start = i;
                break;
            }
        }
        List<Integer> left = new ArrayList<>();
        int leftTallest = height[start];
        left.add(height[start]);
        for(int i = start + 1; i < height.length; i++){
            // System.out.println(leftTallest);
            if (height[i] <= height[i-1]){
                left.add(height[i]);
            } else {
                // System.out.println("hi");
                int shorter = height[i];
                if(height[i] >= leftTallest){
                    shorter = leftTallest;
                }
                for(int j = i - 1; j > start; j--){
                    int curr = height[j];
                    if (curr < shorter){
                        res += (shorter - curr);
                        // System.out.println(curr + " " + res);
                        height[j] = shorter;
                    } 
                } 
                if(height[i] > leftTallest){
                    leftTallest = height[i];
                    start = i;
                }
                // System.out.println("Start" + start);

            }

        }
        return res;
    }
}

