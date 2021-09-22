package designpattern.factory.simplefactory.pizzastore.order;

import designpattern.factory.simplefactory.pizzastore.pizza.CheesePizza;
import designpattern.factory.simplefactory.pizzastore.pizza.GreekPizza;
import designpattern.factory.simplefactory.pizzastore.pizza.PepperPizza;
import designpattern.factory.simplefactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {

    /*public OrderPizza() {
        Pizza pizza;
        String orderType; //订购pizza类型
        do {
            orderType = gettype();
            if (orderType.equals("greek")) {
                pizza = new GreekPizza();
                pizza.setName("希腊披萨");
            } else if (orderType.equals("cheese")) {
                pizza = new CheesePizza();
                pizza.setName("奶酪披萨");
            } else if (orderType.equals("pepper")){
                pizza = new PepperPizza();
                pizza.setName("胡椒披萨");
            }
            else {
                break;
            }
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } while (true);
    }*/

    SimpleFactory simpleFactory;
    Pizza pizza = null;

    public OrderPizza(SimpleFactory simpleFactory) {
        setSimpleFactory(simpleFactory);
    }

    public void setSimpleFactory(SimpleFactory simpleFactory) {
        String orderType;
        this.simpleFactory = simpleFactory;
        do {
            orderType = gettype();
            Pizza pizza = this.simpleFactory.createPizza(orderType);
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购失败");
                break;
            }
        } while (true);
    }

    private String gettype() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
