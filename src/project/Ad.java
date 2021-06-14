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
public class Ad {
    String title;
    int    id;
    String picture;
    int    price;
    String description;
    String category;
    double discount_factor;
    static int  id_count = 0; //not in db
    Seller seller; ///not in db
    String location;
    
    
    public Ad() {
    }

    public Ad(String title, String picture, int price, String description, String catagory, double discount_factor, String location) {
        this.title = title;
        this.id = id_count++;
        this.picture = picture;
        this.price = price;
        this.description = description;
        this.category = catagory;
        this.discount_factor = discount_factor;
        this.location = location;
        
    }

  public  void SetSeller(String Name){
        seller=new Seller(Name);

    }
    void Print(){
        System.out.printf("\nId :\t%d", id);
        System.out.printf("\nTitle :\t%s", title);
        System.out.printf("\nCategory :\t%s", category);
        System.out.printf("\nPicture Address :\t%s", picture);
        System.out.printf("\nPrice :\t%s", price);
        System.out.printf("\nDescription :\t%s", description);
        System.out.printf("\nDiscount_Factor :\t%s\n\n", discount_factor);
    }
    
    void PrintOverview(){
        System.out.printf("\nId :  %d\t", id);
        System.out.printf("Title : %s\t", title);
        System.out.printf("Category : %s\t", category);
        System.out.printf("Price : %s\t", price);
        System.out.printf("Seller : %s\t", seller.UserName);
    }

    void ApplyForInstallments(User _user){
        Bank b=new Bank("national",id,200000); //name, id, maxLimitForLoan
        b.recieveInstallmentApplications(this, _user); //return appointment date to user
    }

}
