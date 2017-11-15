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
/*  type3.java   (a subclass)   */
public class type3 extends LongPipes {
    
    double price = 0; // Used to calculate cost with or without chem resistance.
    
    public type3() {   
    }
    
    public type3(double length, double outerd, int quantity, boolean chem) {
        super(length, outerd, quantity, chem);
    }
    
    protected double cost() {
        price = ((Math.PI * (Math.pow((outerd / 2), 2)) * length) - (Math.PI * (Math.pow((innerd / 2), 2)) * length)) * 0.75; 
        if (chem == true) {
           price += price * 0.14 + price * 0.16;
        } else price += price * 0.16;   // 2 colours adds 16% of base price to cost.
        double cost = price * quantity;
        return cost;
    }    
}