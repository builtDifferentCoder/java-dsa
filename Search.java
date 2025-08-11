
public class Search{

    public int linearSearch(int[] arr,int target){
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target) return i;
        }
        return -1;
    }
    public int iterativeBinary(int arr[],int target){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]>target) right=mid-1;
            else if(arr[mid]<target) left=mid+1;
            else return  mid;
        }
        return -1;
    }
    public int recursiveBinary(int arr[],int target,int left,int right){
        int mid=(left+right)/2;
        if(arr[mid]==target){
            return mid;
        }
        else if(arr[mid]>target){
            return recursiveBinary(arr, target, left, mid-1);
        }else{
            return recursiveBinary(arr, target, mid+1, right);
        }
    }
}
