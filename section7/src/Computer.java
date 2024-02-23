public class Computer {
    private int id;
    private boolean isOn;
    private boolean isUsing;

    public Computer(int id) {
        this.id = id;
        this.isOn = false;
        this.isUsing = false;
    }

    public int getId() {
        return id;
    }

    public boolean isOn() {
        return isOn;
    }

    public boolean isUsing() {
        return isUsing;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public void startUsing() {
        isUsing = true;
    }

    public void stopUsing() {
        isUsing = false;
    }
}
