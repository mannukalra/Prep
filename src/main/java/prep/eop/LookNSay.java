package prep.eop;

import java.util.HashMap;
import java.util.Map;

public class LookNSay {

    public static String lookAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; ++i) {
            s = nextNumber(s);
            System.out.println(s);
        }
        return s;
    }
    private static String nextNumber(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            int count = 1 ;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                ++i ;
                ++count ;
                System.out.println("from while");
            }
            result.append(count);
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(lookAndSay(5));
    }
}
