func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	n := len(nums1)
	m := len(nums2)
	var arr []int

	var i, j int
	for i < n && j < m {
		if nums1[i] < nums2[j] {
			arr = append(arr, nums1[i])
			i++
		} else {
			arr = append(arr, nums2[j])
			j++
		}
	}
	if i < n {
		arr = append(arr, nums1[i:]...)
	}
	if j < m {
		arr = append(arr, nums2[j:]...)
	}

	k := len(arr)
	if k%2 == 0 {
		return (float64(arr[k/2-1]) + float64(arr[k/2]))/2.0
	}
	return float64(arr[k/2])
}
