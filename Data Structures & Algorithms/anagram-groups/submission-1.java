class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs){
            char[] cArray = s.toCharArray();
            Arrays.sort(cArray);
            String key = new String(cArray);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        // List<List<String>> answer = new ArrayList<>();
        // int i = 0;
        // for (List<String> list : map.values()) {
        //     answer.add(new ArrayList<>(list));
        // }
        return new ArrayList<>(map.values());
    }
}
