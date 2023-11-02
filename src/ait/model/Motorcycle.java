package ait.model;

public class Motorcycle extends Car{
    private int weight;

    public Motorcycle(String regNumber, String model, String company, double engine, String color, int weight) {
        super(regNumber, model, company, engine, color);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", weight: " + weight;
    }
}
