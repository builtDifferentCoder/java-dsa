


public class Main{
    public static void main(String[] args){

        Sorting s=new Sorting();

        int arr[]={4,2,6,7,0,9,1};
        s.mergeSort(arr, 0, arr.length-1);
        for(int i:arr){
            System.out.println(i);
        }
    }
}