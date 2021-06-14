/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Bhai Aziz
 */
public class Paypal extends PaymentOptions{
    String country;
    int    paypalid;

    public Paypal() {
    }

    public Paypal(String country, int paypalid, int id, int balance) {
        super(id, balance);
        this.country = country;
        this.paypalid = paypalid;
    }

    public Paypal(String country, int paypalid) {
        this.country = country;
        this.paypalid = paypalid;
    }

    public Paypal(int id, int balance) {
        super(id, balance);
    }
}
