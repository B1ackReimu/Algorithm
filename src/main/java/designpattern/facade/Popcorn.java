package designpattern.facade;

public class Popcorn {

    //饿汉式
    private static Popcorn instance = new Popcorn();

    public static Popcorn getInstance(){
        return instance;
    }

    public void on(){
        System.out.println("Popcorn on");
    }

    public void off(){
        System.out.println("Popcorn off");
    }

    public void pop(){
        System.out.println("Popcorn is poping");
    }

}
