package cci.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _8_4_PowerSet {

    public static void main(String[] args) {
        System.out.println(subsets(Set.of(3, 4, 1, 5)));
    }

    public static Set<Set<Integer>> subsets(Set<Integer> set) {
        if (set.size() < 2) return new HashSet();

        Set<Set<Integer>> subsets = new HashSet();
        for (Integer value: set) {
            subsets.add(Stream.of(value).collect(Collectors.toSet()));

            Set<Integer> rest = new HashSet(set);
            rest.remove(value);

            subsets(rest).stream()
                    .filter(s -> !s.isEmpty())
                    .forEach(s -> {
                        s.add(value);
                        subsets.add(s);
                    });
        }

        return subsets;
    }

}
