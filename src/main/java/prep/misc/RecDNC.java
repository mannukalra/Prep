package prep.misc;

import java.util.Arrays;

public class RecDNC {

    static int gcd(int a , int b){
        System.out.println(a +" "+ b);
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }
    static int sum(int[] arr){
        if(arr.length == 1)
            return arr[0];
        return arr[0] + sum(Arrays.copyOfRange(arr, 1, arr.length));
    }
    public static void main(String[] args) {
//        System.out.println(gcd(1680, 640));
        System.out.println(sum(new int[]{1,2,3,4,5}));

        System.out.println(Arrays.toString(Arrays.copyOf(new int[]{1,2,34,5,65}, 4)));
    }

}
