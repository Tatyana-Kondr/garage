package ait.tests;

import ait.dao.Garage;
import ait.dao.GarageImpl;
import ait.model.Car;
import ait.model.ElectroCar;
import ait.model.FuelCar;
import ait.model.Motorcycle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageImplTest {
    Garage garage;
    Car[] cars;

    @BeforeEach
    void setUp() {
        garage = new GarageImpl(7);
        cars = new Car[6];
        cars[0] = new ElectroCar("Number1", "Model1", "Company1", 1.5, "Red", 60, 200);
        cars[1] = new FuelCar("Number2", "Model2", "Company1", 2.5, "Green", "diesel");
        cars[2] = new Motorcycle("Number3", "Model3", "Company2", 1.5, "Black", 150);
        cars[3] = new FuelCar("Number4", "Model4", "Company2", 2.0, "Green", "petrol");
        cars[4] = new FuelCar("Number5", "Model5", "Company3", 3.0, "Red", "petrol");
        cars[5] = new ElectroCar("Number6", "Model1", "Company3", 1.5, "White", 65,320);

        for (int i = 0; i < cars.length; i++) {
            garage.addCar(cars[i]);
        }
    }
    @Test
    void addCarTest(){
        printArray(cars, "before add");
        assertFalse(garage.addCar(null));
        assertFalse(garage.addCar(cars[0]));
        Car car = new Motorcycle("Number7", "Model1", "Company2", 2.5, "Blue", 200);
        assertTrue(garage.addCar(car));
        car = new Motorcycle("Number8", "Model1", "Company2", 2.5, "Black", 200);
        assertFalse(garage.addCar(car));
        garage.printCars();
    }
    @Test
    void removeCarTest(){
        assertEquals(cars[1], garage.removeCar("Number2"));
        assertNull(garage.removeCar("Number2"));
        assertNull(garage.findCarByRegNumber("Number2"));
        garage.printCars();
    }
    @Test
    void findCarByRegNumber(){
        Car car = garage.findCarByRegNumber("Number4");
        assertEquals(cars[3],car);
        assertEquals(cars[3], garage.findCarByRegNumber(new String("Number4")));
        assertNull(garage.findCarByRegNumber("Number10"));
        System.out.println(car);
    }
    @Test
    void findCarsByModelTest() {
        Car[] expected = { cars[0], cars[5] };
        Car[] actual = garage.findCarsByModel(new String("Model1"));
        assertArrayEquals(expected, actual);
        printArray(actual, "actual array");
    }
    @Test
    void findCarsByCompany() {
        Car[] expected = { cars[2], cars[3] };
        Car[] actual = garage.findCarsByCompany("Company2");
        assertArrayEquals(expected, actual);
        printArray(actual, "actual array");
    }

    @Test
    void findCarsByEngine() {
        Car[] expected = { cars[1], cars[3] };
        Car[] actual = garage.findCarsByEngine(1.9, 2.6);
        assertArrayEquals(expected, actual);
        printArray(actual, "actual array");
    }

    @Test
    void findCarsByColor() {
        Car[] expected = { cars[0], cars[4] };
        Car[] actual = garage.findCarsByColor(new String("Red"));
        assertArrayEquals(expected, actual);
        printArray(actual, "actual array");
    }
    @Test
    void printCarsTest(){
        garage.printCars();
    }

    public void printArray(Object[] arr, String title){
        System.out.println("-----------------------" + title + " -----------------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}