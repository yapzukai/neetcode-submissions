class Solution {
    public int characterReplacement(String s, int k) {
        int count = 0;
        int currStart = 0;
        int newStart = 0;
        int max = 0;
        char currentChar = s.charAt(0);
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c != currentChar){
                if(count == 0){
                    newStart = i;
                }
                count++;
            }
            if(count > k){
                currentChar = s.charAt(newStart);
                currStart = newStart;
                i = newStart;
                count = 0;
            }
            if(i == s.length() - 1 && k > count){
                System.out.println(currentChar);
                max = Math.max(max, i - currStart + 1 + k - count);
            }
            if(i == s.length() - 1 && currStart < newStart){
                currentChar = s.charAt(newStart);
                max = Math.max(max, i - currStart + 1);
                i = newStart;
                count = 0;
                currStart = newStart;
                continue;
            }            
            max = Math.max(max, i - currStart + 1);
        }
        return Math.min(max, s.length());
    }
}
