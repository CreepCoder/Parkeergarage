package com.mvc.model;

import java.util.Random;

import com.car.Car;
import com.car.CarAdHoc;
import com.car.CarParkingPass;
import com.car.CarType;
import com.car.Location;
import com.lib.CoreVariables;
import com.location.LocationType;
import com.main.Parkeergarage;
import com.mechanic.CarQueue;

public class Model extends AbstractModel implements Runnable {
	private int aantal;
	private boolean run;
	private boolean running;
	
	private static final String AD_HOC = "1";
	private static final String PASS = "2";
	
	private CarQueue entranceCarQueue;
    private CarQueue entrancePassQueue;
    private CarQueue paymentCarQueue;
    private CarQueue exitCarQueue;

    public static int day = 0;
    public static int hour = 0;
    public static int minute = 0;
    
    int weekDayArrivals= 100; // average number of arriving cars per hour
    int weekendArrivals = 200; // average number of arriving cars per hour
    int weekDayPassArrivals= 50; // average number of arriving cars per hour
    int weekendPassArrivals = 5; // average number of arriving cars per hour

    int enterSpeed = 3; // number of cars that can enter per minute
    int paymentSpeed = 7; // number of cars that can pay per minute
    int exitSpeed = 5; // number of cars that can leave per minute
    
    public int aantalLegeVakken = 540;
    public int aantalCarAdHoc;
    public int aantalCarParkingPass;
    public int aantalCarElektrisch;
    public int aantalCarInvalide;
    public int aantalCarMotor;
	
	public Model() {
			entranceCarQueue = new CarQueue();
	        entrancePassQueue = new CarQueue();
	        paymentCarQueue = new CarQueue();
	        exitCarQueue = new CarQueue();
	}
	
	public int getAantal() {
		return aantal;
	}
	
	public void setAantal(int aantal) {
		if (aantal>=0 && aantal <=10080) {
			this.aantal=aantal;
			notifyViews();
		}
		if (aantal > 10000) {
			stop();
		}
	}
	
	public void start() {
		if (running == false) {
		new Thread(this).start();
		running = true;
		}
	}
	
	public void stop() {
		run = false;
		running = false;
	}
	
	@Override
	public void run() {
		run=true;
		while(run) {
			setAantal(getAantal()+1);
			System.out.println(getAantal());
			tick();
		}
	}
	
	// Tick zorgt ervoor dat alles geüpdate wordt. Dit gebeurt na elke stap en wordt ook gebruikt door de knop +1
	public void tick() {
    	advanceTime();
    	handleExit();
    	updateViews();
    	Parkeergarage.viewcarpark.updateView();	
		try {
			Thread.sleep(CoreVariables.simulatorSpeed);
		} catch (Exception e) {}
		handleEntrance();
	}

	    private void advanceTime(){
	        // Advance the time by one minute.
	        minute++;
	        while (minute > 59) {
	            minute -= 60;
	            hour++;
	        }
	        while (hour > 23) {
	            hour -= 24;
	            day++;
	        }
	        while (day > 6) {
	            day -= 7;
	        }

	    }

	    private void handleEntrance(){
	    	carsArriving();
	    	carsEntering(entrancePassQueue);
	    	carsEntering(entranceCarQueue);  	
	    }
	    
	    private void handleExit(){
	        carsReadyToLeave();
	        carsPaying();
	        carsLeaving();
	    }
	    
	    private void updateViews(){
	    	Parkeergarage.viewcarpark.tick();
	        // Update the car park view.
	    	Parkeergarage.viewcarpark.updateView();	
	        
	    }
	    
	    private void carsArriving(){
	    	int numberOfCars=getNumberOfCars(weekDayArrivals, weekendArrivals);
	        addArrivingCars(numberOfCars, AD_HOC);    	
	    	numberOfCars=getNumberOfCars(weekDayPassArrivals, weekendPassArrivals);
	        addArrivingCars(numberOfCars, PASS);    	
	    }

	    private void carsEntering(CarQueue queue){
	        int i=0;
	        // Remove car from the front of the queue and assign to a parking space.
	    	while (queue.carsInQueue()>0 && 
	    			Parkeergarage.viewcarpark.getNumberOfOpenSpots()>0 && 
	    			i<enterSpeed) {
	            Car car = queue.removeCar();
	            Location freeLocation = Parkeergarage.viewcarpark.getFirstFreeLocation();
	            Parkeergarage.viewcarpark.setCarAt(freeLocation, car);
	            // Statement om de bijgehoude numemrs te veranderen
	            if (car.getType().equals(LocationType.AD_HOC)) 			{aantalCarAdHoc++; aantalLegeVakken--;}
	            if (car.getType().equals(LocationType.PARKING_PASS)) 	{aantalCarParkingPass++; aantalLegeVakken--;}
	            if (car.getType().equals(LocationType.ELEKTRISCH)) 		{aantalCarElektrisch++; aantalLegeVakken--;}
	            if (car.getType().equals(LocationType.INVALIDE)) 		{aantalCarInvalide++; aantalLegeVakken--;}
	            if (car.getType().equals(LocationType.MOTOR)) 			{aantalCarMotor++; aantalLegeVakken--;}
	            i++;
	        }
	    }
	    
	    private void carsReadyToLeave(){
	        // Add leaving cars to the payment queue.
	        Car car = Parkeergarage.viewcarpark.getFirstLeavingCar();
	        while (car!=null) {
	        	if (car.getHasToPay()){
		            car.setIsPaying(true);
		            paymentCarQueue.addCar(car);
	        	}
	        	else {
	        		carLeavesSpot(car);
	        	}
	            car = Parkeergarage.viewcarpark.getFirstLeavingCar();
	        }
	    }

	    private void carsPaying(){
	        // Let cars pay.
	    	int i=0;
	    	while (paymentCarQueue.carsInQueue()>0 && i < paymentSpeed){
	            Car car = paymentCarQueue.removeCar();
	            // TODO Handle payment.
	            carLeavesSpot(car);
	            i++;
	    	}
	    }
	    
	    private void carsLeaving(){
	        // Let cars leave.
	    	int i=0;
	    	while (exitCarQueue.carsInQueue()>0 && i < exitSpeed){
	            exitCarQueue.removeCar();
	            i++;
	    	}	
	    }
	    
	    private int getNumberOfCars(int weekDay, int weekend){
	        Random random = new Random();

	        // Get the average number of cars that arrive per hour.
	        int averageNumberOfCarsPerHour = day < 5
	                ? weekDay
	                : weekend;

	        // Calculate the number of cars that arrive this minute.
	        double standardDeviation = averageNumberOfCarsPerHour * 0.3;
	        double numberOfCarsPerHour = averageNumberOfCarsPerHour + random.nextGaussian() * standardDeviation;
	        return (int)Math.round(numberOfCarsPerHour / 60);	
	    }
	    
	    private void addArrivingCars(int numberOfCars, String type){
	        // Add the cars to the back of the queue.
	    	switch(type) {
	    	case AD_HOC: 
	            for (int i = 0; i < numberOfCars; i++) {
	            	entranceCarQueue.addCar(new CarAdHoc(LocationType.AD_HOC));
	            }
	            break;
	    	case PASS:
	            for (int i = 0; i < numberOfCars; i++) {
	            	entrancePassQueue.addCar(new CarParkingPass(LocationType.PARKING_PASS));
	            }
	            break;	            
	    	}
	    }
	    
	    private void carLeavesSpot(Car car){
	    	Parkeergarage.viewcarpark.removeCarAt(car.getLocation());
	        exitCarQueue.addCar(car);
	        
	        // Statements om de bijgehoude nummers te veranderen
	        if (car.getType().equals(LocationType.AD_HOC)) 			{aantalCarAdHoc--; aantalLegeVakken++;}
	        if (car.getType().equals(LocationType.PARKING_PASS)) 	{aantalCarParkingPass--; aantalLegeVakken++;}
	        if (car.getType().equals(LocationType.ELEKTRISCH)) 		{aantalCarElektrisch--; aantalLegeVakken++;}
	        if (car.getType().equals(LocationType.INVALIDE)) 		{aantalCarInvalide--; aantalLegeVakken++;}
	        if (car.getType().equals(LocationType.MOTOR)) 			{aantalCarMotor--; aantalLegeVakken++;}
	    }
}