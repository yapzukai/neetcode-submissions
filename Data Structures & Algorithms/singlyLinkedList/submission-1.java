class LinkedList {
    java.util.LinkedList<Integer> list;

    public LinkedList() {
        list = new java.util.LinkedList<>();
    }

    public int get(int index) {
        if (index < 0 || index >= list.size()) {
            return -1;
        }
        return list.get(index);
    }

    public void insertHead(int val) {
        list.addFirst(val);
    }

    public void insertTail(int val) {
        list.addLast(val);
    }

    public boolean remove(int index) {
        if (index < 0 || index >= list.size()) {
            return false;
        }
        list.remove(index);
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> answer = new ArrayList<>(list.size());
        for (int n: list){
            answer.add(n);
        }
        return answer;
    }
}