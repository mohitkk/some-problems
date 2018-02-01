package Testing;

public class PalindromeCuts {

    public static void main(final String args[]) {
        final String input = "aabaacddedeffghhi";
        System.out.println("number of cuts: " + numberOfCuts(input));
    }

    private static int numberOfCuts(final String input) {
        if (input == null || input.equals("")) {
            return 0;
        }
        int startIndex = 0;
        int cuts = 0;
        while (startIndex < input.length()) {
            int maxSoFar = 0;
            for (int i = startIndex; i <= input.length(); i++) {
                final String temp = input.substring(startIndex, i);
                if (isPali(temp)) {
                    maxSoFar = Math.max(temp.length(), maxSoFar);
                }
            }
            if (maxSoFar > 0) {
                cuts++;
                startIndex = startIndex + maxSoFar;
            } else {
                startIndex++;
            }
        }
        return cuts - 1;
    }

    private static boolean isPali(final String input) {
        boolean res = false;
        if (input == "") {
            res = false;
        }
        if (input.length() == 1) {
            res = true;
        }
        if (input.length() % 2 == 0) {
            if (input.substring(0, input.length() / 2).equals(rev(input.substring(input.length() / 2)))) {
                res = true;
            }
        } else {
            final int cent = input.length() / 2;
            for (int i = 1; i <= (input.length() - 1) / 2; i++) {
                if ((input.charAt(cent - i) + "").equals((input.charAt(cent + i) + ""))) {
                    res = true;
                } else {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }



    private static String rev(String input) {
        final int right = input.length() - 1;
        for (int i = 0; i < input.length() / 2; i++) {
            final char s = input.charAt(i);
            final char e = input.charAt(right - i);
            input = input.substring(0, i) + e + input.substring(i + 1, right - i) + s + input.substring(right - i + 1);
        }
        return input;
    }

    // wrote this function but not used
    private static boolean isNotOutOfBounds(final int i, final int length) {
        if (i < 0) {
            return false;
        }
        if (i > length - 1) {
            return false;
        }
        return true;
    }

    // another reverse function which has not been used
    private static String rev_1(final String input) {
        if (input == "") {
            return input;
        }
        final int right = input.length() - 1;
        String le = "";
        String ri = "";
        for (int i = 0; i <= input.length() / 2; i++) {
            final char s = input.charAt(i);
            final char e = input.charAt(right - i);
            if (i < right - i) {
                ri = s + ri;
                le = le + e;
            } else if (i == right - i) {
                le = le + e;
            }
        }
        return le + ri;
    }
}
