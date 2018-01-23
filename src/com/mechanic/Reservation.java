package com.mechanic;
import java.util.Random;

// Een klasse voor het reserveren van parkeerplekken in de parkeergarage.
public class Reservation {
	static Random parkeerplaats = new Random();
	static int p = parkeerplaats.nextInt(300) + 1;

	
public static void main (String[] args)
{	CheckIfFree(p);
}

public static void CheckIfFree(int i)
{
	// System.out.println("" + i);

}


}
