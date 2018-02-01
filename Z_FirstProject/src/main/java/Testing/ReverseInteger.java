package Testing;

public class ReverseInteger {

    public static void main(final String args[]) {

        final int x = 56;
        System.out.println(x % 10);
        System.out.println(x / 10);
        final int y = 3;
        System.out.println(y % 10);
        System.out.println(y / 10);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        System.out.println(rev(-123400));
    }

    private static int rev(int input) {
        boolean neg = false;
        if (input < 0) {
            neg = true;
            input = -input;
        }
        int result = -1;

        while (input / 10 > 0) {
            System.out.println(input);
            final int rem = input % 10;
            input = input / 10;

            if (result < 0) {
                result = rem;
            } else {
                result = result * 10 + rem;
            }
        }
        result = result * 10 + input;
        return neg == true ? -result : result;
    }
}
