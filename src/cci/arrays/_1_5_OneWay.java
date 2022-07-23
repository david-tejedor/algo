package cci.arrays;

public class _1_5_OneWay {

    public static void main(String[] args) {
        System.out.println(away("abste", "bste")); // true
        System.out.println(away("abste", "abst")); // true
        System.out.println(away("abste", "abss")); // false
        System.out.println(away("abste", "acste")); // true
        System.out.println(away("abste", "cste")); // false
    }

    static boolean away(String s1, String s2) {
        if (s1.length() > s2.length() && s1.length() - s2.length() == 1) {
            return checkFirstOneMoreChar(s1, s2);
        } else if (s1.length() == s2.length()) {
            return checkMaxOneDifference(s1, s2);
        } else if (s2.length() - s1.length() == 1) {
            return checkFirstOneMoreChar(s2, s1);
        }

        return false;
    }

    private static boolean checkMaxOneDifference(String s1, String s2) {
        boolean anyDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (anyDifference) return false;
                anyDifference = true;
            }
        }

        return true;
    }

    private static boolean checkFirstOneMoreChar(String longer, String shorter) {
        boolean anyDifference = false;
        int j = 0;
        for (int i = 0; i < longer.length() && j < shorter.length(); i++) {
            if (longer.charAt(i) != shorter.charAt(j)) {
                if (shorter.length() <= j + 1 || anyDifference) return false;
                anyDifference = true;
            } else {
                j++;
            }
        }

        return true;
    }

}
