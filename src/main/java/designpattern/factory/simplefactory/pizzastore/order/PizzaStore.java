package designpattern.factory.simplefactory.pizzastore.order;

//相当于一个客户端，发起订购任务
public class PizzaStore {

    public static void main(String[] args) {
        //new OrderPizza(new SimpleFactory());
        new OrderPizza2();
        System.out.println("退出程序");
    }

}
