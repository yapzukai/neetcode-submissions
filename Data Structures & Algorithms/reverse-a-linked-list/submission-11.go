/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func reverseList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
        return head
    }
	first := head
    sec := first.Next
	first.Next = nil
	for sec.Next != nil {
		temp := sec.Next
		sec.Next = first
		first = sec
		sec = temp
	}
	sec.Next = first
	return sec
}
