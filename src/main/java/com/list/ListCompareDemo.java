package com.list;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * Created by jsliu on 2019/5/7.
 */
public class ListCompareDemo {
    @Test
    public void test() {
        List<String> list1 = Lists.newArrayList("1", "5");
        List<String> list2 = Lists.newArrayList("3", "4");
        boolean ss = list1.removeAll(list2);
        System.out.println(ss);
    }
}
