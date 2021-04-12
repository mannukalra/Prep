package prep.google;


import java.util.Scanner;

public class ReverSortC {
    static void print(int[] arr){
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }


    static int reverSort(int[] arr){
        int result = 0;
        for(int i = 0; i < arr.length - 1; i++){
            int j = i;
            int minVal = arr[i];
            int k = i + 1;
            while(k < arr.length){
                if (minVal > arr[k]) {
                    minVal = arr[k];
                    j = k;
                }
                k++;
            }
//            int[] target = Arrays.copyOfRange(arr, i, j+1);
//            Arrays.sort(target);
//            System.arraycopy(target, 0, arr, i, j-i+1 );

            for(int l = i, m = j; l <= m; l++, m--) {
                int temp = arr[l];
                arr[l] = arr[m];
                arr[m] = temp;
            }
            result = result + j-i + 1;
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for( int i=1 ; i <= cases; i++){
            int inputSize = scanner.nextInt();
            int[] arr = new int[inputSize];
            for(int j = 0; j < inputSize; j++){
                arr[j] = scanner.nextInt();
            }
            System.out.println("Case #"+i+": "+reverSort(arr));
        }
//        System.out.println(reverSort(new int[]{5,2,4,1,3}));
    }
}
