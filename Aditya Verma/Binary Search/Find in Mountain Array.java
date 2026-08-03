class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = peak(mountainArr);//find peak index
        // Search in increasing part
        int ans = binarySearch(mountainArr, target, 0, peak, true);//we will pass arr, target ,0, peak 
        if (ans != -1) {
            return ans;
        }
        // Search in decreasing part
        return binarySearch(mountainArr, target, peak + 1,
                            mountainArr.length() - 1, false);
    }
    // Find peak index
    int peak(MountainArray arr) {
        int l = 1, r = arr.length() - 2;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr.get(m) > arr.get(m - 1) &&
                arr.get(m) > arr.get(m + 1)) {
                return m;
            } else if (arr.get(m) < arr.get(m + 1)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;// not gonna happen because it should contain peek
    }

    // Binary Search
    int binarySearch(MountainArray arr, int target,
                     int l, int r, boolean asc) {

        while (l <= r) {
            int m = l + (r - l) / 2;
            int val = arr.get(m);

            if (val == target) {
                return m;
            }
            if (asc) {//this if part is for ascending order 
                if (target < val) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {//this for decending
                if (target < val) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
