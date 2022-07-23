package lc;

public class ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(convert("ABC", 1));
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("ABCD", 2));
        System.out.println(convert("A", 1));
        System.out.println(convert("A", 2));
    }

    public static String convert(String s, int numRows) {
        int size = s.length();
        if (numRows > 1 && size > numRows) {
            StringBuffer sol = new StringBuffer();
            for (int row = 0; row < numRows; row++) {
                int pos = row;
                int gap = numRows - 2 - row;
                do {
                    sol.append(s.charAt(pos));
                    int nextCol = pos + (2 * numRows) - 2;
                    int nextPosWithinCol = pos + 2 * (gap + 1);
                    if (gap > -1 && nextPosWithinCol < nextCol && nextPosWithinCol < size) {
                        sol.append(s.charAt(nextPosWithinCol));
                    }
                    pos = nextCol;
                } while (pos < size);
            }
            return sol.toString();
        }
        return s;
    }
}
