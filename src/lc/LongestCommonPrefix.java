package lc;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flowing"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar",""}));
        System.out.println(longestCommonPrefix(new String[]{"","racecar","asdf"}));
        System.out.println(longestCommonPrefix(new String[]{"allofthem","allofthem","allofthem"}));
        System.out.println(longestCommonPrefix(new String[]{"1","2","3"}));
    }

    public static String longestCommonPrefix1(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        String first = strs[0];
        if (first.length() == 0) {
            return "";
        }

        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != c) {
                    return prefix.toString();
                }
            }
            prefix.append(c);
        }

        return prefix.toString();
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs[0].length() == 0) return "";

        return lcp(strs, 0, strs[0].length());
    }

    private static String lcp(String[] strs, int start, int end) {
        if (start == end) {
            return "";
        }

        if (match(strs, start, end)) {
            return strs[0].substring(start, end);
        }

        if (end - start == 1) {
            return "";
        }

        int mid = (end - start + 1) / 2;

        if (match(strs, start, start + mid)) {
            return strs[0].substring(start, start + mid) + lcp(strs, start + mid, end);
        }

        return lcp(strs, start, start + mid);
    }

    private static boolean match(String[] strs, int start, int end) {
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < end ||
                    !strs[i].substring(start, end).equals(strs[0].substring(start, end)))
                return false;
        }

        return true;
    }
}
