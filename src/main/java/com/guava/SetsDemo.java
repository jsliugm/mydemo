package com.guava;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.junit.Test;

import java.util.Set;

/**
 * Created by jsliu on 2019/8/13.
 */
public class SetsDemo {
    @Test
    public void test(){
        String[] xx = {"1","2"};
        Set<String> set = Sets.newHashSet(xx);
        System.out.println(set.size());
        System.out.println(set);
    }
    @Test
    public void test2(){
      Lists.newArrayList();
    }
}
