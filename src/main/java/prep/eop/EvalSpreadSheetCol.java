package prep.eop;

public class EvalSpreadSheetCol {

    static int getColNum(String addr){
        int result = 0;

        for(int i = 0; i < addr.length(); i++){
            int curr = (int)addr.charAt(i) - 'A' + 1;
            int currWeight = ((addr.length() - i - 1)*26) * curr;
            result += currWeight == 0 ? curr : currWeight;
            System.out.println(curr+" " +result);
//            char curr = addr.charAt(i);
//            result = result * 26 + curr - 'A' + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getColNum("ZZ"));
    }
}
