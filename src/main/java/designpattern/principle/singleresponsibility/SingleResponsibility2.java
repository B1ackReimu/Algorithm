package designpattern.principle.singleresponsibility;

public class SingleResponsibility2 {

    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("摩托车");
        roadVehicle.run("汽车");
        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");
    }

}

//方案2
//1.遵守单一职责原则
//2.改动很大，需要将类分解，同时要修改客户端
//3.改进：直接修改Vehicle类，改动的代码少=>方式3
class RoadVehicle{

    public void run(String vehicle){
        System.out.println(vehicle+"公路运行");
    }

}

class AirVehicle{

    public void run(String vehicle){
        System.out.println(vehicle+"天空运行");
    }

}

class WaterVehicle{

    public void run(String vehicle){
        System.out.println(vehicle+"水中运行");
    }

}


