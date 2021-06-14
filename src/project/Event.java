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
public class Event {
    String title;
    String start_date;
    String end_date;
    String place;
    int    no_of_products;
    List<Ad> ads=new ArrayList<>();
    List<SocialMedia> socialMarketingList = new ArrayList<>();
    
    public Event() {
    }

    public Event(String title, String start_date, String end_date, String place, int no_of_products,List<Ad> ads) {
        this.title = title;
        this.start_date = start_date;
        this.end_date = end_date;
        this.place = place;
        this.no_of_products = no_of_products;
        this.ads=ads;
    }
   public void AddDiscount(){

        System.out.print("\nEnter Discount :\t");
        Scanner s = new Scanner(System.in);
        int s1=s.nextInt();
        for(int i=0;i<ads.size();i++){
            ads.get(i).discount_factor=s1;

        }
    }
    
   public void attachSocialMediaPlatformToEvents(SocialMedia observer){
     socialMarketingList.add(observer);
    }
    
   public void notifyAllSocialMediaPlatforms(){
        for(SocialMedia observer: socialMarketingList){
            observer.notifyEvent(this);
        }
        System.out.println("Notified all social media platforms!");
    }
   
   
   
}