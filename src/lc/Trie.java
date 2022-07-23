package lc;

public class Trie {
    TrieNode root;
    final int R = 26;

    public Trie() {
        root = new TrieNode();
    }
}

class TrieNode {
    final int R = 26;
    boolean isEnd;
    TrieNode[] nodes;

    public TrieNode() {
        nodes = new TrieNode[R];
    }
}
