package lc;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int original = x;
        int reverse = 0;

        while (x > 0) {
            int push = x % 10;

            if (reverse > Integer.MAX_VALUE / 10 ||
                    (reverse == Integer.MAX_VALUE / 10 && push > 7))
                return false;

            x = x / 10;
            reverse = (reverse * 10) + (push);
        }

        return original == reverse;
    }
}
