package designpattern.factory.absfactory.pizzastore.order;

import designpattern.factory.absfactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {

    AbsFactory absFactory;

    public OrderPizza(AbsFactory absFactory) {
        setAbsFactory(absFactory);
    }

    private void setAbsFactory(AbsFactory absFactory) {
        this.absFactory = absFactory;
        Pizza pizza = null;
        String orderType = "";
        do {
            orderType = gettype();
            pizza = absFactory.createPizza(orderType);
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
