package cci.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1_4_CheckPermutations {

    public static void main(String[] args) {
        System.out.println(palindromePermutation("adcad"));
        System.out.println(palindromePermutation("ddaa"));
        System.out.println(palindromePermutation("abc"));
        System.out.println(palindromePermutation("Tact Coa"));
        System.out.println(palindromePermutation("Tact, Coa"));
    }

    static boolean palindromePermutation(String s) {
        Map<Integer, Integer> occurrences = getOccurrences(s);
        return isMaxOneOddOccurrence(occurrences);
    }

    private static Map<Integer, Integer> getOccurrences(String s) {
        List<Integer> numericChars = getNumericChars(s);
        return getNumericCharsOccurrences(numericChars);
    }

    private static List<Integer> getNumericChars(String s) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');

        List<Integer> numericValues = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int numericValue = Character.getNumericValue(s.charAt(i));
            if (numericValue >= a && numericValue <= z) {
                numericValues.add(numericValue);
            }
        }

        return numericValues;
    }

    private static Map<Integer, Integer> getNumericCharsOccurrences(List<Integer> numericChars) {
        Map<Integer, Integer> occurrences = new HashMap();
        for (Integer value: numericChars) {
            if (occurrences.containsKey(value)) {
                occurrences.put(value, occurrences.get(value) + 1);
            } else {
                occurrences.put(value, 1);
            }
        }

        return occurrences;
    }

    private static boolean isMaxOneOddOccurrence(Map<Integer, Integer> occurrences) {
        boolean anyOdd = false;
        for (Integer key: occurrences.keySet()) {
            if (occurrences.get(key) % 2 != 0) {
                if (anyOdd)
                    return false;
                anyOdd = true;
            }
        }

        return true;
    }
}
