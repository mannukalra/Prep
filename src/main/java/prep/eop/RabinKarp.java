package prep.eop;

public class RabinKarp {

    // Returns the index of the first character of the substring if found , -1 otherwise.
    public static int rabinKarp(String t, String s){
        if(s.length() > t.length()){
            return -1;
        }

        final int BASE = 26;
        int power = 1; // BASE^|s|
        int tHash = 0, sHash = 0;
        for(int i = 0; i < s.length(); i++){
            power = i > 0 ? power * BASE : 1;
            tHash = tHash * BASE + t.charAt(i);
            sHash = sHash * BASE + s.charAt(i);
        }

        for (int i = s.length(); i < t.length(); i++){
            if(tHash == sHash && t.substring(i - s.length(), i).equals(s)){
                return i - s.length();
            }

            tHash -= t.charAt(i - s.length()) * power;
            tHash = tHash * BASE + t.charAt(i);
        }

        if(tHash == sHash && t.substring(t.length() - s.length()).equals(s)){
            return t.length() - s.length();
        }
        return -1; // s is not a substring of t.
    }

    public static void main(String[] args) {
        System.out.println(rabinKarp("abcxxyzs", "xyz"));
    }
}
