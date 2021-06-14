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
public class EasyPaisa extends PaymentOptions {
    String easy_paisa_account_no;
    String CNIC_no;

    public EasyPaisa(String easy_paisa_account_no, String CNIC_no, int id, int balance) {
        super(id, balance);
        this.easy_paisa_account_no = easy_paisa_account_no;
        this.CNIC_no = CNIC_no;
    }

    public EasyPaisa(int id, int balance) {
        super(id, balance);
    }

    public EasyPaisa(String easy_paisa_account_no, String CNIC_no) {
        this.easy_paisa_account_no = easy_paisa_account_no;
        this.CNIC_no = CNIC_no;
    }

    public EasyPaisa() {
    }
}
