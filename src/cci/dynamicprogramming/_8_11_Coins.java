package cci.dynamicprogramming;

public class _8_11_Coins {

    /*
     * Coins: Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and pennies (1
     * cent), write code to calculate the number of ways of representing n cents.
     */

    public static void main(String[] args) {
        int[] coins = {25, 15, 5};
        System.out.println(combinations(40, coins));

        int[] coins2 = {20, 10};
        System.out.println(combinations(40, coins2));
    }

    public static int combinations(int amount, int[] coins) {
        // coins = sortDesc(coins);
        return combinations(amount, 0, coins);
    }

    private static int combinations(int amount, int max, int[] coins) {
        int ways = 0;

        if (amount == 0)
            return 1;

        for (int i = max; i < coins.length; i++)
            if (amount >= coins[i])
                ways += combinations(amount - coins[i], i, coins);

        return ways;
    }

}
