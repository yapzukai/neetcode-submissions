class TimeMap {
    private Map<String, List<Pair<Integer, String>>> store;

    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = store.getOrDefault(key, new ArrayList<>());
        int l = 0, r = values.size() - 1;
        String res = "";
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (values.get(m).getKey() <= timestamp) {
                res = values.get(m).getValue();
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}