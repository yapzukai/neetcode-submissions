class Solution {
    public int trap(int[] height) {
        if(height.length == 0){
            return 0;
        }
        int res = 0;
        int start = 0;
        for (int i = 0; i < height.length; i++){
            if (height[i] > 0){
                start = i;
                break;
            }
        }
        int leftTallest = height[start];
        for(int i = start + 1; i < height.length; i++){
            if (height[i] > height[i-1]){
                int shorter = height[i];
                if(height[i] >= leftTallest){
                    shorter = leftTallest;
                }
                for(int j = i - 1; j > start; j--){
                    int curr = height[j];
                    if (curr < shorter){
                        res += (shorter - curr);
                        height[j] = shorter;
                    } 
                } 
                if(height[i] > leftTallest){
                    leftTallest = height[i];
                    start = i;
                }
            }

        }
        return res;
    }
}

