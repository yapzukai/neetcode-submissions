func minEatingSpeed(piles []int, h int) int {
    var right = piles[0]
    for i := 0; i < len(piles); i++{
        right = max(piles[i], right)
    }
    var res = 0
    var left = 1
    for left <= right {
        var mid = left + (right - left) / 2
        var count = 0
        for i := 0; i < len(piles); i++{
            hours := (piles[i] + mid - 1)/ mid;
            count += hours
        }
        if count <= h{
            res = mid
            right = mid - 1
        } else if count > h{
            left = mid + 1
        } 
    }
    return res
}
