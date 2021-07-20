package prep.eop;

public class SynosoidStr {
    public static String snakeString (String s) {
        StringBuilder result = new StringBuilder();
        // Outputs the first row, i.e., s[l], s[5], s[9], ...
        for (int i = 1; i < s.length(); i += 4) {
            result.append(s.charAt(i));
        }
        // Outputs the second row, i.e., s[<9], s[2], s[4], ...
        for (int i = 0; i < s.length(); i += 2) {
            result.append(s.charAt(i));
        }
        // Outputs the third row, i.e., s[3], s[7], s[ll], ...
        for (int i = 3; i < s.length(); i += 4) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = snakeString("hello world, can you read this!");
        s = s.replace(" ", "-");
        System.out.println(s);
        for(int i = 0; i <  s.length(); i++){
            if(i == 0) {
                System.out.print(" " + s.charAt(i));
                continue;
            }
            if(i < s.length()/4){
                System.out.print("   " + s.charAt(i));
                if(i + 1 >= s.length()/4) {
                    System.out.println();
                }
            }else if(i >= 3 * (s.length()/4)) {
                System.out.print("   " + s.charAt(i));
            }else{
                if(i == s.length()/4){
                    System.out.print(s.charAt(i));
                }else{
                    System.out.print(" "+s.charAt(i));
                }
                if(i+1 >= 3 * (s.length()/4))
                    System.out.println();
            }
        }
    }
}
