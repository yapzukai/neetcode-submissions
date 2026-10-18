/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	remove := head
	front := head
	if head.Next == nil{
		return nil
	}
    for i := 1; i < n+1; i++ {
		front = front.Next
	}
	if front == nil {
    return head.Next
}
	for front.Next != nil{
		remove = remove.Next
		front = front.Next
	}

	prev := remove
	remove = remove.Next
	prev.Next = remove.Next

	return head
}
