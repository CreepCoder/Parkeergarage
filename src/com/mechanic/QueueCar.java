package com.mechanic;
import java.util.LinkedList;
import java.util.Queue;

import com.car.Car;

public class QueueCar {
    private Queue<Car> queue = new LinkedList<>();

    public boolean addCar(Car car) {
        return queue.add(car);
    }

    public Car removeCar() {
        return queue.poll();
    }

    public int carsInQueue(){
    	return queue.size();
    }
}
