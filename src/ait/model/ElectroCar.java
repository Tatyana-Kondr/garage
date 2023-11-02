package ait.model;

public class ElectroCar extends Car{
    private int battery;
    private int range;

    public ElectroCar(String regNumber, String model, String company, double engine, String color, int battery, int range) {
        super(regNumber, model, company, engine, color);
        this.battery = battery;
        this.range = range;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", battery: " + battery +
                ", range: " + range;
    }
}
