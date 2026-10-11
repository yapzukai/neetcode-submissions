class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        deque.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++){
            char c = s.charAt(i);
            if (deque.isEmpty()){
                deque.push(c);
                continue;
            }
            char last = deque.peekFirst();
            if(c == '}' && last == '{' ){
                deque.pop();
                continue;
            }
            if(c == ']' && last == '[' ){
                deque.pop();
                continue;
            }
            if(c == ')' && last == '(' ){
                deque.pop();
                continue;
            }
            deque.push(c);
        }
        if(deque.isEmpty()){
            return true;
        }
        return false;
    }
}
