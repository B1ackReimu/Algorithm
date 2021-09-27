package designpattern.strategy;

public class ToyDuck extends Duck{
    @Override
    public void display() {
        System.out.println("这是玩具鸭");
    }

    @Override
    public void quack(){
        System.out.println("玩具鸭不会嘎嘎叫");
    }

    @Override
    public void swim(){
        System.out.println("玩具鸭不会游泳");
    }

    @Override
    public void fly(){
        System.out.println("玩具鸭不会飞翔");
    }
}
