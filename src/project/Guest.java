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
public class Guest {
    
    //no member variables like name beause its guest, and no need to have record
    public void ViewProducts(){
        OLX olx = OLX.getInstance();
        olx.ViewAds();//should be static because of concurrency problem
    }

    void ShareAd(Ad a){
        Scanner s = new Scanner(System.in);
        
        System.out.print("\nEnter social media platform to share Ad :\t");
        String platform = s.nextLine();
        
        SocialMediaFactory _factory = new SocialMediaFactory();
            SocialMedia a1= _factory.getSocialMedia(platform);
            a1.AddtoSocialMedia(a);
    }

    public void GetRegistered(){
        System.out.print("\nEnter Name :\t");
        Scanner s = new Scanner(System.in);
        
        String name = s.nextLine();
        System.out.print("\nEnter Email Address :\t");
        String email_address = s.nextLine();
        
        System.out.print("\nEnter Username :\t");
        String username = s.nextLine();
        
        System.out.print("\nEnter Password :\t");
        String password = s.nextLine();
        
        System.out.print("\nEnter Address :\t");
        String address = s.nextLine();
        
        System.out.print("\nEnter Phone Number :\t");
        String phone_no = s.nextLine();
        
        OLX olx =OLX.getInstance();
        
        String status = olx.MakeUser(phone_no, address, name, email_address, username, password);
        
        System.out.print("\n");
        System.out.print(status);
    }
}
