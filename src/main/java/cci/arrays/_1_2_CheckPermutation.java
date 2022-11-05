package cci.arrays;

import java.util.HashMap;
import java.util.Map;

public class _1_2_CheckPermutation {

    // Given two strings,write a method to decide if one is a permutation of the other.
    // Hints: #7, #84, #722, #737

    public static void main(String[] args) {
        System.out.println(isPermutation("abcdd", "dcbad"));
        System.out.println(isPermutation("abcdd", "dcbaddd"));
        System.out.println(isPermutation("abc", "dcb"));
        System.out.println(isPermutation("abc", "bca"));
        System.out.println(isPermutation("", ""));
    }

    static boolean isPermutation(String a, String b) {
        if (a.length() != b.length()) return false;
        Map<Character, Integer> existingChars = getCharsCount(a);
        existingChars = removeCharsIn(b, existingChars);
        return existingChars.isEmpty();
    }

    private static  Map<Character, Integer> getCharsCount(String a) {
        Map<Character, Integer> existingChars = new HashMap();
        for (int i = 0; i < a.length(); i++) {
            if (existingChars.containsKey(a.charAt(i))) {
                existingChars.put(a.charAt(i), existingChars.get(a.charAt(i)) + 1);
            } else {
                existingChars.put(a.charAt(i), 1);
            }
        }

        return existingChars;
    }

    private static Map<Character, Integer> removeCharsIn(String b, Map<Character, Integer> existingChars) {
        for (int i = 0; i < b.length(); i++) {
            if (existingChars.containsKey(b.charAt(i))) {
                if (existingChars.get(b.charAt(i)) > 1) {
                    existingChars.put(b.charAt(i), existingChars.get(b.charAt(i)) - 1);
                } else {
                    existingChars.remove(b.charAt(i));
                }
            } else {
                return existingChars;
            }
        }

        return existingChars;
    }

}
