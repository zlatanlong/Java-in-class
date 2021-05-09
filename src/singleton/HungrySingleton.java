package singleton;

/**
 * @Author: zlatanlong
 * @Date: 2021/5/7 8:56
 */
public class HungrySingleton {
    private final static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
