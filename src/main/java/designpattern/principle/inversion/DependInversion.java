package designpattern.principle.inversion;

public class DependInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}

class Email {
    public String getInfo() {
        return "电子邮件信息: hello world";
    }
}


//完成Person接收消息的功能
//方式1分析
//1.简单
//2.如果我们获取的对象是 微信、短信等等，需要新增类，同时Person类也要增加相应接收方法
//3.解决思路：引入一个抽象的接口IReceive，表示接收者，这样Person类与接口发生依赖
// 因为Email、微信等等都属于接收的范围，他们各自实现IReceive接口就可以，这样符合依赖倒转原则
class Person {
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
}