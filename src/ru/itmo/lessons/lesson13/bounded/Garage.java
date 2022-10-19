package ru.itmo.lessons.lesson13.bounded;

// <T> - в классе можно вызывать только методы Object
// при создании объекта T - любой тип

// <T extends Vehicle> - в классе можно вызвать методы Vehicle
// и его родителей
// при создании объекта T - любой тип, который наследуется от Vehicle
// или является типом Vehicle

// <T extends Vehicle & Repair> - в классе можно вызвать методы Vehicle,
// его родителей и методы интерфейса Repair
// при создании объекта T - любой тип, который наследуется от Vehicle
// И реализует интерфейс Repair

// через & можно добавить несколько интерфейсов
public class Garage<T extends Vehicle & Repair> {
    private T vehicle;

    public void startRepair(){
        // vehicle.hashCode(); <T>
        // vehicle.changeColor(); <T extends Vehicle>
        // vehicle.repair(); <T extends Vehicle & Repair>

    }

    public T getVehicle() {
        return vehicle;
    }

    public void setVehicle(T vehicle) {
        this.vehicle = vehicle;
    }
}