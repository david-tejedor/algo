package algos;

public class RabinKarp {

    public static void main(String[] args) {
        outputMatches("this is the text it is", "is");
    }

    /*
    * Hash(s) = (c_0 * b^(m-1) + c_1 * b^(m-2) + ... + c_m-1) MOD q
    *
    * ASCII a = 97, b = 98, r = 114
    * hash("abr") =  [ ( [ ( [  (97 × 256) % 101 + 98 ] % 101 ) × 256 ] %  101 ) + 114 ]   % 101   =  4
    * */

    // assume only lowercase letters -> 26 possibilities
    static void outputMatches(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int b = 257; // closer prime bigger than number of possible chars
        int q = 1000000009; // big primer number, but avoiding int overflow in multiplication

        int h = 1; // p^(m-1)
        for (int i = 0; i < m - 1; i++) {
            h = (h * b) % q;
        }

        int ph = 0;
        int th = 0;
        for (int i = 0; i < m; i++) {
            ph = (ph * b + (int) pattern.charAt(i)) % q;
            th = (th * b + (int) text.charAt(i)) % q;
        }

        for (int i = 0; i < n - m + 1; i++) {
            if (ph == th) {
                int j;
                for (j = 0; j < m; j++) {
                    if (pattern.charAt(j) != text.charAt(i + j)) {
                        break;
                    }
                }
                if (j == m) {
                    System.out.println(i);
                }
            }

            if (i < n - m) {
                th = ((th - (int) text.charAt(i) * h) * b + (int) text.charAt(i + m)) % q;
                if (th < 0)
                    th += q;
            }
        }
    }
}
