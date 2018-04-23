package Testing;

public class LongestCommonSubArray {

    public static void main(final String args[]) {
        final int[] input1 = { 4, 6, 7, 1, 2, 6, 7, 3, 5, 2, 4 };
        final int[] input2 = { 1, 2, 6, 3, 5, 2, 4 };
        System.out.println(findMaxCommonCount(input1, input2));
    }

    private static int findMaxCommonCount(final int[] input1, final int[] input2) {
        int maxCommonLength = Integer.MIN_VALUE;

        for (int i = 0; i < input1.length; i++) {
            int common = 0;
            for (int j = 0; j < input2.length; j++) {
                if (input1[i] == input2[j]) {
                    common++;
                    int iPtr = i + 1;
                    int jPtr = j + 1;
                    boolean match = true;
                    while (match && iPtr < input1.length && jPtr < input2.length) {
                        match = false;
                        if (input1[iPtr] == input2[jPtr]) {
                            match = true;
                            common++;
                            iPtr++;
                            jPtr++;
                        }
                    }
                    j = jPtr;
                }
            }
            if (common > maxCommonLength) {
                maxCommonLength = common;
            }
        }

        return maxCommonLength;
    }
}
