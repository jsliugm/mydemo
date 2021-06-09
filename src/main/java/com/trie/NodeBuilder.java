package com.trie;

import java.util.List;

public class NodeBuilder {
    private Node root = new Node();

    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            node = node.addChild(word.charAt(i));
        }
    }

    public void addWords(List<String> words){
        for (String word : words) {
            addWord(word);
        }
    }

    public Node build() {
        return root;
    }
}
