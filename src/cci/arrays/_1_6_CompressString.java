package cci.arrays;

public class _1_6_CompressString {

    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
        System.out.println(compress("abcdef"));
        System.out.println(compress(""));
        System.out.println(compress("a"));
    }

    static String compress(String s) {
        boolean shouldCompress = false;
        StringBuilder compressed = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count == 0) {
                compressed.append(c);
            }
            count++;
            if (i == s.length() - 1 || s.charAt(i + 1) != c) {
                compressed.append(count);
                shouldCompress = shouldCompress || count > 1;
                count = 0;
            }
        }

        return shouldCompress ? compressed.toString() : s;
    }
}
