package com.jvm;

import groovy.lang.*;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.runtime.InvokerHelper;
import org.codehaus.groovy.runtime.MetaClassHelper;

public class GroovyLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        CompilerConfiguration compilerConfiguration = new CompilerConfiguration();
        compilerConfiguration.getClasspath().add("/groovy/script/compiled/");
        GroovyClassLoader classLoader = new GroovyClassLoader(Thread.currentThread().getContextClassLoader(), compilerConfiguration);

        Class<?> clazz = classLoader.loadClass("Example");
        System.out.println(clazz);
        Script script = InvokerHelper.createScript(clazz, new Binding());
        //wrap(script);

        System.out.println(script.getMetaClass());
        script.run();

        clazz = classLoader.loadClass("Example2");
        script = InvokerHelper.createScript(clazz, new Binding());
       // wrap(script);
        System.out.println(script.getMetaClass());
        script.run();
    }

    public static void wrap(Script scriptObject){
        MetaClass oldMetaClass = scriptObject.getMetaClass();
        /*
         * We override the MetaClass of this script object so that we can
         * forward calls to global closures (of previous or future "eval" calls)
         * This gives the illusion of working on the same "global" scope.
         */
        scriptObject.setMetaClass(new DelegatingMetaClass(oldMetaClass) {
            @Override
            public Object invokeMethod(Object object, String name, Object args) {
                if (args == null) {
                    return invokeMethod(object, name, MetaClassHelper.EMPTY_ARRAY);
                }
                if (args instanceof Tuple) {
                    return invokeMethod(object, name, ((Tuple) args).toArray());
                }
                if (args instanceof Object[]) {
                    return invokeMethod(object, name, (Object[]) args);
                } else {
                    return invokeMethod(object, name, new Object[]{args});
                }
            }

            @Override
            public Object invokeMethod(Object object, String name, Object[] args) {
                try {
                    return super.invokeMethod(object, name, args);
                } catch (MissingMethodException mme) {
                    return null;
                }
            }

            @Override
            public Object invokeStaticMethod(Object object, String name, Object[] args) {
                try {
                    return super.invokeStaticMethod(object, name, args);
                } catch (MissingMethodException mme) {
                    return null;
                }
            }
        });
    }
}
