package cci.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class _8_8_PermutsDups {

    public static void main(String[] args) {
        System.out.println(permut("aab"));
        System.out.println("-----");
        System.out.println(permut("aaabbcd"));
    }

    public static List<String> permut(String s) {
        List<String> permuts = new ArrayList();

        if (s == null || s.length() == 0) {
            return permuts;
        }

        if (s.length() == 1) {
            permuts.add(s);
            return permuts;
        }

        char charToPermut = s.charAt(0);
        List<String> subPermuts = permut(s.substring(1));
        for (String subPermut : subPermuts) {
            for (int i = 0; i <= subPermut.length(); i++) {
                if (i == subPermut.length() || subPermut.charAt(i) != charToPermut) {
                    StringBuilder sb = new StringBuilder(subPermut);
                    sb.insert(i, charToPermut);
                    permuts.add(sb.toString());
                }
            }
        }

        return permuts;
    }

}
