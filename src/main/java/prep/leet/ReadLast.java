package prep.leet;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Stream;

public class ReadLast {
    static class testHash{
        int i;
        String s;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            testHash testHash = (testHash) o;
            return i == testHash.i && Objects.equals(s, testHash.s);
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, s);
        }
    }
    static int recSum(int[] arr, int startIndex){
        if(arr.length == startIndex + 1){
            return arr[startIndex];
        }
        return arr[startIndex] + recSum(arr, startIndex+1);
    }

    static int recLen(int[] arr, int len){
        if(arr.length == len){
            return len;
        }
        return recLen(arr, len+1);
    }

    static int recMax(int[] arr, int index, int max){
        if(arr[index] > max)
            max = arr[index];

        if(arr.length == index + 1)
            return max;
        return recMax(arr, index+1, max);
    }

    static int recMax2(int[] arr, int index){
        if(arr.length == index + 2)
            return arr[index] > arr[index + 1] ? arr[index] : arr[index + 1];

        int subMax = recMax2(arr, index+1);
        return arr[index] > subMax ? arr[index] : subMax;
    }

    static int recBinS(int[] arr, int val, int startI, int endI){
        int mid = (startI+endI)/2;
        if(startI > endI)
            return -1;
        if(arr[mid] == val){
            return mid;
        }else if(arr[mid] > val){
            return recBinS(arr, val, startI, mid-1);
        }else{
            return recBinS(arr, val, mid+1, endI);
        }
    }

    public static void main2(String[] args) {
        try{
            RandomAccessFile file = new RandomAccessFile("C:\\Users\\kalra_m\\OneDrive - HCL Technologies Ltd\\Documents\\monitors++\\data.txt", "r");
            System.out.println(file.length());
            file.seek(file.length() - 2640);
            byte[] bytes = new byte[2640];
            file.read(bytes);
            System.out.println(new String(bytes));
            file.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    static Integer[] filter(Integer[] arr, int pivot, boolean smaller){
        String vals = "";
        int elems = 0;
        for(int i : arr){
            if(smaller){
                if(i < pivot) {
                    vals = vals.length() > 0 ? vals + "," + i : vals + i;
                    elems += 1;
                }
            }else if(i > pivot){
                vals= vals.length() > 0 ? vals+","+i : vals+i;
                elems += 1;
            }
        }
        if(elems > 0) {
            String[] valss = vals.split(",");
            Integer[] result = new Integer[valss.length];
            for (int i = 0; i < valss.length; i++)
                result[i] = Integer.parseInt(valss[i]);
            return result;
        }

        return new Integer[]{};
    }

    static Integer[] quickSort(Integer[] arr){
        if(arr.length < 2) {
            return arr;
        }else{
            int pivot = arr[0];
            Integer[] less = filter(arr, pivot, true);
            Integer[] gtr = filter(arr, pivot, false);


            return Stream.of(quickSort(less), new Integer[]{pivot}, quickSort(gtr)).
                    flatMap(Stream::of).toArray(Integer[]::new);
        }
    }

    static long nextLowerNumber(long x)
    {
        long y=1;
        while(x>1)
        {
            x/=2;
            y*=2;
        }
        return y;
    }
    static long makeItOne(long N){
        long moves = 0;
        while(N >1){
            moves+=1;
            long x=nextLowerNumber(N);
            if(x==N)
                N/=2;
            else
                N-=x;
        }
        return moves;
    }

    public static void main(String[] args) {
//        System.out.println(recSum(new int[]{1,2,4,6,7}, 0));
//        System.out.println(recLen(new int[]{1,2,4,6,7}, 0));
//        System.out.println(recMax2(new int[]{1,22, 2,43,6,7,88}, 0));
//        int[] arr = new int[]{1,2,12,14,66,77};
//        System.out.println(recBinS(arr, 77, 0, arr.length));

//        System.out.println(Arrays.asList(quickSort(new Integer[]{22,12,29,90,66,42,19})));
//        System.out.println(makeItOne(24));

        int cap = 0;
        Map<String, Integer> map = new HashMap();
        for(int i = 1; i<= 97; i++) {
            map.put("s"+i, i);
            try {
                Field tableField = HashMap.class.getDeclaredField("table");
                tableField.setAccessible(true);
                Object[] table = (Object[]) tableField.get(map);
                int len = table == null ? 0 : table.length;
                if(len != cap){
                    System.out.println(len);
                    cap = len;
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }

        }

    }
}
