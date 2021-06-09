package com.trie;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;
import org.ahocorasick.trie.handler.EmitHandler;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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
        System.out.println();
    }

    @Test
    public void test2(){
        List<String> list = Lists.newArrayList("hello","hello", "world", "hello world");

    }
}
