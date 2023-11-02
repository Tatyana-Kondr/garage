package ait.dao;

import ait.model.Car;

import java.util.Arrays;
import java.util.function.Predicate;

public class GarageImpl implements Garage{
    private Car[] cars;
    private int size;

    public GarageImpl(int capacity){
        cars = new Car[capacity];
    }
    @Override
    public boolean addCar(Car car) {
        if(car == null || size == cars.length || findCarByRegNumber(car.getRegNumber()) != null){
            return false;
        }
        cars[size++] = car;
        return true;
    }

    @Override
    public Car removeCar(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (regNumber.equals(cars[i].getRegNumber())) {
                Car temp = cars[i];
                System.arraycopy(cars, i + 1, cars, i, size - i - 1);
                cars[--size] = null;
                return temp;
            }
        }
        return null;
    }

    @Override
    public Car findCarByRegNumber(String regNumber) {
        for (int i = 0; i < size; i++) {
            if(cars[i].getRegNumber().equals(regNumber)){
                return cars[i];
            }
        }
        return null;
    }

    @Override
    public Car[] findCarsByModel(String model) {
        return findCarsByPredicate(c -> model.equals(c.getModel()));
    }

    @Override
    public Car[] findCarsByCompany(String company) {
        return findCarsByPredicate(c -> company.equals(c.getCompany()));
    }

    @Override
    public Car[] findCarsByEngine(double min, double max) {
        return findCarsByPredicate(c -> c.getEngine() >= min && c.getEngine() < max);
    }

    @Override
    public Car[] findCarsByColor(String color) {
        return findCarsByPredicate(c -> c.getColor().equals(color));
    }

    @Override
    public void printCars() {
        System.out.println("----------------------------------------------");
        for (int i = 0; i < size; i++) {
            System.out.println(cars[i]);
        }
    }

    private Car[] findCarsByPredicate(Predicate<Car> predicate) {
        Car[] res = new Car[size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if(predicate.test(cars[i])){
                res[index] = cars[i];
                index++;
            }
        }
        return Arrays.copyOf(res, index);
    }

}
