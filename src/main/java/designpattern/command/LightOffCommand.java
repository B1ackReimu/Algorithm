package designpattern.command;

public class LightOffCommand implements Command{
    LightReceiver light;

    public LightOffCommand(LightReceiver light) {
        this.light = light;
    }

    //聚合LightReceiver
    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
