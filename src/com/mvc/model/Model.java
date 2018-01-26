package com.mvc.model;

import java.util.Random;

import com.car.Car;
import com.car.CarAdHoc;
import com.car.CarElektrische;
import com.car.CarInvalide;
import com.car.CarMotor;
import com.car.CarParkingPass;
import com.lib.CoreVariables;
import com.location.Location;
import com.location.LocationMap;
import com.location.LocationType;
import com.main.Parkeergarage;
import com.mechanic.CarQueue;
import com.mvc.view.ViewGraph;
import com.mvc.view.ViewKlok;

public class Model extends AbstractModel implements Runnable {
	private int aantal;
	private boolean run;
	private boolean running;
	
	private static final String AD_HOC = "1";
	private static final String PASS = "2";
	private static final String ELEKTRISCH = "3";
	private static final String INVALIDE = "4";
	private static final String MOTOR = "5";
	
	private CarQueue entranceCarQueue;
    private CarQueue entrancePassQueue;
    private CarQueue paymentCarQueue;
    private CarQueue exitCarQueue;

    public static int day = 0;
    public static int hour = 0;
    public static int minute = 0;
    
    // average number of arriving cars per hour
    private int weekDayArrivals = 100; 
    private int weekendArrivals = 200;
    private int weekDayPassArrivals = 50;
    private int weekendPassArrivals = 5;
    private int weekDayElektrischArrivals = 22;
    private int weekendElektrischArrivals = 19;
    private int weekDayInvalideArrivals = 20;
    private int weekendInvalideArrivals = 22;
    private int weekDayMotorArrivals = 20;
    private int weekendMotorArrivals = 19;

    int enterSpeed = 6; // number of cars that can enter per minute
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
		if (aantal > 10080) {
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
			//System.out.println(getAantal());
			tick();
		}
	}
	
	// Tick zorgt ervoor dat alles geüpdate wordt. Dit gebeurt na elke stap en wordt ook gebruikt door de knop +1
	public void tick() {
    	advanceTime();
    	ViewKlok.updateTime();
    	handleTime(day, hour, minute);
    	handleExit();
    	updateViews();
    	Parkeergarage.viewcarpark.updateView();	
		try {
			Thread.sleep(CoreVariables.simulatorSpeed);
		} catch (Exception e) {}
		handleEntrance();
		ViewGraph.updateGraph(Parkeergarage.model.aantalCarAdHoc);
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
	    	// Voeg een aantal auto's toe aan het type AdHoc
	    	int numberOfCars=getNumberOfCars(weekDayArrivals, weekendArrivals);
	        addArrivingCars(numberOfCars, AD_HOC); 
	        
	        // Voeg een aantal auto's toe aan het type ParkingPass
	    	numberOfCars=getNumberOfCars(weekDayPassArrivals, weekendPassArrivals);
	        addArrivingCars(numberOfCars, PASS);
	        
	        // Voeg een aantal auto's toe aan het type Elektrisch
	        numberOfCars=getNumberOfCars(weekDayElektrischArrivals, weekendElektrischArrivals);
	        addArrivingCars(numberOfCars, ELEKTRISCH);
	        
	        // Voeg een aantal auto's toe aan het type Invalide
	        numberOfCars=getNumberOfCars(weekDayInvalideArrivals, weekendInvalideArrivals);
	        addArrivingCars(numberOfCars, INVALIDE);
	        
	        // Voeg een aantal auto's toe aan het type Motor
	        numberOfCars=getNumberOfCars(weekDayMotorArrivals, weekendMotorArrivals);
	        addArrivingCars(numberOfCars, MOTOR);
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
	            
	            LocationMap freeLocationMap = Parkeergarage.map.getFreePosition(car);
	            Parkeergarage.map.setCarAt(freeLocationMap, car);
	            
	            // Statement om de bijgehoude nummers te veranderen
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
	    	case ELEKTRISCH:
	            for (int i = 0; i < numberOfCars; i++) {
	            	entrancePassQueue.addCar(new CarElektrische(LocationType.ELEKTRISCH));
	            }
	            break;	
	    	case INVALIDE:
	            for (int i = 0; i < numberOfCars; i++) {
	            	entrancePassQueue.addCar(new CarInvalide(LocationType.INVALIDE));
	            }
	            break;	
	    	case MOTOR:
	            for (int i = 0; i < numberOfCars; i++) {
	            	entrancePassQueue.addCar(new CarMotor(LocationType.MOTOR));
	            }
	            break;	
	    	}
	    }
	    
	    private void carLeavesSpot(Car car){
	    	Parkeergarage.viewcarpark.removeCarAt(car.getLocation());
	        exitCarQueue.addCar(car);
	        
	        if (car.getLocationmap() != null) {
	        	Parkeergarage.map.removeCarAt(car.getLocationmap());
	        }
	        
	        // Statements om de bijgehoude nummers te veranderen
	        if (car.getType().equals(LocationType.AD_HOC)) 			{aantalCarAdHoc--; aantalLegeVakken++;}
	        if (car.getType().equals(LocationType.PARKING_PASS)) 	{aantalCarParkingPass--; aantalLegeVakken++;}
	        if (car.getType().equals(LocationType.ELEKTRISCH)) 		{aantalCarElektrisch--; aantalLegeVakken++;}
	        if (car.getType().equals(LocationType.INVALIDE)) 		{aantalCarInvalide--; aantalLegeVakken++;}
	        if (car.getType().equals(LocationType.MOTOR)) 			{aantalCarMotor--; aantalLegeVakken++;}
	    }
	    
	    private void handleTime(int dag, int uur, int minuut) {
	    	// Tussen 00:00 en 07:00 (ochtendspits)
	    	if (dag < 5 && uur == 0) {
	    	    weekDayArrivals = 20; 
	    	    weekDayPassArrivals = 10;
	    	    weekDayElektrischArrivals = 5;
	    	    weekDayInvalideArrivals = 5;
	    	    weekDayMotorArrivals = 5;
	    	}
	    	
	    	else if (dag < 5 && uur == 6) {
	    	    weekDayArrivals = 100; 
	    	    weekDayPassArrivals = 50;
	    	    weekDayElektrischArrivals = 22;
	    	    weekDayInvalideArrivals = 20;
	    	    weekDayMotorArrivals = 20;
	    	}
	    	
	    	// Tussen 16:00 en 19:00 (avondspits)
	    	if (dag < 5 && uur == 16) {
	    	    weekDayArrivals = 50; 
	    	    weekDayPassArrivals = 25;
	    	    weekDayElektrischArrivals = 18;
	    	    weekDayInvalideArrivals = 15;
	    	    weekDayMotorArrivals = 15;
	    	}
	    	
	    	else if ((dag < 3 || dag == 4) && uur == 20) {
	    	    weekDayArrivals = 20; 
	    	    weekDayPassArrivals = 10;
	    	    weekDayElektrischArrivals = 5;
	    	    weekDayInvalideArrivals = 5;
	    	    weekDayMotorArrivals = 5;
	    	}
	    	
	    	// Donderdagavond is er een voorstelling in het theater in de buurt
	    	if (dag == 3 && uur == 20 && minuut == 1) {
	    	    weekDayArrivals = 300; 
	    	    weekDayPassArrivals = 20;
	    	    weekDayElektrischArrivals = 30;
	    	    weekDayInvalideArrivals = 40;
	    	    weekDayMotorArrivals = 26;
	    	}
	    	
	    	else if (dag == 3 && uur == 22 && minuut == 30) {
	    	    weekDayArrivals = 20; 
	    	    weekDayPassArrivals = 10;
	    	    weekDayElektrischArrivals = 5;
	    	    weekDayInvalideArrivals = 5;
	    	    weekDayMotorArrivals = 5;
	    	}
	    	
	    	// Zaterdag
	    	if (dag == 5 && uur == 1 && minuut == 0) {
	    	    weekendArrivals = 20; 
	    	    weekendElektrischArrivals = 10;
	    	    weekendInvalideArrivals = 10;
	    	    weekendMotorArrivals = 10;
	    	}
	    	else if (dag == 5 && uur == 8 && minuut == 0) {
	    		weekendArrivals = 180; 
	    		weekendElektrischArrivals = 20;
	    		weekendInvalideArrivals = 20;
	    		weekendMotorArrivals = 20;
	    	}
	    	
	    	// Zondag koopzondag
	    	if (dag == 6 && uur == 1 && minuut == 0) {
	    		weekendArrivals = 30; 
	    		weekendElektrischArrivals = 10;
	    		weekendInvalideArrivals = 10;
	    		weekendMotorArrivals = 10;
	    	}
	    	
	    	else if (dag == 6 && uur == 10 && minuut == 0) {
	    		weekendArrivals = 250; 
	    		weekendElektrischArrivals = 25;
	    		weekendInvalideArrivals = 25;
	    		weekendMotorArrivals = 25;
	    	}
	    }
}