package lc;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("II"));
        System.out.println(romanToInt("XII"));
        System.out.println(romanToInt("XXVII"));
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int sum = 0, i = 0;

        while (i < s.length() && s.charAt(i) == 'M') {
            sum += 1000;
            i++;
        }

        if (i < s.length() && s.charAt(i) == 'D') {
            sum += 500;
            i++;
        }

        while (i < s.length() && s.charAt(i) == 'C') {
            sum += 100;
            i++;

            if (i < s.length()) {
                if (s.charAt(i) == 'M') {
                    sum -= 2 * 100;
                    sum += 1000;
                    i++;
                } else if (s.charAt(i) == 'D') {
                    sum -= 2 * 100;
                    sum += 500;
                    i++;
                }
            }
        }

        if (i < s.length() && s.charAt(i) == 'L') {
            sum += 50;
            i++;
        }

        while (i < s.length() && s.charAt(i) == 'X') {
            sum += 10;
            i++;

            if (i < s.length()) {
                if (s.charAt(i) == 'L') {
                    sum -= 2 * 10;
                    sum += 50;
                    i++;
                } else if (s.charAt(i) == 'C') {
                    sum -= 2 * 10;
                    sum += 100;
                    i++;
                }
            }
        }

        if (i < s.length() && s.charAt(i) == 'V') {
            sum += 5;
            i++;
        }

        while (i < s.length() && s.charAt(i) == 'I') {
            sum += 1;
            i++;
            
            if (i < s.length()) {
                if (s.charAt(i) == 'V') {
                    sum -= 2 * 1;
                    sum += 5;
                    i++;
                } else if (s.charAt(i) == 'X') {
                    sum -= 2 * 1;
                    sum += 10;
                    i++;
                }
            }
        }

        return sum;
    }
}
