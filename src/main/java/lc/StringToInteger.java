package lc;

public class StringToInteger {

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi(" "));
        System.out.println(myAtoi("-"));
        System.out.println(myAtoi("asdf 32"));
        System.out.println(myAtoi("-91283472332"));
   }

    public static int myAtoi(String s) {
        int i = 0;
        int size = s.length();
        if (size == 0) {
            return 0;
        }

        while (size > i + 1 && s.charAt(i) == ' ') {
            i++;
        }

        boolean negative = false;
        char next = s.charAt(i);
        if (next == '-') {
            negative = true;
            i++;
        }
        if (next == '+') {
            i++;
        }

        int res = 0;
        while (size > i) {
            next = s.charAt(i);
            if (!(next >= '0' && next <= '9')) {
                break;
            }

            int digit = Character.getNumericValue(next);
            if (negative) {
                if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE / 10 && digit > 8))
                    return Integer.MIN_VALUE;
                res = (res * 10) - digit;
            } else {
                if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE / 10 && digit > 7))
                    return Integer.MAX_VALUE;
                res = (res * 10) + digit;
            }
            i++;
        }

        return res;
    }
}
