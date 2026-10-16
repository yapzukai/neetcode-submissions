func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
    if len(nums1) > len(nums2) {
        nums1, nums2 = nums2, nums1
    }
    total := len(nums1) + len(nums2)
    half := total / 2

    l, r := 0, len(nums1)-1
    for {
        m1 := (l + r) >> 1      // floors even when l+r == -1
        m2 := half - m1 - 2

        left1, right1 := math.MinInt, math.MaxInt
        left2, right2 := math.MinInt, math.MaxInt
        if m1 >= 0           { left1 = nums1[m1] }
        if m1+1 < len(nums1) { right1 = nums1[m1+1] }
        if m2 >= 0           { left2 = nums2[m2] }
        if m2+1 < len(nums2) { right2 = nums2[m2+1] }

        if left1 <= right2 && left2 <= right1 {
            if total%2 == 0 {
                return float64(max(left1, left2)+min(right1, right2)) / 2
            }
            return float64(min(right1, right2))
        } else if left1 > right2 {
            r = m1 - 1
        } else {
            l = m1 + 1
        }
    }
}