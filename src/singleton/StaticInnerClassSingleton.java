package singleton;

/**
 * @Author: zlatanlong
 * @Date: 2021/5/7 8:27
 * 为什么这个例子是可行的呢？主要有两个原因：
 *
 * JVM在类的初始化阶段会加Class对象初始化同步锁，同步多个线程对该类的初始化操作；
 * 静态内部类InnerClass的静态成员变量instance在方法区中只会有一个实例。
 * 在Java规范中，当以下这些情况首次发生时，A类将会立刻被初始化：
 *
 * A类型实例被创建；
 * A类中声明的静态方法被调用；
 * A类中的静态成员变量被赋值；
 * A类中的静态成员被使用（非常量）；
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton(){}

    private static class InnerClass{
        private static StaticInnerClassSingleton singleton = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance(){
        return InnerClass.singleton;
    }
}
