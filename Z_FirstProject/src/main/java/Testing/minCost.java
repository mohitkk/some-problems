package Testing;

import java.util.Arrays;

public class minCost {

    public static void main(final String args[]) {
        final int[] cost = { 0, 0, 1, 1 }; // 1
        // {1, 100, 1, 1, 1, 100, 1, 1, 100, 1} 6
        // [10, 15, 20] 15
        System.out.println(minCostClimbingStairs(cost));
    }

    private static int minCostClimbingStairs(final int[] cost) {

        final int[] memo = new int[cost.length];
        Arrays.fill(memo, Integer.MIN_VALUE);
        memo[0] = 0;
        memo[1] = 0;
        final int result = findMinimum(cost, memo, cost.length - 1);
        for (int i = 0; i < memo.length; i++) {
            System.out.println(memo[i]);
        }
        return result;
    }

    private static int findMinimum(final int[] cost, final int[] memo, final int pos) {
        System.out.println("pos: " + pos);
        if (pos == 0 || pos == 1) {
            return memo[pos];
        }
        if (memo[pos] != Integer.MIN_VALUE) {
            return memo[pos];
        }

        int costOneLeft = findMinimum(cost, memo, pos - 1);
        int costTwoLeft = findMinimum(cost, memo, pos - 2);
        costOneLeft = costOneLeft + cost[pos - 1];
        costTwoLeft = costTwoLeft + cost[pos - 2];
        memo[pos] = Math.min(costOneLeft + cost[pos - 1], costTwoLeft + cost[pos - 2]);
        return memo[pos];
    }
}
