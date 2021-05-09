package singleton;

/**
 * @Author: zlatanlong
 * @Date: 2021/5/7 8:15
 * 同步锁锁的是整个类，比较消耗资源，
 * 并且即使运行内存中已经存在LazySingleton，
 * 调用其getInstance还是会上锁，所以这种写法也不是很好。
 */
public class SyncLazySingleton {

    private static SyncLazySingleton singleton = null;

    private SyncLazySingleton() {
    }

    public static SyncLazySingleton getInstance() {
        synchronized (SyncLazySingleton.class) {
            if (singleton == null) {
                singleton = new SyncLazySingleton();
            }
        }
        return singleton;
    }
}
