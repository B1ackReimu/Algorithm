package designpattern.strategy.improve;

public abstract class Duck {

    FlyBehavior flyBehavior;

    public Duck() {

    }

    public abstract void display();

    public void quack() {
        System.out.println("鸭子嘎嘎叫");
    }

    public void swim() {
        System.out.println("鸭子会游泳");
    }

    public void fly() {
        if (flyBehavior != null) {
            flyBehavior.fly();
        }
    }


}
