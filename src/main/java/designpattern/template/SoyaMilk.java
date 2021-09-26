package designpattern.template;

public abstract class SoyaMilk {

    //模板方法final，防止子类覆盖

    final void make(){
        select();
        addCondiments();
        soak();
        beat();
    }

    void select(){
        System.out.println("第一步：选好黄豆");
    }

    abstract void addCondiments();

    void soak(){
        System.out.println("第三步，黄豆和配料开始浸泡");
    }

    void beat(){
        System.out.println("第四步，打豆浆");
    }
}
