package designpattern.command;

public class LightOnCommand implements Command{

    LightReceiver light;

    public LightOnCommand(LightReceiver light) {
        this.light = light;
    }

    //聚合LightReceiver
    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
