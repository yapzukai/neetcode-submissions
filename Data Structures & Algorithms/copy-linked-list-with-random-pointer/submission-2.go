func copyRandomList(head *Node) *Node {
	if head == nil {
		return nil
	}
	origHead := head   // keep this, never move it

	// build the copy with Next pointers
	res := &Node{Val: head.Val}
	final := res
	for cur := head.Next; cur != nil; cur = cur.Next {
		res.Next = &Node{Val: cur.Val}
		res = res.Next
	}

	// wire up Random pointers
	dummy := final
	for orig := origHead; orig != nil; orig = orig.Next {
		target := orig.Random

		count := 0   // index of target in the original list
		for t := origHead; t != target; t = t.Next {
			count++
		}

		t := final   // same index in the copy
		for i := 0; i < count; i++ {
			t = t.Next
		}
		dummy.Random = t
		dummy = dummy.Next
	}
	return final
}