package designpattern.visitor;

//双分派，首先在客户端中将具体的状态作为参数传递给woman，然后调用具体方法
public class Woman extends Person {
    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}
