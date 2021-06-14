/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Scanner;

/**
 *
 * @author Bhai Aziz
 */
public class Order {
    int id;
    int     total_price;
    int     total_discount;
    Cart cart;
    PaymentOptions payment;
    static int id_count=0;
    
    
    public Order(int total_price, int discount_percentage,Cart cart) {
        this.total_price = total_price;
        this.total_discount = discount_percentage;
        this.cart = cart;
        id = id_count++;
    }
    
    public void AddPaymentMethod(){
        System.out.print("\nEnter PaymentOptions :\t");
        Scanner s = new Scanner(System.in);
        
        String pay = s.nextLine();
        
        if(pay.equalsIgnoreCase("PAYPAL")){
            System.out.print("\nEnter Country :\t");
            String country = s.nextLine();
            System.out.print("\nEnter Paypal Id :\t");
            int Id = s.nextInt();
            s.nextLine();
            payment=new Paypal(country,Id);
        }
        else if(pay.equalsIgnoreCase("CARD")){
            System.out.print("\nEnter Card Type :\t");
            String country = s.nextLine();
            System.out.print("\nEnter Card No :\t");
            String Id = s.nextLine();
            payment=new Card(country,Id);
        }
        else if(pay.equalsIgnoreCase("EASYPAISA")){
            System.out.print("\nEnter Card Type :\t");
            String country = s.nextLine();
            System.out.print("\nEnter Card No :\t");
            String Id = s.nextLine();
            payment=new EasyPaisa(country,Id);
        }

    }
    
    public Order() {
    }

    void PrintDetails(){

        System.out.printf("\nPrice :\t%d", total_price);
        System.out.printf("\nDiscount :\t%s", total_discount);
        //System.out.printf("\nCategory :\t%s", category);
    }
}
