package com.universe.gof.factory;

import com.universe.common.ReadXML;
import com.universe.common.YamlUtils;
import org.junit.Test;

public class Client {
    public static void main(String[] args) {
        AbstractFactory factory = (AbstractFactory) ReadXML.getObject();
        factory.newProduct().show();
    }

    @Test
    public void test() throws Exception {
        String className = YamlUtils.getValue("gof.factory.className");
        AbstractFactory factory = (AbstractFactory) Class.forName(className).newInstance();
        factory.newProduct().show();
    }
}
