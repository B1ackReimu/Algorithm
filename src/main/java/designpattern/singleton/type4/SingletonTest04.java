package designpattern.singleton.type4;

public class SingletonTest04 {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());
    }

}

//懒汉式，线程安全
class Singleton {
    private Singleton() {

    }

    private static Singleton instance;

    //当使用到该方法时才创建（懒汉式），加入同步处理代码
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

