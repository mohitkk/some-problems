package Testing;

public class ThirdMaximum {

    public static void main(final String args[]) {
        final int[] input = { 2, 2, 2, 4, 2 };
        System.out.println(thirdMax(input));
    }

    private static int thirdMax(final int[] input) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;

        for (int i = 0; i < input.length; i++) {
            final int athand = input[i];
            if (athand > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = athand;
            } else if (athand == max) {

            } else if (athand > secondMax) {
                thirdMax = secondMax;
                secondMax = athand;
            } else if (athand == secondMax) {

            } else if (athand > thirdMax) {
                thirdMax = athand;
            }
        }

        return thirdMax == Integer.MIN_VALUE ? max : thirdMax;
    }
}
