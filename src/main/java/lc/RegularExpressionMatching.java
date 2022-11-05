//package problems;
//
//public class RegularExpressionMatching {
//
//    public static void main(String[] args) {
//        System.out.println(isMatch("aa", "a"));
//        System.out.println(isMatch("aa", "a*"));
//        System.out.println(isMatch("ab", ".*"));
//        System.out.println(isMatch("bbaab", "b.*b"));
//        System.out.println(isMatch("ab", "b*"));
//        System.out.println(isMatch("ab", "ab*"));
//        System.out.println(isMatch("abaac", "ab*"));
//        System.out.println(isMatch("abaac", "ab*baac"));
//        System.out.println(isMatch("abbbbaac", "ab*bbaac"));
//        System.out.println(isMatch("abbbbaac", ""));
//    }
//
//    public static boolean isMatch(String s, String p) {
//        int si = s.length() - 1;
//        for (int pi = p.length() - 1; pi >= 0; pi--) {
//            char pc = p.charAt(pi);
//            char sc = s.charAt(si);
//            if (pc == '*') {
//                char prev = p.charAt(pi - 1);
//                while (d)
//            }
//
//            if (pc != '.' && pc != sc) {
//                return false;
//            }
//        }
//
//        if (p.length() == 0 && s.length() != 0)
//            return false;
//
//        return true;
//    }
//}
