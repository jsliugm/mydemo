package com.list;

import com.google.common.collect.Lists;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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

    @Test
    public void test2() {
        List<Student> list = Lists.newArrayList(new Student(new Date()), new Student(DateUtils.addHours(new Date(), 1)));
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getBirthday().after(o2.getBirthday())) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        System.out.println(list);
        list.remove(0);
        System.out.println(list);
    }
}
