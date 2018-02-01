package Testing;

import java.util.Stack;

public class ValidString {

    private static final char curlyStart = '{';
    private static final char curlyEnd = '}';
    private static final char squareStart = '[';
    private static final char squareEnd = ']';
    private static final char roundStart = '(';
    private static final char roundEnd = ')';
    public static void main(final String[] args) {
        // TODO Auto-generated method stub
        final String input = "{}[]][([{({[]})}])";
        System.out.println(input + " : " + isValid(input));
    }

    private static boolean isValid(final String input) {
        if (input == null || input.isEmpty() || input.length()<2) {
            return false;
        }

        final Stack<Character> startTrack = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            final char currentChar = input.charAt(i);
            System.out.println("-->>> " + currentChar);
            if (currentChar == curlyStart || currentChar == squareStart || currentChar == roundStart) {
                startTrack.push(currentChar);
                continue;
            }

            System.out.println("-- " + startTrack);
            if (startTrack.isEmpty() || !goodPair(startTrack.peek(), currentChar)) {
                return false;
            }
            startTrack.pop();
        }
        return true;
    }

    private static boolean goodPair(final char first, final char second) {
        boolean res = false;
        if (first == curlyStart && second == curlyEnd) {
            res = true;
        } else if (first == roundStart && second == roundEnd) {
            res = true;
        } else if (first == squareStart && second == squareEnd) {
            res = true;
        }
        return res;
    }
}
