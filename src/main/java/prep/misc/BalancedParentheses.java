package prep.misc;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedParentheses {

    static boolean isClosure(char c1, char c2){
        if(c1 == '(' && c2 == ')' || c1 == '[' && c2 == ']' || c1 == '{' && c2 == '}' )
            return true;

        return false;
    }

    static boolean isValid(String s){
        List<Character> openingList = Arrays.asList('(', '{', '[');
        List<Character> closingList = Arrays.asList(')', '}', ']');

        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()){
            if(openingList.contains(c)) {
                stack.push(c);
            }else if(closingList.contains(c)) {
                if(isClosure(stack.peek(), c))
                    stack.pop();
                else
                    return false;
            }else{
                //do nothing
            }
        }

        return stack.size() == 0;
    }


    public static void main(String[] args) {
        System.out.println(isValid("([][{{}}])"));
        System.out.println(Math.pow(2, 3));

        System.out.print((int)'{'+" {} "); System.out.println((int)'}');
        System.out.print((int)'<'+" <> "); System.out.println((int)'>');
        System.out.print((int)'('+" () ");System.out.println((int)')');
        System.out.print((int)'['+" {} ");System.out.println((int)']');
    }
}
