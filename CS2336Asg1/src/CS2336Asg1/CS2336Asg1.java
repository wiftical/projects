//Written by Chinenyenwa Muoneke for CS2336.504
//Assignment 1, starting August 26, 2020
//NetID: CXM190008
//Professor John Cole
//The purpose of this program is to convert units of weight, temperature and distance 
//between each other based on users input and choice
package CS2336Asg1;

//import scanner
import java.util.Scanner;

//CS2336Asg1 class
public class CS2336Asg1 {

    //main method
    public static void main(String[] args) {
        //name and initialize variables
        int choice = 0;
        double measurement = 0;
        //instantiate respective classes
        Temperature temp = new Temperature();
        Weight wt = new Weight();
        Distance dist = new Distance();
        //call scanner
        Scanner input = new Scanner(System.in);
        //loop for picking option to run and solve until user wants to exit
        while (choice != 7) {
            //display options
            //prompt user to choose a selection
            System.out.println("Choose a option: ");
            System.out.println("1 to Convert Fahrenheit to Celsius");
            System.out.println("2 to Convert Celsius to Fahrenheit");
            System.out.println("3 to Convert pounds to kilograms");
            System.out.println("4 to Convert kilograms to pounds");
            System.out.println("5 to Convert miles to kilometers");
            System.out.println("6 to Convert kilometers to miles");
            System.out.println("7 to Exit the program.");
            choice = input.nextInt();
            //if user doesnt choose to exit and choice is valid enter loop
            while (choice >= 1 && choice <= 6) {
                //prompt user to enter value they want to convert
                System.out.println("Enter value to convert: ");
                measurement = input.nextDouble();
                //if value is negative for option 3-6 
                //display error message and continue loop
                if (measurement < 0 && choice > 2) {
                    System.out.println("Value cannot be less than 0 for option 3-6, please re-enter.");
                } //display value if all conditions are met and break loop
                //i put it here so i dont have to write this for each case in switch statement
                else {
                    System.out.print(String.format("%.2f", measurement));
                    break;
                }
            }
                //switch statemant
                switch (choice) {
                    case 1:
                        //if option 1 picked call method to covert Fahrenheit to Celsius
                        System.out.println("°F converts to " + String.format("%.2f", temp.fahrenheitToC(measurement)) + "°C.");
                        break;
                    case 2:
                        //if option 2 picked call method to covert Celsius to Fahrenheit
                        System.out.println("°C converts to " + String.format("%.2f", temp.celsiusToF(measurement)) + "°F.");
                        break;
                    case 3:
                        //if option 3 picked call method to covert pounds to kilograms
                        System.out.println(" lb converts to " + String.format("%.2f", wt.poundsToK(measurement)) + " kg.");
                        break;
                    case 4:
                        //if option 4 picked call method to covert kilograms to pounds
                        System.out.println(" kg converts to " + String.format("%.2f", wt.KilogramsToP(measurement)) + " lb.");
                        break;
                    case 5:
                        //if option 5 picked call method to covert miles to kilometers
                        System.out.println(" km converts to " + String.format("%.2f", dist.metersToK(measurement)) + " m.");
                        break;
                    case 6:
                        //if option 6 picked call method to covert kilometers to miles
                        System.out.println(" m converts to " + String.format("%.2f", dist.kilometersToM(measurement)) + " km.");
                        break;
                    case 7:
                        //if option 7 picked display message and end program
                        System.out.println("Exiting program.");
                        break;
                    default:
                        //default case when invalid number inputed
                        System.out.println("Invalid option, please re-enter.");
                        break;
                }
                //empty line to seperate loops
                System.out.println();
            }
        }
    }