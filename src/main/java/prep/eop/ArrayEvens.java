package prep.eop;

import java.util.Arrays;

public class ArrayEvens {

    static void orderEvensFirst(int[] a){
        int curr = 0, next = a.length -1;

        while (curr < next) {
            if (a[curr] % 2 == 0){
                curr++;
            }else{
                while (a[next] % 2 != 0)
                    next--;
                if(curr < next) {
                    int temp = a[curr];
                    a[curr] = a[next];
                    a[next] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        orderEvensFirst(new int[]{6,2,2,4,1,12,6});
    }
}
