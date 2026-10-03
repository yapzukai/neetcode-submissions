class DynamicArray {
    private int[] arr;
    private int size = 0;
    private int capacity;

    public DynamicArray(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (size == capacity){
            resize();
        }
        arr[size] = n;
        size++;
    }

    public int popback() {
        int temp = arr[size - 1];
        arr[size - 1] = 0;
        size--;
        return temp;
    }

    private void resize() {
        capacity *= 2;
        int[] latest = Arrays.copyOf(arr, capacity);
        this.arr = latest;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
