package lc;

import java.util.ArrayList;
import java.util.List;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(Integer.MIN_VALUE));
        System.out.println(reverse(Integer.MAX_VALUE)); // 0
        System.out.println(reverse(123)); // 321
        System.out.println(reverse(-123)); // -321
        System.out.println(reverse(11123)); // 32111
        System.out.println(reverse(2147483647)); // 0
        System.out.println(reverse(1563847412)); // 0
        System.out.println(reverse(1363847412));
        System.out.println(reverse(-1363847412));
        System.out.println(reverse(0));
        System.out.println(reverse(1));

    }

    public static int reverse(int x) {
        boolean negative = x < 0;
        long input = Math.abs((long) x);

        List<Integer> digits = new ArrayList<>();
        do {
            int digit = (int) (input % (long) 10);
            input = (input / (long) 10);
            digits.add(digit);
        } while (input > 0);

        double reversed = 0;
        int size = digits.size();
        for (int i = 0; i < size; i++) {
            reversed += digits.get(i) * Math.pow(10, size - (i + 1));
            if (negative) {
                if (-reversed < Integer.MIN_VALUE)
                    return 0;
            }
            if (reversed > Integer.MAX_VALUE)
                return 0;
        }

        return (int) (negative ? -reversed : reversed);
    }

    public int reverse_optimal(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = (rev * 10) + pop;
        }
        return rev;
    }
}
