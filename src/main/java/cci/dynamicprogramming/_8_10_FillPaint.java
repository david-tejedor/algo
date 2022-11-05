package cci.dynamicprogramming;

public class _8_10_FillPaint {

    /*
        Paint Fill: Implement the "paint fill" function that one might see on many image editing programs. That is,
        given a screen (represented by a two-dimensional array of colors), a point, and a new color, fill in the
        surrounding area until the color changes from the original color.
    */

    public static void main(String[] args) {
        int[][] screen = {{0, 0, 1}, {2, 0, 2}, {1, 1, 2}};
        print(screen);

        System.out.println();

        print(fill(screen, new Point(1, 1), 5));
    }

    public static int[][] fill(int[][] screen, Point p, int color) {
        if (screen.length <= p.y || screen[p.y].length <= p.x || screen[p.y][p.x] == color)
            return screen;

        return fill(screen, p, screen[p.y][p.x], color);
    }

    private static int[][] fill(int[][] screen, Point p, int originalColor, int targetColor) {
        if (screen[p.y][p.x] == originalColor) {
            screen[p.y][p.x] = targetColor;

            if (screen.length > p.y + 1) {
                screen = fill(screen, new Point(p.x, p.y + 1), originalColor, targetColor);
            }

            if (p.y > 0) {
                screen = fill(screen, new Point(p.x, p.y - 1), originalColor, targetColor);
            }

            if (screen[p.y].length > p.x + 1) {
                screen = fill(screen, new Point(p.x + 1, p.y), originalColor, targetColor);
            }

            if (p.x > 0) {
                screen = fill(screen, new Point(p.x - 1, p.y), originalColor, targetColor);
            }
        }

        return screen;
    }

    private static void print(int[][] fill) {
        for (int[] row : fill) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static class Point {

        public final int x;
        public final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
