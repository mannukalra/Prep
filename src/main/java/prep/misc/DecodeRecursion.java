package prep.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jit on 4/8/18.
 */
public class DecodeRecursion {

    private Map map = null;
    private static final String sequence = ".__..__._..._";
    //Check - ANEQV - .__..__._..._
//    encoding for English chars is below key in map.put(combination of _ & . (underscore and dot)).
//    for any given input string it should decode and print all possible combinations example:
//    given sequence .__..__._..._ output should be ADGBT  ADGDA  .... ADGNEET ..... WUTLET ... WUTRIT  WUTRU

    private static void initializeMap(DecodeRecursion decodeRecursion){
        Map map = new HashMap<String, String>();

        map.put("._","A");
        map.put("_...","B");
        map.put("_._.","C");
        map.put("_..","D");
        map.put(".","E");
        map.put(".._.","F");
        map.put("__.","G");
        map.put("....","H");
        map.put("..","I");
        map.put(".___","J");
        map.put("_._","K");
        map.put("._..","L");
        map.put("__","M");
        map.put("_.","N");
        map.put("___","O");
        map.put(".__.","P");
        map.put("__._","Q");
        map.put("._.","R");
        map.put("...","S");
        map.put("_","T");
        map.put(".._","U");
        map.put("..._","V");
        map.put(".__","W");
        map.put("_.._","X");
        map.put("_.__","Y");
        map.put("__..","Z");

        decodeRecursion.map = map;

    }

    public static void main ( String args[]){
        DecodeRecursion decodeRecursion = new DecodeRecursion();
        initializeMap(decodeRecursion);
        Map map = decodeRecursion.map;
        decodeRecursion.decodeSequence(sequence, 0, "");

    }

    void decodeSequence(String seq, int currPositon, String decodedString){

        if(currPositon >= seq.length()){
            System.out.println(decodedString);
            return;
        }
        for( int i=1; i<=4; i++) {
            if(currPositon+i > seq.length()){
                return;
            }
            String substring = seq.substring(currPositon,currPositon+i);
            if( map.containsKey(substring)){
                decodeSequence(seq, currPositon+i, decodedString.concat((String)map.get(substring)));
            }
        }
        return;
    }
}