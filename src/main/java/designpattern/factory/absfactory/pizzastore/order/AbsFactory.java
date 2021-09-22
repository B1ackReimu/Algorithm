package designpattern.factory.absfactory.pizzastore.order;

import designpattern.factory.absfactory.pizzastore.pizza.Pizza;

//一个抽象工厂模式的抽象层
public interface AbsFactory {

    Pizza createPizza(String orderType);
}
