package com.trie;

import com.google.common.collect.Lists;
import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

/**
 * 测试
 *
 * @author
 */
public class TrieTest {


    @Test
    public void test() {
        Trie trie = Trie.builder()
                .addKeyword("hers")
                .addKeyword("his")
                .addKeyword("she")
                .addKeyword("he")
                .build();
        Collection<Emit> emits = trie.parseText("ushers 1111");

    }


    @Test
    public void test3() {
        Trie trie = Trie.builder()
                .addKeyword("江苏省淮安市涟水县朱码镇")
                .addKeyword("江苏省淮安市涟水县高沟镇")
                .addKeyword("江苏省淮安市涟水县A镇")
                .addKeyword("江苏省淮安市涟水县红窑镇")
                .build();
        Collection<Emit> emits = trie.parseText("江苏省淮安市涟水县红窑镇刘桥村");
        System.out.println(emits);
    }

    @Test
    public void test4() {
        List<String> list = Lists.newArrayList();
        list.add("江苏省淮安市涟水县朱码镇");
        list.add("江苏省淮安市涟水县高沟镇");
        list.add("江苏省淮安市涟水县A镇");
        list.add("江苏省淮安市涟水县红窑镇");
        Trie trie = Trie.builder()
                .addKeywords(list)
                .build();

        String address = "江苏省淮安市涟水县红窑镇刘桥村";

        Collection<Emit> emits = trie.parseText(address);
        System.out.println(emits);

        System.out.println(trie.firstMatch(address));

        System.out.println(trie.containsMatch(address));

    }

    @Test
    public void test2() {
        List<String> list = Lists.newArrayList("hello", "hello", "world", "hello world");

    }
}
