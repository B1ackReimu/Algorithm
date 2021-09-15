package designpattern.principle.segregation;

public class Segregation1 {

}

interface Interface1 {
    void operation1();

    void operation2();

    void operation3();

    void operation4();

    void operation5();
}

class B implements Interface1 {

    @Override
    public void operation1() {
        System.out.println("B中实现了operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B中实现了operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B中实现了operation3");
    }

    @Override
    public void operation4() {
        System.out.println("B中实现了operation4");
    }

    @Override
    public void operation5() {
        System.out.println("B中实现了operation5");
    }
}

class D implements Interface1 {

    @Override
    public void operation1() {
        System.out.println("D中实现了operation1");
    }

    @Override
    public void operation2() {
        System.out.println("D中实现了operation2");
    }

    @Override
    public void operation3() {
        System.out.println("D中实现了operation3");
    }

    @Override
    public void operation4() {
        System.out.println("D中实现了operation4");
    }

    @Override
    public void operation5() {
        System.out.println("D中实现了operation5");
    }
}

class A { //A通过接口Interface1依赖(使用)B，但是只用方法123
    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend2(Interface1 i) {
        i.operation2();
    }

    public void depend3(Interface1 i) {
        i.operation3();
    }
}

class C { //C通过接口Interface1依赖(使用)C，但是只用方法145
    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend4(Interface1 i) {
        i.operation4();
    }

    public void depend5(Interface1 i) {
        i.operation5();
    }
}
