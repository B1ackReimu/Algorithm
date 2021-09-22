package designpattern.adapter.classadapter;

//被适配的类
public class VoltageAdapter extends Voltage220V implements IVoltage5V {
    @Override
    public int output5V() {
        int src = output220V();
        return src / 44;
    }
}
