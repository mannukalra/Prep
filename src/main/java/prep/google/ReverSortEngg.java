package prep.google;

import java.util.Arrays;
import java.util.Scanner;

public class ReverSortEngg {

    static String genArrStr(int size, int cost){
        int[] arr = new int[size];
        for(int j = 0; j < size; j++){
            arr[j] = j+1;
        }
        return "ss";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for( int i=0 ; i < cases; i++){
            int arrSize = scanner.nextInt();
            int cost = scanner.nextInt();
            System.out.println("Case #"+(i+1)+": "+genArrStr(arrSize, cost));
        }
        System.out.println(genArrStr(2, 4));
    }
}
