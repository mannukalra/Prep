package prep.eop;

import java.util.ArrayList;
import java.util.List;

public class ValidIP {

    static List<String> evalValidIps(String ip){
        List<String> result = new ArrayList<>();

        for(int i = 1; i < 4 && i < ip.length(); i++){
            final String first = ip.substring(0, i);
            if(isValidPart(first)) {
                for (int j = 1; i + j < ip.length() && j < 4; ++j ) {
                    final String second = ip.substring( i , i + j);
                    if ( isValidPart(second) ) {
                        for (int k = 1; i + j + k < ip.length() && k < 4 ; ++k) {
                            final String third = ip.substring ( i + j, i + j + k) ;
                            final String fourth = ip.substring( i + j + k) ;
                            if ( isValidPart (third) && isValidPart( fourth ) ) {
                                result.add(first +"."+ second +"."+ third +"."+ fourth);
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    static boolean isValidPart(String s){
        if(s.length() > 3){
            return false;
        }
        if(s.startsWith("0") && s.length() > 1){
            return false;
        }
        int intVal = Integer.parseInt(s);
        return intVal >= 0 && intVal <= 255;
    }
    public static void main(String[] args) {

    }
}
