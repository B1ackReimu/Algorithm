package designpattern.singleton.type6;

public class SingletonTest06 {

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

    private static volatile Singleton instance;

    //加入双重检查，解决线程安全问题和懒加载
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

