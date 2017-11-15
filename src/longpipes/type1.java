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
/*  type1.java  (a subclass)   */
public class type1 extends LongPipes {
    
    double price = 0; // Used to calculate cost with or without chem resistance.
    
    public type1() {  
    }
    
    public type1(double length, double outerd, int quantity, boolean chem) {
        super(length, outerd, quantity, chem);
    }
    
    protected double cost() {   // area of material multiplied by price per inch (for pipe type) plus any added costs
        price = ((Math.PI * (Math.pow((outerd / 2), 2)) * length) - (Math.PI * (Math.pow((innerd / 2), 2)) * length)) * 0.4;  
        if (chem == true) {
           price += price * 0.14;   // if chem is true add the 14% of base price
        } 
        double cost = price * quantity;
        return cost;
    }    
}