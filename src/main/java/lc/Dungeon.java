package lc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dungeon {
    // Kattis version: https://open.kattis.com/problems/dungeon

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String start = sc.nextLine();

            String[] props = start.split(" ");
            int l = Integer.valueOf(props[0]);
            int r = Integer.valueOf(props[1]);
            int c = Integer.valueOf(props[2]);

            if (l > 0) {
                int sx = 0, sy = 0, sz = 0;
                char[][][] dungeon = new char[c][r][l];
                for (int z = 0; z < c; z++) {
                    for (int y = 0; y < r; y++) {
                        String line = sc.nextLine();
                        for (int x = 0; x < c; x++) {
                            char cx = line.charAt(x);
                            if (cx == 'S') {
                                sx = x;
                                sy = y;
                                sz = z;
                            }
                            dungeon[z][y][x] = cx;
                        }
                    }
                    sc.nextLine();
                }

                checkTime(dungeon, sx, sy, sz, l, r, c);
            }

            if (sc.hasNextLine())
                sc.nextLine();
        }
    }

    private static void checkTime(char[][][] dungeon,
                                  int sx, int sy, int sz,
                                  int l, int r, int c) {
        boolean[][][] visited = new boolean[c][r][l];

        int[] movX = {-1, 1, 0, 0, 0, 0};
        int[] movY = {0, 0, -1, 1, 0, 0};
        int[] movZ = {0, 0, 0, 0, -1, 1};

        Queue<Integer> qx = new LinkedList();
        Queue<Integer> qy = new LinkedList();
        Queue<Integer> qz = new LinkedList();

        qx.add(sx);
        qy.add(sy);
        qz.add(sz);

        int moves = 0;
        int currentLevel = 1;
        int nextLevel = 0;

        while (!qx.isEmpty()) {
            int x = qx.remove();
            int y = qy.remove();
            int z = qz.remove();

            char cell = dungeon[z][y][x];

            currentLevel--;

            if (cell == 'E') {
                System.out.println("Escaped in " + moves + " minute(s).");
                return;
            } else if (!visited[z][y][x] && cell != '#') {
                visited[z][y][x] = true;
                for (int i = 0; i < 6; i++) {
                    int nextX = x + movX[i];
                    int nextY = y + movY[i];
                    int nextZ = z + movZ[i];

                    if (nextX < c && nextX >= 0
                            && nextY < r && nextY >= 0
                            && nextZ < l && nextZ >= 0) {
                        qx.add(nextX);
                        qy.add(nextY);
                        qz.add(nextZ);

                        nextLevel++;
                    }
                }
            }

            if (currentLevel == 0) {
                currentLevel = nextLevel;
                nextLevel = 0;
                moves++;
            }
        }

        System.out.println("Trapped!");
    }
}

