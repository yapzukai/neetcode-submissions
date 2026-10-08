class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int len = s1.length();
        char[] arr = s1.toCharArray();
        Arrays.sort(arr);
        String sorted = new String(arr);
        for (int i = 0; i < s2.length() - len + 1; i++){
            String substring = s2.substring(i, i + len);
            char[] temp = substring.toCharArray();
            Arrays.sort(temp);
            String tempSorted = new String(temp);
            if(tempSorted.equals(sorted)){
                return true;
            }
        }
        return false;
    }
}
