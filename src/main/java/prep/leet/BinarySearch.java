package prep.leet;

public class BinarySearch {

    static int binarySearch(int[] arr, int low, int high, int key){
        System.out.println(low+" "+high);
        if(high < low)
            return -1;

        int mid = (low + high)/2;
        if(key == arr[mid])
            return mid;
        if(key > arr[mid])
            return binarySearch(arr, mid + 1, high, key);
        return binarySearch(arr, low, mid - 1, key);
    }
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 3, 5, 7, 9, 12}, 0, 5, 3));
    }
}
