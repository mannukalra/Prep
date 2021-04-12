package prep.ctci;

public class DuplicateChars {

    static boolean hasDuplicate(String s){
        if(s.length() > 128)
            return false;

        boolean[] chars = new boolean[128];
        for(int i=0; i<s.length(); i++){
            int val = s.charAt(i);
            if(chars[val])
                return true;
            chars[val] = true;
        }
        return false;
    }

    static boolean hasDupNoArr(String str){

        if (str.length() > 26) { // Only 26 characters
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            System.out.println(val +" "+(1<<val)+" "+(val >> 1));
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
            System.out.println(checker);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasDuplicate("abdfa"));
        System.out.println(hasDupNoArr("aba"));
    }

}
