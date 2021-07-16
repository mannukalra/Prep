package prep.misc;

import java.util.*;

public class Test {

    static int countBits(int num){
        int count = 0;
        while(num != 0){
            count += (num & 1);
            num = num >>> 1;
//            System.out.println(num);
        }
        return count;
    }
    public static short parity(long x){
        short result = 0;
        while (x != 0) {
            result ^= 1;//(x & 1);
            System.out.println(result);
            x &= (x-1);
        }
        return result;
    }

    //TODO
    static void removeDup(int[] arr){ //arr is sorted [1,2,2,3,4,4,5,6,7] > 123456
        int writeIndex = 1;
        for(int i = 1 ; i < arr.length; i++){
            if(arr[writeIndex-1] != arr[i]){
                arr[writeIndex++] = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static int maxProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for(int d : prices){
            minPrice = Math.min(minPrice, d);
            maxProfit = Math.max(d - minPrice, maxProfit);
            System.out.println(minPrice+" "+maxProfit);
        }
        return maxProfit;
    }

    public static List<Integer> generatePrimes(int n){
        final int size = (int)Math.floor(0.5 * (n - 3)) + 1;
        System.out.println("size "+size);
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        // isPrime.get(i) represents whether (2i + 3) is prime or not.
        // Initially, set each to true. Then use sieving to eliminate nonprimes.
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(size , true));
        for (int i = 0; i < size; ++i) {
            if (isPrime.get(i)) {
                int p = ((i * 2) + 3);
                System.out.println(p);
                primes.add(p);
                // Sieving from pA2, whose value is (4iA2 + 12i + 9). The index of this
                // value in isPrime is (2iA2 + 6i + 3) because isPrime.get(i) represents
                // 2i + 3.
                //
                // Note that we need to use long type for j because p^2 might overflow .
                for (long j = ((i * i) * 2) + 6 * i + 3; j < size; j += p) {
                    System.out.println("j = "+j);
                    isPrime.set((int) j, false);
                }
            }
        }
        System.out.println(primes);
        return primes;
    }

    static void printAnagrams(String input, String result){
        if(input.length() == 0){
            System.out.println(result);
            return;
        }
        for(int i =0; i < input.length(); i++){
            char ch = input.charAt(i);
            // rest of string
            String ros = input.substring(0, i) + input.substring(i+1);
            printAnagrams(ros, result + ch); //abc ""   bc a   c ab  "" abc    b ac  "" acb   ac b   bac  bca ab c cab cba
        }
    }

    static void applyPermutation(List<Integer> perm, List<String> items){ //[2 0 1 3] [a b c d] => [b c a d]
        for(int i = 0 ; i < perm.size(); i++){
            int curr = perm.get(i); //2
            String currStr = items.get(i);//a

            while(curr >= 0) {
                int temp = perm.get(curr);
                currStr = items.set(curr, currStr); // 2 a - c
                perm.set(curr, curr - perm.size());
                curr = temp;
            }

        }
        System.out.println(perm);
        System.out.println(items);
    }

    public static void randomsampling(int k, List<Integer> A) {
        Random gen = new Random ();
        for (int i = 0; i < k; ++i) {
            // Generate a random int in [i, A.size() - 1].
            Collections.swap (A , i, i + gen.nextInt(A.size() - i));
        }
    }

    public static int nonuniformRandomNumberGeneration(
        List<Integer> values, List<Double> probabilities) {
        List<Double> outcomeInterval = new ArrayList <>() ;
        outcomeInterval.add(0.0) ;
        // Creating the endpoints for the intervals corresponding to the probabilities.
        for (double p : probabilities) {
            outcomeInterval.add(outcomeInterval.get(outcomeInterval.size() - 1)+ p) ;
        }
        System.out.println(probabilities+" "+outcomeInterval); //prefixSumOfProbabilities- [0.0, 0.5, 0.8333333333333333, 0.9444444444444444, 1.0]
        Random r = new Random () ;
        // Get a random number in [SI .SI , 1 .SI) .
        final double uniformol = r.nextDouble();
        // Find the index of the interval that uniformSIl lies in.
        int it = Collections.binarySearch(outcomeInterval , uniformol);
        System.out.println(uniformol+"  "+it);
        if (it < 0) {
            final int intervalldx = (Math.abs(it) - 1) - 1;
            return values.get( intervalldx) ;
        } else {
            return values.get(it) ;
        }
    }

    static void mergeSortedArrays(int[] a, int[] b){
        int[] result = new int[a.length + b.length];

        for(int i = 0, j = 0; i < result.length; i++) {
            if(i < a.length)
                result[i] = a[i];
            else
                result[i] = b[j++];
        }
        System.out.println(Arrays.toString(result));
        int writeIndex = 0;
//        for(int i = 1 ; i < result.length; i++){
//            if(result[writeIndex] > result[i])
//        }
    }

    public static void main(String[] args) {
//        System.out.println(countBits(11));
//        System.out.println(parity(101));
//        removeDup(new int[]{2,3,5,5,7,11,11,11,13});
//        System.out.println(maxProfit(new int[]{310,315, 275, 295, 260, 270, 290, 230, 255, 250}));
//        generatePrimes(10);
//        printAnagrams("abc", "");
//        System.out.println(">>>"+"abc".substring(3)+"<<<<");

//        List<String> items = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
//        List<Integer> perms = new ArrayList<>(Arrays.asList(3,2,1,0));
//        applyPermutation(perms, items);
//        for(int i = 0; i < 1; i++)
//            System.out.println(nonuniformRandomNumberGeneration(Arrays.asList(3,5,7,11), Arrays.asList(1.0/2, 1.0/3, 1.0/9, 1.0/18)));
//        removeDup(new int[]{1,2,2,3,4,4,5,6,7});

        mergeSortedArrays(new int[]{1,2,4,6,7}, new int[]{3,4,6,11,12});
    }
}
