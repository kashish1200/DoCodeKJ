class Solution {
    public void quickSort(int[] arr, int l, int h) {
        if(l<h){
            int pivot = partition(arr, l, h);
            quickSort(arr, l, pivot-1);
            quickSort(arr, pivot+1, h);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low, j=high;
        while(i<j){
            while(i<=high && arr[i]<=pivot) i++;
            while(j>=low && arr[j]>pivot) j--;
            if(i<j){
               swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }
    public void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
} 
