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
    public ListNode mergeKLists(ListNode[] lists) {
        
        Map<Integer, ListNode> map = new TreeMap<>();
        Map<Integer, ListNode> heads = new TreeMap<>();
        for (int i = 0; i < lists.length; i++){
            ListNode temp = lists[i];
            while (temp != null){
                ListNode node = temp;
                ListNode curr = map.computeIfAbsent(temp.val, k -> node);
                heads.computeIfAbsent(temp.val, k-> node);
                if (temp != curr){
                    curr.next = temp;
                    map.put(temp.val, temp);
                }
                temp = temp.next;
            }
        }
        List<ListNode> ends = new ArrayList<>(map.values());
        List<ListNode> head = new ArrayList<>(heads.values());
        for (int i = 1; i < head.size(); i++){
            ends.get(i-1).next = head.get(i);
        }
        if (head.isEmpty()) return null;
        return head.get(0);
    }
}
