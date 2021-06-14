/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bhai Aziz
 */
public class Person {
    int id;
    String name;
    String username;
    String password;
    String email_address;
    static int  id_count = 0;
    List<Ad>    ads;
    public Person() {
        ads=new ArrayList<>();
    }

    public Person(String name, String email_address, String username, String password) {
        this.id = id_count++;
        this.name = name;
        this.email_address = email_address;
        this.username = username;
        this.password = password;
        ads=new ArrayList<>();
    }
    public void MakeAd(){
        System.out.print("\nEnter Title :\t");
        Scanner s = new Scanner(System.in);
        String title = s.nextLine();
        System.out.print("\nEnter Picture Address :\t");
        String picture = s.nextLine();
        System.out.print("\nEnter Price :\t");
        int price = s.nextInt();
        s.nextLine();
        System.out.print("\nEnter Description :\t");
        String description = s.nextLine();
        System.out.print("\nEnter Category :\t");
        String catagory = s.nextLine();
        System.out.print("\nEnter Discount Factor :\t");
        double discount_factor = s.nextDouble();
        s.nextLine();
        System.out.println("Location:\t");
        String location = s.nextLine();
        Ad ad = new Ad(title,picture,price,description,catagory,discount_factor, location);
        ad.seller=new Seller(name);
        ads.add(ad);
        OLX olx = OLX.getInstance();
        Admin a=new Admin();
        boolean b=a.authenticate(ad);
        if(b){
        olx.listOfAdds.add(ad);
        System.out.println("Advertisement created!");
        }
        
        else{
            System.out.println("not posted");
        }
    }
    public void DeleteAd(){
        Scanner s = new Scanner(System.in);
        System.out.print("\nEnter ID :\t");
        int iD = s.nextInt();
        s.nextLine();
        OLX olx = OLX.getInstance();
        for(int i=0;i<ads.size();i++){
            if(ads.get(i).id==iD){
                Ad temp = ads.get(i);
                ads.remove(ads.get(i));
                
                 olx.listOfAdds.remove(temp);
       
            }
        }
        System.out.println("Advertisement deleted successfully!");
    }
}
