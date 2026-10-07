class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = Character.toLowerCase(s.charAt(i));
            if(c >= 'a' && c <= 'z' || c >= '0' && c <= '9'){
                sb.append(c);
            }
        }
        String ter = sb.toString();
        for (int i = 0; i < ter.length()/2; i++){
            if (ter.charAt(i) != ter.charAt(ter.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
