package designpattern.singleton.type7;

public class SingletonTest07 {

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

    //静态内部类
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    //加入双重检查，解决线程安全问题和懒加载
    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}

