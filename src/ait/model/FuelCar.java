package ait.model;

public class FuelCar extends Car{
    private String fuel;

    public FuelCar(String regNumber, String model, String company, double engine, String color, String fuel) {
        super(regNumber, model, company, engine, color);
        this.fuel = fuel;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", fuel: " + fuel;
    }
}
