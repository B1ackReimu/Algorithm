package designpattern.principle.singleresponsibility;

public class SingleResponsibility1 {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("汽车");
        vehicle.run("飞机");
    }

}

// 方式1
// 1. 在方式1的run方法中违反单一职责原则
// 2. 根据交通工具运行方式不同，分解成不同类=>方式2
class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上运行....");
    }
}
