package singleton;

/**
 * @Author: zlatanlong
 * @Date: 2021/5/7 8:10
 * 线程不安全
 */
public class LazySingleton {

    private static LazySingleton lazySingleton = null;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
