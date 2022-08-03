class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Arrays.sort(nums);
        mergeSort(nums);
        return nums[nums.length - k];
    }
    
    private void mergeSort(int[] arr) {
        sort(arr, 0, arr.length-1);
    }
    
    private void sort(int[] arr, int lhs, int rhs) {
        if(lhs < rhs) {
            int mid = lhs + (rhs-lhs) / 2;
            sort(arr, lhs, mid);
            sort(arr, mid+1, rhs);
            merge(arr, lhs,mid,rhs);
        }
    }
    
    private void merge(int[] arr, int lhs, int mid, int rhs) {
        int len1 = mid - lhs + 1;
        int len2 = rhs - mid;
        int[] arrL = new int[len1];
        int[] arrR = new int[len2];
        
        for(int i = 0; i < len1; i++) 
            arrL[i] = arr[lhs+i];
        for(int i = 0; i < len2; i++) 
            arrR[i] = arr[mid+1+i];
        
        int i = 0, j = 0;
        int k = lhs;
        while(i < len1 && j < len2) {
            if(arrL[i] < arrR[j])
                arr[k++] = arrL[i++];
            else
                arr[k++] = arrR[j++];
        }
        while(i < len1)
            arr[k++] = arrL[i++];
        while(j < len2)
            arr[k++] = arrR[j++];
    }
}


// first solution:
// O(nlogn)
// use Arrays.sort or own mergesort to sort array
// take the kth element