package singleton;

/**
 * @Author: zlatanlong
 * @Date: 2021/5/7 8:21
 * 虽然加了同步锁，但它还是线程不安全的。
 * 虽然上面的例子不会出现多次初始化LazyDoubleCheckSingleton实例的情况，
 * 但是由于指令重排的原因，某些线程可能会获取到空对象，后续对该对象的操作将触发空指针异常。
 */
public class DoubleCheckSingleton {

    private static DoubleCheckSingleton singleton = null;

    private DoubleCheckSingleton() {
    }

    public static DoubleCheckSingleton getInstance() {
        if (singleton == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
