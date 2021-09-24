package designpattern.flyweight;

public class ConcreteWebSite extends WebSite {

    private String type; //网站发布形式

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println("网站发布形式为" + type + "在使用中 使用者是" + user.getName());
    }
}
