class DynamicArray {
    private Map<String, Object> map;
    private int capacity;

    public DynamicArray(int capacity) {
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int i) {
        return (int) map.get(Integer.toString(i));
    } 

    public void set(int i, int n) {
        map.put(Integer.toString(i), n);
    }

    public void pushback(int n) {
        if(map.size()==capacity){
            resize();
        }
        if(map.size() == 0){
            map.put("0", n);
            return;
        }
        map.put(Integer.toString(map.size()), n);
    }

    public int popback() {
        int n = map.size() - 1;
        Object temp = map.get(Integer.toString(n));
        map.remove(Integer.toString(n));
        return (int) temp;
    }

    private void resize() {
        int size = capacity * 2;
        capacity = size;
        Map<String, Object> tempMap = new HashMap<>(size);
        tempMap.putAll(map);
        map = tempMap;
    }

    public int getSize() {
        return map.size();
    }

    public int getCapacity() {
        return capacity;
    }
}
