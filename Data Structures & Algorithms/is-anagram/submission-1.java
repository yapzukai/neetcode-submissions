class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> check = new HashMap<>();
        for(int i =0; i < s.length();i++){
            char c = s.charAt(i);
            if(check.containsKey(c)){
                check.put(c, check.get(c) + 1);
            }else{
                check.put(c, 1);
            }
        }
        for(int i =0; i < t.length();i++){
            char c = t.charAt(i);
            if(check.containsKey(c)){
                if(check.get(c) == 1){
                    check.remove(c);
                    continue;
                }
                check.put(c, check.get(c) - 1);
            }else{
                return false;
            }
        }

        return true;
    }
}
