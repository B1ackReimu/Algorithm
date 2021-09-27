package designpattern.strategy.improve;

public class PekingDuck extends Duck {

    public PekingDuck() {
        flyBehavior = new NoFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("这是北京鸭");
    }

}
