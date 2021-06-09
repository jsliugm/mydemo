package com.trie;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * 性能测试
 * @author
 */
public class TriePerformanceTest {

    private static List<String> getDataList() {
        int n = 6 * 10000;
        List<String> list = Lists.newArrayListWithExpectedSize(n);
        for (int i = 0; i < n; i++) {
            list.add(UUID.randomUUID().toString());
        }
        return list;
    }

    private static List<String> list;
    private static Set<String> set;
    private static Trie trie;

    @Before
    public void before() {
        list = getDataList();
        set = Sets.newHashSetWithExpectedSize(list.size());
        Trie.TrieBuilder builder = Trie.builder().ignoreOverlaps();
        for (String data : list) {
            builder.addKeyword(data);
            set.add(data);
        }
        trie = builder.build();
    }

    @Test
    public void test() {
        StopWatch stopWatch = new StopWatch();
        int n = 2 * 10000;
        String testString = "abcsugarcanesugasugar";
        stopWatch.start("set");
        for (int i = 0; i < n; i++) {
            if (set.contains(testString)) {

            }
        }
        stopWatch.stop();
        stopWatch.start("list");
        outer:
        for (int i = 0; i < n; i++) {
            inner:
            for (String s : list) {
                if (testString.equals(s)) {
                    break inner;
                }
            }
        }
        stopWatch.stop();

        stopWatch.start("trie");
        for (int i = 0; i < n; i++) {
            Emit emit = trie.firstMatch(testString);
            if (emit != null && emit.getStart() == 0 && emit.getEnd() == testString.length() - 1) {
            }

        }
        stopWatch.stop();


        System.out.println(stopWatch.prettyPrint());


    }
}
