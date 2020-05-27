package com.vinay.designpatterns;

import com.vinay.designpatterns.creational.SingletonClassEager;
import com.vinay.designpatterns.creational.SingletonClassLazy;
import com.vinay.designpatterns.creational.SingletonClassLazyThreadSafe1;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SingletonClassEager singletonClass = SingletonClassEager.SINGLETON_CLASS;
        SingletonClassLazy singletoncClassLazy = SingletonClassLazy.getInstance();
        SingletonClassLazyThreadSafe1 singletonClassLazyThreadSafe1 = SingletonClassLazyThreadSafe1.getInstance();
        
    }
}
