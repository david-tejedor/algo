package cci.graphstrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _4_7_BuildOrder {

    // Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
    // projects, where the second project is dependent on the first project). All of a project's dependencies must be
    // built before the project is. Find a build order that will allow the projects to be built. If there is no valid
    // build order, return an error.
    //  Input:  projects: a, b, c, d, e, f
    //	        dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
    //  Output: f, e, a, b, d, c

    public static void main(String[] args) {
        char[] projects = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
        char[][] dependencies = new char[][]{{'a', 'd'}, {'f', 'b'}, {'b', 'd'}, {'f', 'a'}, {'d', 'c'}};
        System.out.println(buildOrder(projects, dependencies));
    }

    static List<Character> buildOrder(char[] projects, char[][] dependencies) {
        if (dependencies.length == 0)
            return Collections.emptyList();

        Map<Character, List<Character>> adjacencyList = buildAdjacencyList(projects, dependencies);

        return topologicalOrder(adjacencyList);
    }

    private static Map<Character, List<Character>> buildAdjacencyList(char[] projects, char[][] dependencies) {
        Map<Character, List<Character>> adjacencyList = new HashMap();
        for (int i = 0; i < dependencies.length; i++) {
            char first = dependencies[i][0];
            char second = dependencies[i][1];
            if (adjacencyList.containsKey(first)) {
                adjacencyList.get(first).add(second);
            } else {
                List<Character> adjacents = new ArrayList<>();
                adjacents.add(second);
                adjacencyList.put(first, adjacents);
            }
        }

        for (char project : projects)
            if (!adjacencyList.containsKey(project))
                adjacencyList.put(project, Collections.emptyList());

        return adjacencyList;
    }

    private static List<Character> topologicalOrder(Map<Character, List<Character>> adjacencyList) {
        Map<Character, Integer> projectsDeps = new HashMap();

        for (Character project : adjacencyList.keySet())
            projectsDeps.put(project, 0);

        for (List<Character> dependencies : adjacencyList.values())
            for (Character projectDep : dependencies)
                projectsDeps.put(projectDep, projectsDeps.get(projectDep) + 1);

        Queue<Character> freeProjects = new LinkedList();
        for (Character project : projectsDeps.keySet()) {
            if (projectsDeps.get(project) == 0)
                freeProjects.add(project);
        }

        List<Character> topologicalOrder = new ArrayList();
        while (!freeProjects.isEmpty()) {
            Character nextProject = freeProjects.remove();
            for (Character adjacent : adjacencyList.get(nextProject)) {
                int deps = projectsDeps.get(adjacent) - 1;
                projectsDeps.put(adjacent, deps);
                if (deps == 0)
                    freeProjects.add(adjacent);
            }
            topologicalOrder.add(nextProject);
        }

        if (adjacencyList.size() != topologicalOrder.size())
            return Collections.emptyList();

        return topologicalOrder;
    }

}
