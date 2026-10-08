class Solution {
    public int maxProfit(int[] prices) {
        int smallest = prices[0];
        int max = 0;        
        for (int i:prices){
            if (i - smallest > max){
                max = i - smallest;
            }
            if (i < smallest){
                smallest = i;
            }
        }
        return max;
    }
}
