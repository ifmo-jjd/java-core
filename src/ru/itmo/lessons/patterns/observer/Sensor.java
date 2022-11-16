package ru.itmo.lessons.patterns.observer;

import java.util.ArrayList;

public class Sensor {
    private double windSpeed;
    private ArrayList<WindObserver> observers;

    public Sensor() {
        observers = new ArrayList<>(15);
    }

    public void changeSpeed(double newSpeed){
        if (windSpeed != newSpeed) {
            windSpeed = newSpeed;
            notifyObservers();
        }
    }

    private void notifyObservers(){
        // observers.forEach(observer -> observer.notifyOb(windSpeed));

        // логика оповещения слушателей / наблюдателей
        if (windSpeed > 20) observers.forEach(observer -> observer.high(windSpeed));
        else if (windSpeed > 8) observers.forEach(observer -> observer.medium(windSpeed));
        else observers.forEach(observer -> observer.low(windSpeed));
    }

    public void addObserver(WindObserver observer){
        observers.add(observer);
    }

    public void removeObserver(WindObserver observer) {
        observers.remove(observer);
    }
}
