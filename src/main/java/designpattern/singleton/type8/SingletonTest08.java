package designpattern.singleton.type8;

public class SingletonTest08 {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance == instance2);
        instance.sayOk();
    }

}

enum Singleton {
    INSTANCE;

    public void sayOk() {
        System.out.println("ok");
    }
}
