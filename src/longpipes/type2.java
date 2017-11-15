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
/*  type2.java   (a subclass)   */
public class type2 extends LongPipes {
    
    double price = 0; // Used to calculate cost with or without chem resistance.
    
    public type2() {  
    }
    
    public type2(double length, double outerd, int quantity, boolean chem) {
        super(length, outerd, quantity, chem);
    }
    
    protected double cost() {
        price = ((Math.PI * (Math.pow((outerd / 2), 2)) * length) - (Math.PI * (Math.pow((innerd / 2), 2)) * length)) * 0.6; 
        if (chem == true) {
           price += price * 0.14 + price * 0.12;
        } else price += price * 0.12;   // One colour adds 12% of base price to cost.
        double cost = price * quantity;
        return cost;
    }    
}
