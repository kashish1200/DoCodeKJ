class Solution {
    static int findFloor(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] <= x) {
                // arr[mid] is a possible floor
                ans = mid;

                // Try to find a larger element
                // that is also <= x
                start = mid + 1;
            } 
            else {
                // arr[mid] is greater than x
                // so search on the left
                end = mid - 1;
            }
        }

        return ans;
    }
}
