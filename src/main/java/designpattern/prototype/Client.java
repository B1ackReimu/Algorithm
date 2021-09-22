package designpattern.prototype;

public class Client {

    public static void main(String[] args) {
        //传统方式
        Sheep sheep = new Sheep("tom", 1, "白色");
        Sheep sheep1 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        //......
    }

}
