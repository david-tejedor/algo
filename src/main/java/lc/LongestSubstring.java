package lc;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("p"));
        System.out.println(lengthOfLongestSubstring("par"));
        System.out.println(lengthOfLongestSubstring("aab"));
        System.out.println(lengthOfLongestSubstring("daravdfrar"));
        System.out.println(lengthOfLongestSubstring("ddvdf"));
        System.out.println(lengthOfLongestSubstring("cdd"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int substringInit = 0;
        int strLength = s.length();
        Map<Character, Integer> charByPos = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer prevPos = charByPos.get(c);
            if (prevPos != null && prevPos >= substringInit) {
                substringInit = prevPos + 1;
            }
            maxLength = Math.max(maxLength, i + 1 - substringInit);
            charByPos.put(c, i);

            if (strLength + 1 - substringInit <= maxLength) {
                return maxLength;
            }
        }

        return maxLength;
    }
}
