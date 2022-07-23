package lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LongestPalindromic {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("gaccac"));
        System.out.println(longestPalindrome("aacabdkacaa"));
        System.out.println(longestPalindrome("hgfedcbaabcdefgh"));
        System.out.println(longestPalindrome("abbcbbaefghijlanana"));
        System.out.println(longestPalindrome("babaddaba"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ab"));
    }

    public static String longestPalindrome(String s) {
        Map<Character, List<Integer>> charToIndex = new HashMap<>();
        String currentLongestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Optional<List<Integer>> indices = Optional.ofNullable(charToIndex.get(c));
            if (indices.isPresent()) {
                indices.get().add(i);
            } else {
                List<Integer> newCharIndices = new ArrayList<>();
                newCharIndices.add(i);
                charToIndex.put(c, newCharIndices);
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            List<Integer> charIndices = charToIndex.get(c);
            if (charIndices != null) {
                sameCharLoop:
                for (Integer charIndex : charIndices) {
                    int possiblePalindromeLength = i - charIndex + 1;
                    if (possiblePalindromeLength > currentLongestPalindrome.length()) {
                        int j = 0;
                        boolean palindromeComplete;
                        boolean correctPos;
                        do {
                            int init = charIndex + j;
                            int end = i - j;
                            palindromeComplete = j + 1 >= (possiblePalindromeLength / 2);
                            correctPos = s.charAt(init) == s.charAt(end);
                            j++;
                        } while (!palindromeComplete && correctPos);

                        if (correctPos) {
                            currentLongestPalindrome = s.substring(charIndex, i + 1);
                            break sameCharLoop;
                        }
                    }
                }
                charIndices.remove(charIndices.size() - 1);
            }
        }
        return currentLongestPalindrome;
    }

    public static String longestPalindrome_expandAroundCenter(String s) {
        if (s == null || s.length() == 0)
            return "";

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int lenA = expandAroundCenter(i, i, s);
            int lenB = expandAroundCenter(i, i + 1, s);
            int len = Math.max(lenA, lenB);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(int left, int right, String s) {
        int start = left, end = right;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start++;
            left++;
        }

        return end - start - 1;
    }
}
