package algos;

import java.util.LinkedList;
import java.util.Queue;

// BFS in grid
public class ShortestPathInGrid {

    //    Start on cell S, finish on cell F
    //    Can't navigate cells X
    //    Can navigate up, down, left, right

    public static int movesToShortestPath(int sx, int sy, int fx, int fy, char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Integer> qx = new LinkedList();
        Queue<Integer> qy = new LinkedList();

        qx.add(sx);
        qy.add(sy);

        int x, y;

        int moves = 0;
        int nodesLeftInLayer = 1;
        int nodesInNextLayer = 0;

        while (!qx.isEmpty()) {
            x = qx.remove();
            y = qy.remove();

            visited[y][x] = true;

            if (grid[y][x] == 'F')
                return moves;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (ny < grid.length && nx < grid[0].length && ny >= 0 && nx >= 0
                        && !visited[ny][nx] && grid[ny][nx] != 'X') {

                    qx.add(nx);
                    qy.add(ny);

                    nodesInNextLayer++;
                }
            }

            nodesLeftInLayer--;

            if (nodesLeftInLayer == 0) {
                nodesLeftInLayer = nodesInNextLayer;
                nodesInNextLayer = 0;
                moves ++;
            }
        }

        return -1;
    }
}
