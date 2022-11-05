package algos.datastructures;

class HeapWithArray {

    public static void main(String[] args) {
        HeapWithArray heap = new HeapWithArray();

        heap.insert(5);
        heap.insert(7);
        heap.insert(2);
        heap.insert(2);
        heap.insert(9);
        heap.printArray();

        heap.removeMin();
        heap.printArray();
    }

    private static final int MAX_SIZE = 10;
    private Integer[] tree = new Integer[MAX_SIZE];
    private int size = 0;

    public void insert(int value) {
        if (size == 0) {
            tree[0] = value;
            size++;
            return;
        }

        if (size < tree.length) {
            tree[size] = value;
            bubbleUp(size);
            size++;
        }
    }

    private void bubbleUp(int pos) {
        int parent = pos % 2 == 0 ? (pos - 2) / 2 : (pos - 1) / 2;
        if (tree[parent] > tree[pos]) {
            swap(parent, pos);
            if (parent != 0)
                bubbleUp(parent);
        }
    }

    private void swap(int first, int second) {
        Integer temp = tree[first];
        tree[first] = tree[second];
        tree[second] = temp;
    }

    public void removeMin() {
        Integer last = tree[size - 1];
        tree[size - 1] = null;
        tree[0] = last;
        bubbleDown(0);
        size --;
    }

    public void bubbleDown(int pos) {
        Integer min = minChild(pos);
        if (min == null)
            return;

        if (tree[pos] > tree[min]) {
            swap(pos, min);
            bubbleDown(min);
        }
    }

    public Integer minChild(int pos) {
        int leftChild = 2 * pos + 1;
        int rightChild = 2 * pos + 2;

        if (leftChild >= MAX_SIZE || tree[leftChild] == null) {
            if (rightChild >= MAX_SIZE || tree[rightChild] == null) {
                return null;
            }
            return rightChild;
        }
        if (rightChild >= MAX_SIZE || tree[rightChild] == null) {
            return leftChild;
        }


        return (tree[leftChild] < tree[rightChild]) ? leftChild : rightChild;
    }

    public void printArray() {
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i]);
            if (i < tree.length - 1)
                System.out.print(" - ");
        }
        System.out.println();
    }
}
