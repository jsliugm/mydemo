package com.trie;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class NodeTest {
    @Test
    public void test() {
        NodeBuilder builder = new NodeBuilder();
        builder.addWord("hello");
        builder.addWord("world");
        builder.addWord("中国");
        Node node = builder.build();
        System.out.println(node.match("hello"));
        System.out.println(node.match("worl"));
        System.out.println(node.match("中国"));
        System.out.println(node.match("中"));
    }

    private List<String> words;
    private Node node;
    private Set<String> set;

    @Before
    public void before() {
        int n = 5 * 10000;
        words = Lists.newArrayListWithExpectedSize(n);
        NodeBuilder builder = new NodeBuilder();
        set = Sets.newHashSetWithExpectedSize(n);
        for (int i = 0; i < n; i++) {
            String uuid = UUID.randomUUID().toString();
            set.add(uuid);
            words.add(uuid);
            builder.addWord(uuid);
        }
        node = builder.build();
    }

    @Test
    public void testPerformance() {
        int n = 5 * 10000;
        String target = "中国人";
        StopWatch stopWatch = new StopWatch();

        stopWatch.start("set");
        for (int i = 0; i < n; i++) {
            set.contains(target);
        }
        stopWatch.stop();

        stopWatch.start("node");
        for (int i = 0; i < n; i++) {
            node.match(target);
        }
        stopWatch.stop();

        stopWatch.start("list");
        for (int i = 0; i < n; i++) {
            words.contains(target);
        }
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
