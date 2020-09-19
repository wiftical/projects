//Written by Chinenyenwa Muoneke for CS2336.504
//Assignment 1, starting September 6, 2020
//NetID: CXM190008
//Professor John Cole
//The purpose of this program is to recognize 
//patterns (4 instances of the same number)read from a file. 
package cs2336asg2.cxm190008;

//imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//CS2336Asg2Cxm190008 class
public class CS2336Asg2Cxm190008 {

    //main method
    public static void main(String[] args) throws FileNotFoundException {

        //initialize
        String filename = " ";

        //full program loop
        while (true) {

            //file prompt loop
            while (true) {

                //prompt user for file name
                Scanner prompt = new Scanner(System.in);
                System.out.println("Input filename:");
                System.out.println("Enter \"*\" to exit program");
                filename = prompt.nextLine().trim();
                java.io.File file = new File(filename);

                //check files existance
                //if file doesnt exist display error message
                if (!file.exists() && !filename.equals("*")) {
                    System.out.println("Could not open filename \"" + filename + "\", please re-enter.");
                    System.out.println();
                } else {
                    //exit loop if file exists
                    break;
                }
            }
            System.out.println();

            //exit program if prompted to
            if (filename.equals("*")) {
                break;
            }

            //call Work class and its methods
            Work check = new Work();

            //find patterns and display
            check.findPattern(filename);
            System.out.println();
        }
    }
}
