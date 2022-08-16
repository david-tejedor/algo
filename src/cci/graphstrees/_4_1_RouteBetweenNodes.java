package cci.graphstrees;

import java.util.LinkedList;
import java.util.Queue;

public class _4_1_RouteBetweenNodes {

    // Given a directed graph, design an algorithm to find out whether there is a route between two nodes.

    private final static int MAX_NODES = 126;

    static boolean existsPath(int[][] adjacencyList, int origin, int dest) {
        boolean[] visited = new boolean[MAX_NODES];
        Queue<Integer> nextLevel = new LinkedList();

        nextLevel.add(origin);
        visited[origin] = true;
        while (!nextLevel.isEmpty()) {
            int node = nextLevel.remove();

            for (int adjacent : adjacencyList[node]) {
                if (adjacent == dest)
                    return true;
                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    nextLevel.add(adjacent);
                }
            }
        }

        return false;
    }

}
