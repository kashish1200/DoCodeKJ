class Solution {
    public int search(int[] arr, int k) {
        int start = 0;
        int end = 1; //initially taking 1

        //jab end element chhota hai target se tab tk--->
        // Expand the search range, jab tk range me naa aa jaye target "k", tab tk end ko double krte raho...and start ko old end ki position
        while (arr[end] < k) {
            start = end;
            end = end * 2;
        }//yaha hume start and end ki range mil jayegi, fir normal BS laga denge

        // Binary search, jaise hi range m aa jaye toh normal binary search
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == k) {
                return mid;
            }
            else if (arr[mid] < k) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
