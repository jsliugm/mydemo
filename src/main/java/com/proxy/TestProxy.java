package com.proxy;

public class TestProxy {  
	  
    public static void main(String[] args) {  
        BookFacadeProxy proxy = new BookFacadeProxy();  
        BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());  
        bookProxy.addBook();  
        System.out.println(bookProxy.getClass().getName());
    }  
  
} 