func reorderList(head *ListNode) {
	if head == nil || head.Next == nil {
		return
	}

	// 1. find the end of the first half
	slow, fast := head, head
	for fast.Next != nil && fast.Next.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}

	// 2. cut, then reverse the second half
	var prev *ListNode
	cur := slow.Next
	slow.Next = nil
	for cur != nil {
		next := cur.Next
		cur.Next = prev
		prev = cur
		cur = next
	}

	// 3. interleave: first half, reversed second half
	first, second := head, prev
	for second != nil {
		n1, n2 := first.Next, second.Next
		first.Next = second
		second.Next = n1
		first, second = n1, n2
	}
}