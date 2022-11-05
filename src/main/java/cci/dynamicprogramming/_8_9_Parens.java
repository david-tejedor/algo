package cci.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class _8_9_Parens {

    public static void main(String[] args) {
        System.out.println(parens(3));
    }

    private static Set<String> parens(int n) {
        return parens(n, n);
    }

    private static Set<String> parens(int left, int right) {
        Set<String> parens = new HashSet();

        if (left == 0 && right == 1) {
            parens.add(")");
            return parens;
        }

        if (left > 0) {
            Set<String> nextParens = parens(left - 1, right);
            for (String s : nextParens)
                parens.add("(" + s);
        }

        if (right > 0 && right > left) {
            Set<String> nextParens = parens(left, right - 1);
            for (String s : nextParens)
                parens.add(")" + s);
        }

        return parens;
    }
}
