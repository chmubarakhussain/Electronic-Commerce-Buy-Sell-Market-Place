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
public class Admin extends Person{
    
    static List<Report> reports= new ArrayList<>();

    public Admin(String name, String email_address, String username, String password) {
        super(name, email_address, username, password);
    }
    
    public boolean authenticate(Ad a){
    if(a==null){
    
    return false;
    }
    
    else{
    System.out.println("Add AUTHENTICATED BY ADMIN");
        //checking if add contains abusive things
    return true;
    }
    
    }
    
    public Admin() {
        super();
    }
    public static void AddReport(Report r){
        reports.add(r);
    }
    public void RemoveReport(Report r){
        reports.remove(r);
    }
    public void ViewAd(int od){

        for(int i=0;i<ads.size();i++){

            if(ads.get(i).id==od){
                ads.get(i).Print();

            }
        }

    }
    public void MakeEvent(){
        System.out.print("\nEnter Title :\t");
        Scanner s = new Scanner(System.in);
        String title = s.nextLine();
        System.out.print("\nEnter Starting date :\t");
        String d1 = s.nextLine();
        System.out.print("\nEnter EndingDate\t");
        String d2 = s.nextLine();
        System.out.print("\nEnter place :\t");
        String place = s.nextLine();
        OLX instance =OLX.getInstance();
        instance.AddEvent(title, d1, d2, place, ads.size(), ads);//returning confirmation
        System.out.println("\nEvent Created successfully!");
    }
}
