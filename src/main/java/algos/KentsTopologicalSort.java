package algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KentsTopologicalSort {

    static List<Integer> sort(int[][] adjacencyList) {
        int[] dependencies = new int[adjacencyList.length];
        for (int i = 0; i < adjacencyList.length; i++) {
            for (int adjacent : adjacencyList[i]) {
                dependencies[adjacent] = dependencies[adjacent] + 1;
            }
        }

        List<Integer> sorted = new ArrayList();
        Queue<Integer> noDepsQueue = new LinkedList();
        for (int i = 0; i < dependencies.length; i++) {
            if (dependencies[i] == 0)
                noDepsQueue.add(i);
        }

        while (!noDepsQueue.isEmpty()) {
            int next = noDepsQueue.remove();
            sorted.add(next);
            for (int adjacent : adjacencyList[next]) {
                int newDeps = dependencies[adjacent] - 1;
                dependencies[adjacent] = newDeps;
                if (newDeps == 0)
                    noDepsQueue.add(adjacent);
            }
        }

        if (sorted.size() != adjacencyList.length)
            return Collections.emptyList();

        return sorted;
    }
}
