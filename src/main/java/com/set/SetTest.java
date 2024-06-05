package com.set;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Collections;
import java.util.Set;

public class SetTest {
    @Test
    public void test(){
        Set<String> set1 = Sets.newHashSet("1");
        Set<String> set2 = Collections.emptySet();
        set1.addAll(set2);

    }
}
