package prep.leet;

public class RmDup {
    static String getUniqueIP(String input){
        String result = "";
        for(int i = 0; i < input.length(); i++){
            int j;
            for(j = 0; j < i; j++){
                if(input.charAt(j) == input.charAt(i))
                    break;
            }
            if(i == j){
                result += input.charAt(i);
            }
        }
        return result;
    }


    static String getUnique(String input){
        String result = "";
        for(int i = 0; i < input.length(); i++){
            if(result.indexOf(input.charAt(i)) == -1)
                result += input.charAt(i);
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println(getUnique("abcaaadbf"));
        System.out.println(getUniqueIP("abcaaadbf"));
    }
}
