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
public class Card extends PaymentOptions {
    String card_type;
    String card_no;

    public Card() {
    }

    public Card(String card_type, String card_no) {
        this.card_type = card_type;
        this.card_no = card_no;

    }

    public Card(int id, int balance) {
        super(id, balance);
    }

    public Card(String card_type, String card_no, int id, int balance) {
        super(id, balance);
        this.card_type = card_type;
        this.card_no = card_no;
    }
    
}
