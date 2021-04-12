package prep.google;

import java.util.Map;
import java.util.Scanner;

public class MoonNUmbs {

    static long evalCost(String pattern, Map<String, Integer> patternCosts) {
        long cost = 0;
        for (String key : patternCosts.keySet()) {
            long currcost = patternCosts.get(key);
            int lastIndex = 0;
            while (lastIndex != -1) {
                lastIndex = pattern.indexOf(key, lastIndex);
                if(lastIndex >= 0){
                    cost += currcost;
                    lastIndex += key.length();
                }
            }
        }
        return cost;
    }

    static String replacePattern(String pattern, int startIndex){
        // CJCC????J
        Character beforeChar = null;
        Character afterChar = null;
        if(startIndex > 0)
            beforeChar = pattern.charAt(startIndex-1);

        int nextC = pattern.indexOf('C', startIndex);
        int nextJ = pattern.indexOf('J', startIndex);
        Character replacement = null;
        int nextIndex = 0;
        if(nextC < 0 && nextJ < 0){
            return pattern.replace('?', beforeChar != null ? beforeChar : 'C');
        }else {
            nextIndex = nextJ < 0 ? nextC : nextC < 0 ? nextJ : nextC < nextJ ? nextC : nextJ;
            replacement = beforeChar != null ? beforeChar : nextIndex == nextC ? 'C' : 'J';
            String substr = pattern.substring(startIndex, nextIndex);
            pattern = pattern.substring(0, startIndex) + substr.replace('?', replacement) + pattern.substring(nextIndex, pattern.length());
        }
        return pattern;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for( int i=0 ; i < cases; i++){
            int x = scanner.nextInt();//CJ
            int y = scanner.nextInt();//JC
            String pattern = scanner.nextLine().trim();
            long cost = 0;
            Map<String, Integer> costs = Map.of("CJ", x, "JC", y);
            int startIndex = pattern.indexOf('?');
            while(startIndex >= 0){
                pattern = replacePattern(pattern, startIndex);
                startIndex = pattern.indexOf('?', startIndex);
            }
            System.out.println("Case #"+(i+1)+": "+evalCost(pattern, costs));
        }
    }
}
