package designpattern.composite;

public class Department extends OrganizationComponent{


    public Department(String name, String des) {
        super(name, des);
    }

    @Override
    protected void print() {
        System.out.println(getName());
    }

    //叶子节点，不需要remove add


    @Override
    public String getDes() {
        return super.getDes();
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
