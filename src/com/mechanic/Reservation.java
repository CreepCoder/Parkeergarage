package com.mechanic;

import java.util.Scanner;

public class Reservation {
    private static Scanner aScanner;
    public static void main(String[] args) {
        System.out.println("Welcome to St John's Central Retreat for the Mentally Fatigued.");
        Scanner aScanner = new Scanner(System.in);
        System.out.println("To begin, please indicate how many people will be staying. ");
        int numberOfGuests = aScanner.nextInt();
        System.out.println("Thank you. Now please tell us how long you plan on staying at our fine resort. ");
        int numberOfNights = aScanner.nextInt();
        int singleRoom = numberOfGuests * 95 * numberOfNights;
        int doubleRoom = numberOfGuests * 80 * numberOfNights;
        int supplementalSingle = numberOfGuests * 65;
        int supplementalDouble = numberOfGuests * 50;
        if (numberOfNights <=2 && numberOfGuests == 1) {
                       System.out.println("For" + numberOfGuests + " guest staying for " +
                                          numberOfNights + " nights, it will cost " + "€" + singleRoom);
        } 
        else if (numberOfNights <=2 && numberOfGuests >1) { 
                       System.out.println("For " + numberOfGuests + " guests staying for " + 
                                          numberOfNights + " nights, it will cost " + "€" + doubleRoom);
        }
        else if (numberOfNights >2 && numberOfGuests == 1) {
                       System.out.println("For" + numberOfGuests + " guest staying for " + 
                                          numberOfNights + " nights, it will cost " + "€");
        }
     
    }
 
 
}