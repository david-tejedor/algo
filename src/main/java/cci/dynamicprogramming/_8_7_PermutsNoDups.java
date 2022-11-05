package cci.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class _8_7_PermutsNoDups {

    public static void main(String[] args) {
        System.out.println(permutations("abcdef"));
        System.out.println("-----");
        System.out.println(permut("abcdef"));
    }

    public static Set<String> permutations(String s) {
        List<LinkedHashSet<Character>> permuts = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            LinkedHashSet o = new LinkedHashSet();
            o.add(s.charAt(i));
            permuts.add(o);
        }

        for (int n = 1; n < s.length(); n++) {
            List<LinkedHashSet<Character>> newPermuts = new ArrayList();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                for (LinkedHashSet<Character> p: permuts) {
                    if (!p.contains(c)) {
                        LinkedHashSet<Character> np = new LinkedHashSet(p);
                        np.add(c);
                        newPermuts.add(np);
                    }
                }
            }
            permuts = newPermuts;
        }

        Set<String> result = new HashSet();
        for (LinkedHashSet<Character> permut: permuts) {
            StringBuilder sb = new StringBuilder();
            for (Character c: permut) {
                sb.append(c);
            }
            result.add(sb.toString());
        }

        return result;
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
                StringBuilder sb = new StringBuilder(subPermut);
                sb.insert(i, charToPermut);
                permuts.add(sb.toString());
            }
        }

        return permuts;
    }

}
