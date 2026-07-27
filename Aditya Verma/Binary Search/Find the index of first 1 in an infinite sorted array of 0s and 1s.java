class Solution {
    public int firstOne(int[] arr) {
        int start = 0;
        int end = 1;

        // Find a range where 1 exists
        while (arr[end] != 1) {
            start = end;
            end = end * 2;
        }

        // Binary search for first 1
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == 1) {
                ans = mid;
                end = mid - 1;
            } 
            else {
                start = mid + 1;
            }
        }

        return ans;
    }
}
