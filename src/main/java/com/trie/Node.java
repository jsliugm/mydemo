package com.trie;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private char value;
    private List<Node> children;

    public Node addChild(char value) {
        if (children == null) {
            children = new ArrayList<Node>();
        } else {
            for (Node child : children) {
                if (child.value == value) {
                    return child;
                }
            }
        }
        Node child = new Node(value);
        children.add(child);
        return child;
    }

    public Node() {
    }

    public Node(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public boolean match(String s) {
        Node node = this;
        out:
        for (int i = 0; i < s.length(); i++) {
            if (node.children == null) {
                return false;
            }
            inner:
            for (Node child : node.children) {
                if (child.value == s.charAt(i)) {
                    node = child;
                    continue out;
                }
            }
            return false;
        }
        if(node.children == null) {
            return true;
        }else {
            return false;
        }

    }
}
