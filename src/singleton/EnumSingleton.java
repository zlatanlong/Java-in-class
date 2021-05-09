package singleton;

/**
 * @Author: zlatanlong
 * @Date: 2021/5/7 9:01
 */
public enum EnumSingleton {
    Singleton;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance() {
        return Singleton;
    }
}
