

public class Sorting {
    
    private void swap(int arr[],int index1,int index2){
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }
    private int partition(int[] arr,int low,int high){
        int i=low-1;
        int pivot=arr[high];
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        return i+1; 
    }
    public int[] bubbleSort(int arr[]){

        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(arr[i]>arr[j]) swap(arr,i,j);
            }
        }
        return arr;
    }
    public int[] selectionSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            if(min!=i){
                swap(arr,i,min);
            }
        }

        return arr;
    }
    public int[] insertionSort(int arr[]){
        int val,i,j;
        for(i=1;i<arr.length;i++){
            val=arr[i];
            for(j=i-1;j>=0&&arr[j]>val;j--){
                arr[j+1]=arr[j];
            }
            arr[j+1]=val;
        }
        return arr;
    }
    public void quickSort(int[] arr,int low,int high){

        if(low<high){
            int p=partition(arr, low, high);
            quickSort(arr, low, p-1);
            quickSort(arr, p+1, high);
        }
    }
    public void merge(int[] arr, int l, int mid, int r) {
   // Create temporary arrays for left and right subarrays
   int[] leftArr = new int[mid - l + 1];
   int[] rightArr = new int[r - mid];
   
   // Copy data to temporary arrays
   for (int i = 0; i < leftArr.length; i++) {
       leftArr[i] = arr[l + i];
   }
   for (int j = 0; j < rightArr.length; j++) {
       rightArr[j] = arr[mid + 1 + j];
   }
   
   // Merge the temp arrays back into arr[l..r]
   int i = 0, j = 0, k = l;
   
   // Compare elements and merge in sorted order
   while (i < leftArr.length && j < rightArr.length) {
       if (leftArr[i] <= rightArr[j]) {
           arr[k] = leftArr[i];
           i++;
       } else {
           arr[k] = rightArr[j];
           j++;
       }
       k++;
   }
   
   // Copy remaining elements of leftArr (if any)
   while (i < leftArr.length) {
       arr[k] = leftArr[i];
       i++;
       k++;
   }
   
   // Copy remaining elements of rightArr (if any)
   while (j < rightArr.length) {
       arr[k] = rightArr[j];
       j++;
       k++;
   }
}
    public void mergeSort(int[]arr, int l,int r){
        
        if(l<r){
            int mid=(l+r)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr,l,mid,r);
        }
    }
}
