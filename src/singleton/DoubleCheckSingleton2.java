package singleton;

/**
 * @Author: zlatanlong
 * @Date: 2021/5/7 8:24
 * 不但确保了线程安全，并且当DoubleSyncSingleton2实例创建好后，
 * 后续再调用其getInstance方法不会上锁。
 */
public class DoubleCheckSingleton2 {
    private static volatile DoubleCheckSingleton2 singleton = null;

    private DoubleCheckSingleton2() {
    }

    public static DoubleCheckSingleton2 getInstance() {
        if (singleton == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckSingleton2();
                }
            }
        }
        return singleton;
    }
}
