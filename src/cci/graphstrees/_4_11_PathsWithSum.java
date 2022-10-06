package cci.graphstrees;

import java.util.ArrayList;
import java.util.List;

public class _4_11_PathsWithSum {

    // Paths with Sum: You are given a binary tree in which each node contains an integer value (which might be
    // positive or negative). Design an algorithm to count the number of paths that sum to a given value. The path
    // does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent
    // nodes to child nodes).

    public static void main(String[] args) {
        TreeNode r = new TreeNode(2);
        TreeNode rl = new TreeNode(-1);
        TreeNode rr = new TreeNode(1);
        r.left = rl;
        r.right = rr;
        TreeNode rll = new TreeNode(2);
        TreeNode rlr = new TreeNode(3);
        rl.left = rll;
        rl.right = rlr;
        TreeNode rlrr = new TreeNode(-1);
        rlr.right = rlrr;

        System.out.println(r.countPaths(3));
        System.out.println(r.countPaths(2));
        System.out.println(r.countPaths(4));
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public int countPaths(int sum) {
        return countSubPaths(sum, new ArrayList());
    }

    private int countSubPaths(int sum, List<Integer> pathSums) {
        int paths = 0;
        if (sum - data == 0)
            paths++;

        List<Integer> nodeSums = new ArrayList(pathSums);
        for (int i = 0; i < pathSums.size(); i++) {
            int pathSum = pathSums.get(i) - data;
            if (pathSum == 0)
                paths++;
            nodeSums.set(i, pathSum);
        }

        nodeSums.add(sum - data);
        if (left != null)
            paths += left.countSubPaths(sum, nodeSums);
        if (right != null)
            paths += right.countSubPaths(sum, nodeSums);

        return paths;
    }

}
