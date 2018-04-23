package general;

import java.util.HashSet;
import java.util.Set;

public class MatrixRotation {

    public static void main(String args[]) {
        int[][] input = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };// , { 13, 14, 15, 16 } };
        print(input);
        input = transpose(input);
        print(input);
        reverse(input, Rotation.clockwise);
        print(input);
        System.out.println("-------------------------");
        input = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };// , { 13, 14, 15, 16 } };
        print(input);
        input = transpose(input);
        print(input);
        reverse(input, Rotation.anticlockwise);
        print(input);
        // reverse(input, Rotation.anticlockwise);
        // print(input);
        // input = transpose(input);
        // print(input);
        System.out.println("-------------------------");

        Set<String> st = new HashSet<String>();
        String s1 = new String("Hello");
        st.add(s1);
        String s2 = new String("Hello");
        st.add(s2);
        System.out.println(st);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }

    private static void print(int[][] input) {
        int rows = input.length;
        int cols = input[0].length;

        System.out.println();
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] transpose(int[][] input) {
        int rows = input.length;
        int cols = input[0].length;
        if (rows == cols) {
            for (int row = 0; row < rows; row++) {
                for (int col = row; col < cols; col++) {
                    int temp = input[row][col];
                    input[row][col] = input[col][row];
                    input[col][row] = temp;
                }
            }
            return input;
        } else {
            int[][] output = new int[cols][rows];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    output[j][i] = input[i][j];
                }
            }
            return output;
        }
    }

    private static void reverse(int[][] input, Rotation r) {
        int rows = input.length;
        int cols = input[0].length;

        if (r == Rotation.clockwise) {
            for (int row = 0; row < rows; row++) {
                int colend = cols - 1;
                for (int col = 0; col < colend; col++) {
                    int temp = input[row][col];
                    input[row][col] = input[row][colend];
                    input[row][colend] = temp;
                    colend--;
                }
            }
        } else if (r == Rotation.anticlockwise) {
            for (int col = 0; col < cols; col++) {
                int rowend = rows - 1;
                for (int row = 0; row < rowend; row++) {
                    int temp = input[row][col];
                    input[row][col] = input[rowend][col];
                    input[rowend][col] = temp;
                    rowend--;
                }
            }
        } else {
            throw new RuntimeException("Unknown rotation requested.");
        }
        // } else {
        // int [] [] output = new input[cols][rows];
        // }
    }

    private enum Rotation {
        clockwise, anticlockwise;
    }
}
