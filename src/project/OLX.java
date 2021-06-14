/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bhai Aziz
 */
public class OLX {
    List<User>     userList     = new ArrayList<>();
    List<Event>    events    = new ArrayList<>();
    List<Admin>    admins    = new ArrayList<>();
    List<Feedback> feedbacks = new ArrayList<>();
    List<Ad>        listOfAdds = new ArrayList<>();
    private static OLX instance = new OLX();
    
    public static OLX getInstance(){
        return instance;
    }
    private OLX() {
    }
    public String MakeUser(String phone_no, String address,  String name, String email_address, String username, String password){
        for(User u:userList){
            if(u.username.equalsIgnoreCase(username)){
                System.err.println("ERROR: USER already exists!");
                return "\nError Username Already Exists";
            }
        }
        if(password.isEmpty())
            return "\nError Empty Password";
            
        User user = new User(phone_no,address,name,email_address,username,password);
        userList.add(user);
        return "\nYou are registered successfully";
    }
    public void AddEvent(String title, String start_date, String end_date, String place, int no_of_products,List<Ad> ads){
        Event event = new Event(title,start_date,end_date,place,no_of_products, ads);
        events.add(event);
        
        event.attachSocialMediaPlatformToEvents(new WhatsApp());
        event.attachSocialMediaPlatformToEvents(new Facebook());
        event.attachSocialMediaPlatformToEvents(new Instagram());
        event.notifyAllSocialMediaPlatforms();
        
    }
    
    public void MakeAdmin(String name, String address,String username, String password){
        Admin admin = new Admin(name, address, username, password);
        admins.add(admin);
    }
    
    public User Login(String username, String password){
        for(User u:userList){
            if(u.username.equalsIgnoreCase(username) && u.password.equalsIgnoreCase(password) ){
                System.out.print("\nYou are logged in successfully");
                return u;
            }
        }
        System.err.print("\nError Invalid Credentials\n");
        return null;
    }
    
    public void AddFeedback(String title, String description){
        Feedback fdbck = new Feedback(title, description);
        feedbacks.add(fdbck);
    }
    
    public List<Ad> SearchAdbyName(String name){
        List<Ad> resultAds = new ArrayList<>();
        for(User user:userList){
            List<Ad> ads = user.ads;
                for(Ad ad:ads){
                    if(ad.title.contains(name) || ad.location.equalsIgnoreCase(name)){
                        resultAds.add(ad);
                    }
                }
        }
        return resultAds;
    }
    public List<Ad> SearchAdbyCategory(String category){
        List<Ad> resultAds = new ArrayList<>();
        for(User user:userList){
            List<Ad> ads = user.ads;
            for(Ad ad:ads){
                if(ad.category.equalsIgnoreCase(category)){
                    resultAds.add(ad);
                } 
            }
        }
        return resultAds;
    }
    public void ViewAds(){
        
        OLX olx = OLX.getInstance();
        
        int count =0;
       
            List<Ad> ads = this.listOfAdds;
            for(Ad ad:ads){
                count++;
                ad.PrintOverview();
            }
        
        if(count ==0){
            System.err.println("\nError No Ads");
        }
        
//        int count =0;
//        for(User user:userList){
//            List<Ad> ads = user.ads;
//            for(Ad ad:ads){
//                count++;
//                ad.PrintOverview();
//            }
//        }
//        if(count ==0){
//            System.err.println("\nError No Ads");
//        }
    }
    public Ad GetAd(int ID){
        for(User user:userList){
            List<Ad> ads = user.ads;
            for(Ad ad:ads){
                if(ad.id ==ID){
                    return ad;
                }
            }
        }
        return null;
    }
}
