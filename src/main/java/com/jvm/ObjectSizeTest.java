package com.jvm;

import com.clazz.Person;
import com.clazz.Student;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ObjectSizeTest {
    @Test
    public void setObjectSize() {
        Set<String> set = Sets.newHashSet();
        List<String> list = Lists.newArrayList();
        System.out.println(GraphLayout.parseInstance(set).totalSize());
        System.out.println(GraphLayout.parseInstance(list).totalSize());
        for (int i = 0; i < 10; i++) {
            set.add("test" + i);
            list.add("test" + i);
        }
        System.out.println(GraphLayout.parseInstance(set).totalSize());
        System.out.println(GraphLayout.parseInstance(list).totalSize());
    }

    @Test
    public void mapSize() {
        Map<String, Object> map = new HashMap<>();
        System.out.println(GraphLayout.parseInstance(map).totalSize());
        //内部信息
       // System.out.println(ClassLayout.parseInstance(map).toPrintable());
        //外部信息
        //System.out.println(GraphLayout.parseInstance(map).toPrintable());
        Person person = new Person();
        for (int i = 0; i < 100000; i++) {
            map.put("test" + i, person);

        }
        System.out.println(GraphLayout.parseInstance(map).totalSize());
        map.clear();
        System.out.println("after clear=========================");
        System.out.println(GraphLayout.parseInstance(map).totalSize());

    }


    @Test
    public void mapSize2() {
        Map<String, Object> map = new HashMap<>();
        System.out.println(GraphLayout.parseInstance(map).totalSize());
        //Person o = new Person();
        Student o = new Student();
        for (int i = 0; i < 100000; i++) {
            map.put("test" + i, o);
        }
        System.out.println(GraphLayout.parseInstance(map).totalSize());
        map.clear();
        System.out.println(GraphLayout.parseInstance(map).totalSize());
    }
}
