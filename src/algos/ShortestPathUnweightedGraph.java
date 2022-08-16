package algos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ShortestPathUnweightedGraph {
    static final int MAX_NODES = 126;
    int[][] adjacencyList = new int[MAX_NODES][MAX_NODES];

    public int[] findShortest(int origin, int dest) {
        Integer[] prev = buildPrevFrom(origin);
        return findShortestPath(origin, dest, prev);
    }

    private Integer[] buildPrevFrom(int origin) {
        Integer[] prev = new Integer[MAX_NODES];
        boolean[] visited  = new boolean[MAX_NODES];
        Queue<Integer> nextLevel = new LinkedList();

        Integer parent;
        nextLevel.add(origin);
        visited[origin] = true;
        while (!nextLevel.isEmpty()) {
            int node = nextLevel.remove();
            parent = node;
            for (int adjacent: adjacencyList[node]) {
                if (!visited[adjacent]) {
                    nextLevel.add(adjacent);
                    visited[adjacent] = true;
                    prev[adjacent] = parent;
                }
            }
        }

        return prev;
    }

    private int[] findShortestPath(int origin, int dest, Integer[] prev) {
        List<Integer> prevPath = new ArrayList();
        prevPath.add(dest);
        Integer parent = prev[dest];
        while(parent != null) {
            prevPath.add(parent);
            parent = prev[parent];
        }

        if (prevPath.get(prevPath.size() - 1) != origin)
            return new int[]{};

        int[] path = new int[prevPath.size()];
        for (int i = 0; i < prevPath.size(); i++) {
            path[i] = prevPath.get(prevPath.size() - 1 - i);
        }

        return path;
    }
}
