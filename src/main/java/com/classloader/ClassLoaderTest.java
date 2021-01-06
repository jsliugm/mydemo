//package com.classloader;
//
//import java.net.URL;
//
//import com.clazz.Book;
//import org.junit.Test;
//
//import sun.net.spi.nameservice.dns.DNSNameService;
//
//public class ClassLoaderTest {
//	@Test
//	public void testBootStrap(){
//		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
//		for (int i = 0; i < urls.length; i++) {
//		    System.out.println(urls[i].toExternalForm());
//		}
//		System.out.println(System.getProperty("sun.boot.class.path"));
//	}
//	@Test
//	public void testCurrentClass(){
//		System.out.println(this.getClass().getClassLoader());
//		System.out.println(this.getClass().getClassLoader().getClass().getClassLoader());
//		System.out.println(DNSNameService.class.getClassLoader());
//	}
//	@Test
//	public void test(){
//		ClassLoader loader = ClassLoaderTest.class.getClassLoader();    //获得加载ClassLoaderTest.class这个类的类加载器
//		while(loader != null) {
//		    System.out.println(loader);
//		    loader = loader.getParent();    //获得父类加载器的引用
//		}
//		System.out.println(loader);
//	}
//
//}
