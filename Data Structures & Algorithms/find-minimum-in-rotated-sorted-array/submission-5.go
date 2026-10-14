func findMin(nums []int) int {
     var left = nums[0]
     var right = nums[len(nums) - 1]
     var res = left
     if left < right {
        return left
     } else {
        l, r := 0, (len(nums) - 1)
        for l <= r{
            mid := (l + r) / 2
            print(mid)
            if nums[mid] > nums[r] {
                l = mid + 1;
            } else {
                r = mid - 1
                res = min(res, nums[mid])
            }
        }
     }
     return res
}
