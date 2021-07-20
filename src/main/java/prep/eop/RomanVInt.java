package prep.eop;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RomanVInt {
    private final static Map<Character, Integer> T = new HashMap<>(){{
        put('I', 1);put('V', 5);put('X', 10);put('L', 50);put('C', 100);put('D', 500);put('M', 1000);
    }};

    static  int getInt(String roman){
        int len = roman.length();
        int sum = T.get(roman.charAt(len - 1));

        for(int i = len - 2 ; i >= 0 ; i--){
            if(T.get(roman.charAt(i)) < T.get(roman.charAt(i+1))){
                sum -= T.get(roman.charAt(i));
            }else{
                sum += T.get(roman.charAt(i));
            }
        }
        return sum;
    }

    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>(){{
        put(1000, "M"); put(900, "CM"); put(500, "D"); put(400, "CD"); put(100, "C"); put(90, "XC");
        put(50, "L"); put(40, "XL"); put(10, "X"); put(9, "IX"); put(5, "V"); put(4, "IV"); put(1, "I");
    }};

    static String getRomanRec(int input){
        int floorkey = map.floorKey(input);
        if(input == floorkey){
            return map.get(floorkey);
        }
        return map.get(floorkey) + getRomanRec(input - floorkey);
    }

    static String getRoman(int input){
        String result = "";
        for(int i = map.size() - 1; i >= 0 ; i --){
            int key = (int) map.keySet().toArray()[i];
            while(input >= key){
                input = input - key;
                result += map.get(key);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(getInt("CXII"));
        System.out.println(getRoman(2024));
    }

}
