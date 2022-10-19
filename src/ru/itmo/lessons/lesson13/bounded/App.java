package ru.itmo.lessons.lesson13.bounded;

public class App {
    public static void main(String[] args) {
        Train train = (Train) Vehicle.getVehicle("train");
        System.out.println(train.getCarCount());

        Car car = (Car) Vehicle.getVehicle("car");
        System.out.println(car.getNum());

        Bicycle bike = (Bicycle) Vehicle.getVehicle("bike");
        System.out.println(bike.getType());

        // public class Garage<T extends Vehicle & Repair>
        // Car extends Vehicle implements Repair
        Garage<Car> carGarage = new Garage<>();
        carGarage.setVehicle(car);
        System.out.println(carGarage.getVehicle().getNum());

        Garage<Bicycle> bicycleGarage = new Garage<>();
        bicycleGarage.setVehicle(bike);
        System.out.println(bicycleGarage.getVehicle().getType());
    }
}