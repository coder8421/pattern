package com.example.demo.singleton;

/**
 *
 优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
 静态常量饿汉式
 */
public class Singleton {

    private Singleton() {}

    private final static Singleton instance = new Singleton();

    private static Singleton getInstance() {
        return instance;
    }

}

/**
 *  静态代码块饿汉式  与静态常量类似
 *  只不过将类实例化的过程放在了静态代码块中，也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。
 */
class Singleton1 {
    private static  Singleton1 instance;
    private Singleton1() {}
    static {
        instance  =new Singleton1();
    }

    private static Singleton1 getInstance() {
        return instance;
    }

}

/**
 *  线程不安全懒汉式 适合单线程
 *  如果在多线程下，一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，
 *  另一个线程也通过了这个判断语句，这时便会产生多个实例。所以在多线程环境下不可使用这种方式。
 */
class Singleton2 {
    private static Singleton2 instance;
    private Singleton2() {
    }
    private static Singleton2 getInstance() {
        if (null == instance) {
            new Singleton2();
        }

        return instance;
    }

}

/**
 * 线程安全懒汉式 + synchronized 关键字
 *  效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。
 *  而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，直接return就行了。方法进行同步效率太低要改进。
 */
class Singleton3 {
    private static Singleton3 instance;
    private Singleton3() {
    }
    private static synchronized Singleton3 getInstance() {
        if (null == instance) {
            new Singleton3();
        }

        return instance;
    }

}

/**
 * 同步代码块懒汉式
 * 改为同步产生实例化的的代码块。但是这种同步并不能起到线程同步的作用。跟第3种实现方式遇到的情形一致，
 * 假如一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。
 */
class Singleton4 {
    private static  volatile Singleton4 instance;
    private Singleton4() {
    }
    private static synchronized Singleton4 getInstance() {
        if (null == instance) {
            new Singleton4();
        }

        return instance;
    }

}

/** 双重检查(推荐使用)
 *  * Double-Check概念对于多线程开发者来说不会陌生，如代码中所示，
 *  * 我们进行了两次if (singleton == null)检查，这样就可以保证线程安全了。
 *  * 这样，实例化代码只用执行一次，后面再次访问时，判断if (singleton == null)，直接return实例化对象。
 *  * 优点：线程安全；延迟加载；效率较高。
 */
class Singleton5 {
    private static volatile  Singleton5 instance;
    private  Singleton5(){

    }
    private static Singleton5 getInstance(){
        if (null == instance){
            synchronized (Singleton5.class){
                if (null == instance){
                  instance=  new Singleton5();
                }
            }
        }
        return instance;

    }
}


/**
 * 静态内部类
 * 这种方式跟饿汉式方式采用的机制类似，但又有不同。两者都是采用了类装载的机制来保证初始化实例时只有一个线程。不同的地方在饿汉式方式是只要Singleton类被装载就会实例化，没有Lazy-Loading的作用，而静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，才会装载SingletonInstance类，从而完成Singleton的实例化。
 *
 * 类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
 *
 * 优点：避免了线程不安全，延迟加载，效率高。
 */
class Singleton6{
    private  Singleton6(){
    }

    private static class SingletonInstance {
        private static final Singleton6 INSTANCE = new Singleton6();
    }
    private static Singleton6 getInstance(){

        return SingletonInstance.INSTANCE;

    }
}
