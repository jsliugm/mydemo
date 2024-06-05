package com.graphviz;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RuleNode {
    private Object result;
    private String text;
    private List<RuleNode> children = new ArrayList<>();

    public RuleNode(Object result, String text) {
        this.result = result;
        this.text = text;
    }

    public void addNode(RuleNode node) {
        children.add(node);
    }
}
