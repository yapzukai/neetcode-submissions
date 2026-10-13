class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int high = matrix.length - 1;
        int low = 0;
        while (high >= low){
            int mid = low + (high - low)/2;
            int lower = 0;
            int higher = matrix[mid].length - 1;
            if(target < matrix[mid][lower]){
                high = mid - 1;
            }else if(target > matrix[mid][higher]){
                low = mid + 1;
            }else{
                while (higher >= lower){
                    int middle = lower + (higher - lower) / 2;
                    if(target < matrix[mid][middle]){
                        higher = middle - 1;
                    }else if(target > matrix[mid][middle]){
                        lower = middle + 1;
                    }else{
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
