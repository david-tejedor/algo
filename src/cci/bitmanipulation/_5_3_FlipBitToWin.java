package cci.bitmanipulation;

public class _5_3_FlipBitToWin {

    public static void main(String[] args) {
        System.out.println(flipWinner(1775));
    }

    static int flipWinner(int x) {
        int prev = 0;
        int current = 0;
        int max = 0;
        int i = 0;

        while (x > 0) {
            if ((x & 1) == 1) {
                prev++;
                current++;
            } else {
                if (prev > max)
                    max = prev;

                prev = current;
                current = 0;
            }

            x = x >>> 1;
            i++;
        }

        if (prev > max) {
            return prev + 1;
        }

        return max > 0 ? max + 1 : i;
    }

}
