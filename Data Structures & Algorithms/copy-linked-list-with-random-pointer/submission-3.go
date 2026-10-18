func copyRandomList(head *Node) *Node {
	if head == nil {
		return nil
	}

	copies := map[*Node]*Node{}

	// pass 1: create a copy of every node
	for cur := head; cur != nil; cur = cur.Next {
		copies[cur] = &Node{Val: cur.Val}
	}

	// pass 2: connect the copies
	for cur := head; cur != nil; cur = cur.Next {
		copies[cur].Next = copies[cur.Next]
		copies[cur].Random = copies[cur.Random]
	}

	return copies[head]
}