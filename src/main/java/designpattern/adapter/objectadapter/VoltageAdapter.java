package designpattern.adapter.objectadapter;

//被适配的类
public class VoltageAdapter implements IVoltage5V {
    private Voltage220V voltage220V; //关联关系-聚合

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int src = voltage220V.output220V();
        System.out.println("使用对象适配器进行转换");
        return src / 44;
    }
}
