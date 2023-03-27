package com.enjoy;

import com.google.common.collect.Lists;
import com.jfinal.kit.Kv;
import com.jfinal.template.Engine;
import com.jfinal.template.Template;
import org.junit.Test;

public class EnjoyTest {
    @Test
    public void test(){
        String content = "#if(name)\n" +
                "#(name)\n" +
                "#end";
        Engine engine = Engine.use();
        engine.setDevMode(true);
        engine.setToClassPathSourceFactory();
        Template template = engine.getTemplateByString(content);
       // engine.getTemplate("index.html");
        System.out.println(template.renderToString(Kv.by("name", null)));
        System.out.println(template.renderToString(Kv.by("name", "aaa")));
        System.out.println(template.renderToString(Kv.by("name", "bbb")));
    }

    @Test
    public void testFor(){
        String content = "#for(x:list) \n" +
                "#if(x!=\"a\") #(x) #end \n" +
                "#end";
        Engine engine = Engine.use();
        engine.setDevMode(true);
        engine.setToClassPathSourceFactory();
        Template template = engine.getTemplateByString(content);
        // engine.getTemplate("index.html");
        System.out.print(template.renderToString(Kv.by("list", Lists.newArrayList("a","b","c"))));

    }
    @Test
    public void testxx(){
        //System.out.println();
    }

    @Test
    public void test2(){
        String[] a = new String[]{"1"};
        System.out.println(a[99]);
    }
}
