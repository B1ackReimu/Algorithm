package designpattern.principle.inversion.improve;

public class DependInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
        person.receive(new WeChat());
    }
}

interface IReceive{
    String getInfo();
}

class Email implements IReceive {
    @Override
    public String getInfo() {
        return "电子邮件信息: hello world";
    }
}

class WeChat implements IReceive{

    @Override
    public String getInfo() {
        return "微信：hello world";
    }
}

//完成Person接收消息的功能
//方式2
class Person {
    public void receive(IReceive iReceive) {
        System.out.println(iReceive.getInfo());
    }
}