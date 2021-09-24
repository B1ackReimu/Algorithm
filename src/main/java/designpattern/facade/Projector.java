package designpattern.facade;

public class Projector {

    //饿汉式
    private static Projector instance = new Projector();

    public static Projector getInstance(){
        return instance;
    }

    public void on(){
        System.out.println("Projector on");
    }

    public void off(){
        System.out.println("Projector off");
    }

    public void projector(){
        System.out.println("Projector is Projector");
    }

    public void focus(){
        System.out.println("Projector is focus");
    }

}
