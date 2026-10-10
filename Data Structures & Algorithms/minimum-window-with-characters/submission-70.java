class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int matches = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 0);
            } else {
                map.put(c, map.get(c) - 1);
            }
        }

        int shortestStart = 0;
        int shortestEnd = 0;
        int shortest = s.length();
        int start = 0;
        boolean matched = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (!matched) {
                    start = i;
                    matched = true;
                }
                if (map.get(c) == 0) {
                    matches++;
                }
                map.put(c, map.get(c) + 1);
            }
            if (start < s.length() && matches == map.size()) {
                while (!map.containsKey(s.charAt(start)) || map.get(s.charAt(start)) - 1 > 0) {
                    if (map.containsKey(s.charAt(start))) {
                        map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                        if(map.get(s.charAt(start)) == 0){
                            System.out.println("this is" + start);
                            matches--;
                        }
                    }
                    start++;
                    if (start > s.length() - 1) {
                        break;
                    }
                }
            }
            if (matches == map.size() && i - start < shortest) {
                shortestStart = start;
                shortestEnd = i;
                shortest = i - start;
            }
        }
        if (matches == map.size()) {
            return s.substring(shortestStart, shortestEnd + 1);
        }
        return "";
    }
}
