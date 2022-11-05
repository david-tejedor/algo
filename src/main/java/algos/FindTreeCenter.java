package algos;

import java.util.ArrayList;
import java.util.List;

public class FindTreeCenter {

    public static int findCenter(int[][] graph) {
        int n = graph.length;
        int[] degree = new int[n];
        List<Integer> leaves = new ArrayList();

        for (int i = 0; i < n; i++) {
            if (graph[i].length < 2) {
                degree[i] = 0;
                leaves.add(i);
            }
        }

        int count = leaves.size();
        while (count < n) {
            List<Integer> newLeaves = new ArrayList();
            for (int leave : leaves) {
                degree[leave] = 0;
                for (int neighbour : graph[leave]) {
                    degree[neighbour] = degree[neighbour] - 1;
                    if (degree[neighbour] == 1) {
                        newLeaves.add(neighbour);
                    }
                }
            }
            count += newLeaves.size();
            leaves = newLeaves;
        }

        return leaves.get(0);
    }
}
