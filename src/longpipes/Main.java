/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longpipes;

/**
 *
 * @author Jason
 */
/*  Main.java  */
import java.lang.Math.*;
import java.io.*;
import java.util.*;  // you need this for the Scanner class


public class Main{  
    
    static int grade, colours, quantity = 0;
    static boolean insul, reinf, chem = false;
    static double total, length, outerd, innerd = 0;
    
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);  //object of Scanner class
        for(int i = 0; i < 10; i++) {   // max of 10 orders (or stop by typing false when prompted)
            System.out.println("Input required length of pipe in Meters:");
            length = (console.nextDouble()) * 39.37;
            System.out.println("Input outer diameter of pipe in Inches:");
            outerd = console.nextDouble();
            innerd = outerd * 0.9;
            System.out.println("Input plastic grade  from 1-5:");
            grade = console.nextInt();
            System.out.println("Input required number of colours from 0-2:");
            colours = console.nextInt();
            System.out.println("Inner insulation? (true/false):");
            insul = console.nextBoolean();
            System.out.println("Outer reinforcement? (true/false):");
            reinf = console.nextBoolean();
            System.out.println("Chemical resistance? (true/false):");
            chem = console.nextBoolean();
            System.out.println("Input required quantity of pipe (max 10):");
            quantity = console.nextInt();
        
            if (grade > 0 && grade < 4 && colours == 0 && insul == false && reinf == false) {   // 'brute force' to determine what type of pipe is required.
                type1 pipe1 = new type1(length, outerd, quantity, chem);    // creates a new object of the specified type using the inputted values.
                total += pipe1.cost();  // adds the new objects cost to the total cost of the ordering session.
                System.out.println("pipe cost = "+ Math.round(pipe1.cost())); // returns the cost of the order
            } else if (grade > 1 && grade < 5 && colours == 1 && insul == false && reinf == false) {
                type2 pipe2 = new type2(length, outerd, quantity, chem); 
                total += pipe2.cost();
                System.out.println("pipe cost = "+ Math.round(pipe2.cost()));
            } else if (grade > 1 && grade < 6 && colours == 2 && insul == false && reinf == false) {
                type3 pipe3 = new type3(length, outerd, quantity, chem); 
                total += pipe3.cost();
                System.out.println("pipe cost = "+ Math.round(pipe3.cost()));
            } else if (grade > 1 && grade < 6 && colours == 2 && insul == true && reinf == false) {
                type4 pipe4 = new type4(length, outerd, quantity, chem); 
                total += pipe4.cost();
                System.out.println("pipe cost = "+ Math.round(pipe4.cost())); 
            } else if (grade > 1 && grade < 6 && colours == 2 && insul == true && reinf == true) {
                type5 pipe5 = new type5(length, outerd, quantity, chem); 
                total += pipe5.cost();
                System.out.println("pipe cost = "+ Math.round(pipe5.cost())); 
         }
            System.out.println("Do you want to create another order? (true/false)");
            if (console.nextBoolean() == false ) {
                break;
            }
        }
        
        System.out.println("Total cost of order = " + Math.round(total));   // prints total costof all orders after order loop has ended.
    }  
}
