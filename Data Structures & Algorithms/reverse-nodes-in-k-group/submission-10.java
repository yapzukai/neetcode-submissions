/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode copy = head;
        ListNode res = head;
        Boolean first = true;
        int count = 1;
        while (copy != null){
            map.put(count, copy);
            copy = copy.next;
            count++;
        }
        int round = 1;
        while (round <= map.size() / k){
            for(int i = 1; i <= k/2; i++){
                ListNode prev = map.get(i + k * (round - 1) - 1);
                ListNode start = map.get(i + k * (round - 1));
                ListNode prev2 = map.get(k*(round) - i + 1 - 1);
                ListNode end = map.get(k*(round) - i + 1);
                ListNode temp = start.next;
                map.put(i + k * (round - 1), end);
                map.put(k*(round) - i + 1, start);
                if (prev != null){
                    prev.next = end;
                }
                prev2.next = start;
                start.next = end.next;
                end.next = (temp == end) ? start : temp;   // changed
                if(first){
                    res = end;
                    first = false;
                }
            }
            round++;
        }
        return res;
    }
}