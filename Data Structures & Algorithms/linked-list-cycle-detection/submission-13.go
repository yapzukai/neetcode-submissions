/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func hasCycle(head *ListNode) bool {
    slower := head
	faster := head
	for faster != nil {
		faster = faster.Next
		if faster != nil{
			faster = faster.Next
		}
		slower = slower.Next
		if faster != nil && faster.Next == slower {
			return true
		}
	}
	return false
}
