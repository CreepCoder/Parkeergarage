package com.mvc.model;

import java.util.Random;

import com.car.Car;
import com.car.CarAbonnement;
import com.car.CarAdHoc;
import com.car.CarElektrische;
import com.car.CarInvalide;
import com.car.CarMotor;
import com.lib.CoreVariables;
import com.location.Location;
import com.location.LocationMap;
import com.main.Parkeergarage;
import com.mechanic.QueueCar;
import com.mechanic.Type;
import com.mvc.view.ViewGrafiek;
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
	
	public static QueueCar entranceCarQueue;
	public static QueueCar entrancePassQueue;
	public static QueueCar paymentCarQueue;
	public static QueueCar exitCarQueue;

    public static int dag = 0;
    public static int uur = 0;
    public static int minuut = 0;
    
    // average number of arriving cars per hour
    private int weekDayArrivals = 100; 
    private int weekendArrivals = 20;
    private int weekDayPassArrivals = 50;
    private int weekendPassArrivals = 10;
    private int weekDayElektrischArrivals = 22;
    private int weekendElektrischArrivals = 10;
    private int weekDayInvalideArrivals = 20;
    private int weekendInvalideArrivals = 10;
    private int weekDayMotorArrivals = 20;
    private int weekendMotorArrivals = 10;

    int enterSpeed = 3; // number of cars that can enter per minute
    int paymentSpeed = 4; // number of cars that can pay per minute
    int exitSpeed = 6; // number of cars that can leave per minute
    
    public int aantalLegeVakken = 540;
    public int aantalCarAdHoc;
    public int aantalCarAbonnement;
    public int aantalCarElektrisch;
    public int aantalCarInvalide;
    public int aantalCarMotor;
	
	public int aantalBetaaldCarAdHoc;
	public int aantalBetaaldCarParkingPass;
	public int aantalBetaaldCarElektrisch;
	public int aantalBetaaldCarInvalide;
	public int aantalBetaaldCarMotor;

	public Model() {
			entranceCarQueue = new QueueCar();
	        entrancePassQueue = new QueueCar();
	        paymentCarQueue = new QueueCar();
	        exitCarQueue = new QueueCar();
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
			tick();
		}
	}
	
	// Tick zorgt ervoor dat alles geüpdate wordt. Dit gebeurt na elke stap en wordt ook gebruikt door de knop +1
	public void tick() {
    	advanceTime();
    	ViewKlok.updateTime();
    	handleTime(dag, uur, minuut);
    	handleExit();
    	updateViews();
    	Parkeergarage.viewCarPark.updateView();	
		try {
			Thread.sleep(CoreVariables.simulatorSpeed);
		} catch (Exception e) {}
		handleEntrance();
		ViewGrafiek.updateGraph();
		ViewGrafiek.clearGraph();
	}

	    private void advanceTime(){
	        // Advance the time by one minute.
	        minuut++;
	        while (minuut > 59) {
	            minuut -= 60;
	            uur++;
	        }
	        while (uur > 23) {
	            uur -= 24;
	            dag++;
	        }
	        while (dag > 6) {
	            dag -= 7;
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
	    	Parkeergarage.viewCarPark.tick();
	        // Update the car park view.
	    	Parkeergarage.viewCarPark.updateView();	
	        
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

		Random rand = new Random();
		int  n = rand.nextInt(5) + 1;
	    
	    private void carsEntering(QueueCar queue){
	        int i=0;
	        // Remove car from the front of the queue and assign to a parking space.
	    	while (queue.carsInQueue()>0 && 
	    			Parkeergarage.viewCarPark.getNumberOfOpenSpots()>0 && 
	    			i<enterSpeed) {
	            Car car = queue.removeCar();
	            Location freeLocation = Parkeergarage.viewCarPark.getFirstFreeLocation();
	            Parkeergarage.viewCarPark.setCarAt(freeLocation, car);
	            LocationMap freeLocationMap = Parkeergarage.map.getFreePosition(car);
	            Parkeergarage.map.setCarAt(freeLocationMap, car);

	            // Statement om de bijgehoude nummers te veranderen
	            if (car.getType().equals(Type.ADHOC)) 			{aantalCarAdHoc++; aantalLegeVakken--;}
	            if (car.getType().equals(Type.ABONNEMENT)) 		{aantalCarAbonnement++; aantalLegeVakken--;}
	            if (car.getType().equals(Type.ELEKTRISCH)) 		{aantalCarElektrisch++; aantalLegeVakken--;}
	            if (car.getType().equals(Type.INVALIDE)) 		{aantalCarInvalide++; aantalLegeVakken--;}
	            if (car.getType().equals(Type.MOTOR)) 			{aantalCarMotor++; aantalLegeVakken--;}
	            i++;
	        }
	    }
	    
	    private void carsReadyToLeave(){
	        // Add leaving cars to the payment queue.
	        Car car = Parkeergarage.viewCarPark.getFirstLeavingCar();
	        while (car!=null) {
	        	if (car.getHasToPay()){
		            car.setIsPaying(true);
		            paymentCarQueue.addCar(car);
		            increaseAmmountOfCarsThatHavePaid(car.getType().getId());
	        	}
	        	else {
	        		carLeavesSpot(car);
	        	}
	            car = Parkeergarage.viewCarPark.getFirstLeavingCar();
	        }
	    }

	    private void increaseAmmountOfCarsThatHavePaid(int carId) {
	    	if (carId == 1) {
	    		aantalBetaaldCarAdHoc += 1;
	    	}
	    	else if (carId == 2) {
	    		aantalBetaaldCarParkingPass += 1;
	    	}
	    	else if (carId == 3) {
	    		aantalBetaaldCarElektrisch += 1;
	    	}
	    	else if (carId == 4) {
	    		aantalBetaaldCarInvalide += 1;
	    	}
	    	else if (carId == 5) {
	    		aantalBetaaldCarMotor += 1;
	    	}
		}

		private void carsPaying(){
	        // Let cars pay.
	    	int i=0;
	    	while (paymentCarQueue.carsInQueue()>0 && i < paymentSpeed){
	            Car car = paymentCarQueue.removeCar();
	            // Handle payment.
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
	        int averageNumberOfCarsPerHour = dag < 5
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
	            	entranceCarQueue.addCar(new CarAdHoc(Type.ADHOC));
	            }
	            break;
	    	case PASS:
	            for (int i = 0; i < numberOfCars; i++) {
	            	entrancePassQueue.addCar(new CarAbonnement(Type.ABONNEMENT));
	            }
	            break;	   
	    	case ELEKTRISCH:
	            for (int i = 0; i < numberOfCars; i++) {
	            	entrancePassQueue.addCar(new CarElektrische(Type.ELEKTRISCH));
	            }
	            break;	
	    	case INVALIDE:
	            for (int i = 0; i < numberOfCars; i++) {
	            	entrancePassQueue.addCar(new CarInvalide(Type.INVALIDE));
	            }
	            break;	
	    	case MOTOR:
	            for (int i = 0; i < numberOfCars; i++) {
	            	entrancePassQueue.addCar(new CarMotor(Type.MOTOR));
	            }
	            break;	
	    	}
	    }
	    
	    private void carLeavesSpot(Car car){
	    	Parkeergarage.viewCarPark.removeCarAt(car.getLocation());
	        exitCarQueue.addCar(car);
	        
	        /*
			if (n == 5 && car.getType() == Type.DUBBELE_PARKEERDER) {
	            Parkeergarage.map.removeCarAt(car.getLocationmap());
	            Parkeergarage.map.removeCarAt(Parkeergarage.map.getNextPosition());
			}
			*/
	        
	        if (car.getLocationmap() != null) {
	        	Parkeergarage.map.removeCarAt(car.getLocationmap());
	        }
	        
	        // Statements om de bijgehoude nummers te veranderen
	        if (car.getType().equals(Type.ADHOC)) 			{aantalCarAdHoc--; aantalLegeVakken++;}
	        if (car.getType().equals(Type.ABONNEMENT)) 		{aantalCarAbonnement--; aantalLegeVakken++;}
	        if (car.getType().equals(Type.ELEKTRISCH)) 		{aantalCarElektrisch--; aantalLegeVakken++;}
	        if (car.getType().equals(Type.INVALIDE)) 		{aantalCarInvalide--; aantalLegeVakken++;}
	        if (car.getType().equals(Type.MOTOR)) 			{aantalCarMotor--; aantalLegeVakken++;}
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
	    		weekendArrivals = 200; 
	    		weekendElektrischArrivals = 25;
	    		weekendInvalideArrivals = 25;
	    		weekendMotorArrivals = 25;
	    	}
	    }
}