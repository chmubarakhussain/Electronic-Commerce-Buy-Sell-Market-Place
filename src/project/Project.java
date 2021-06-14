/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

//import java.sql.Connection;

import java.util.List;
import java.util.Scanner;

//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.util.List;
//import java.util.Scanner;
//import java.sql.*;


public class Project {

    
    static public int menu() {
        Scanner s = new Scanner(System.in);
        System.out.println("\n                                 .:|  OLX  |:.");
        System.out.println("Press 1 To Register");
        System.out.println("Press 2 For Log-in");
        System.out.println("Press 3 For View Advertiements");
        System.out.print("\nEnter Choice :\t");
        int choice = s.nextInt();
        s.nextLine();
        return choice;
        
    }

    static public int menu2() {
        
        Scanner s = new Scanner(System.in);
        System.out.println("\nPress 1 To View Ads");
        System.out.println("Press 2 Search an Ad");
        System.out.println("Press 3 to Make an Ad");
        System.out.println("Press 4 Remove Ad");
        System.out.println("Press 5 To Insert An Ad to Favourites");
        System.out.println("Press 6 To Remove An Ad From Favourites");
        System.out.println("Press 7 To Edit An Ad");
        System.out.println("Press 8 To View Ad Details");
        System.out.println("Press 9 To Contact Seller");
        System.out.println("Press 10 To Report An Ad");
        System.out.println("Press 11 To Provide Feedback");
        System.out.println("Press 12 to share advertisement to social media platform");
        System.out.println("Press 13 to Add an Event");
        System.out.println("Press 14 to Apply For Installments");
        System.out.println("Press 15 to Edit Profile");
        System.out.println("Press 16 to Logout");
        System.out.println("Press 17 to Checkout");
        System.out.println("Press 18 to Add to cart");
        
        System.out.print("You entered:\t");
        int choice = s.nextInt();
        s.nextLine();
        return choice;

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner s = new Scanner(System.in);
        OLX Website = OLX.getInstance(); //SINGLETON DESIGN PATTERN
        
        //making users
        Website.MakeUser("+92 30542424", "411-street", "malik abdulaziz", "malik@gmail.com", "u1", "1234");
        Website.MakeUser("+92 30542212", "timesquare", "hamza arshad", "hamza@gmail.com", "u2", "1234");
        Website.MakeUser("+92 30542413", "burjkhalifa", "sharukh khan", "sharukh@gmail.com", "u3", "1234");
        Website.MakeUser("+92 30543543", "waris nihari", "sarmad masood", "sarmad@gmail.com", "u4", "1234");
        Website.MakeUser("+92 30542574", "johar town", "mubarak hussain", "mubarak@gmail.com", "u5", "1234");
        
        
        List<User> users = Website.userList; //getting person list from WEBSITE's instance
        
        User u1 =  users.get(0); 
        User u2 =  users.get(1);
        User u3 =  users.get(2);
        User u4 =  users.get(3);
        User u5 =  users.get(4);
        
        //assigning 3 adds to user u1
        Ad a1=new Ad("iphone X", null, 150000, "iPhone X very Good Condition", "Phone", 0.25, "lahore");
        Website.listOfAdds.add(a1);
        Ad a2= new Ad("iphone X1", null, 289000, "iPhone X1 very Good Condition", "Phone", .50, "karachi");
        Website.listOfAdds.add(a2);
        Ad a3 = new  Ad("galaxy X", null, 200000, "Galaxy x very Good Condition", "Phone", 0.75, "peshawar");
        Website.listOfAdds.add(a3);
        Ad a4=new Ad("nokia X", null, 150000, "nokia X very Good Condition", "Phone", 0.25, "islamabad");
        Website.listOfAdds.add(a1);
        Ad a5=new Ad("samsung X", null, 150000, "samsung X very Good Condition", "Phone", 0.25, "quetta");
        Website.listOfAdds.add(a1);
        
        u1.ads.add(a1);
        u2.ads.add(a2);
        u3.ads.add(a3);
        u4.ads.add(a4);
        u5.ads.add(a5);

        //setting seller of those adds to user1
        for (int i=0;i<u1.ads.size();i++){
            u1.ads.get(i).SetSeller(u1.username);
         //   u1.ads.get(i).seller.UserName=u1.name;
        }
        
        //assigning hamza as seller of all adds of all users
        for(int i=0;i<Website.userList.size();i++){ //trsversing all users in website's list
            for(int k=0;k<Website.userList.get(i).ads.size();k++) {//traversing all adds of user i
            Website.userList.get(i).ads.get(k).SetSeller("hamza");
            }
        }
        
        int choice2;
        
        Guest g = new Guest();
        
        while (true) {
            int choice = menu();
            
            if (choice == 1) {//get registered
                g.GetRegistered();
            }
     
            else if (choice == 2) { //gets logged in
                
                System.out.printf("\nEnter Username : ");
                String username = s.nextLine();
                
                System.out.printf("\nEnter Password : ");
                String password = s.nextLine();
                
                User currentUser;
                currentUser = Website.Login(username, password);
                
                //user logged in successfully
                while (currentUser != null) {
                    
                    clearScreen();
                    System.out.printf("\nCurrent User : %s", currentUser.name);
                    
                    choice2 = menu2();
                    Scanner getChar = new Scanner(System.in);
                    
                    if (choice2 == 1) { //view add
                        Website.ViewAds();
                        getChar.nextLine();
                    }
                    else if (choice2 == 2) { //search an add
                        User c = (User) currentUser;
                        c.SearchAdByName();
                        getChar.nextLine();
                    }
                   else if (choice2 == 3) { //make an add
                        currentUser.MakeAd();
                        getChar.nextLine();
                    }
                   else if (choice2 == 4) { //remove add
                        currentUser.DeleteAd();
                        getChar.nextLine();
                    }
                   else if (choice2 == 5) { //insert add to favourites
                        User c = (User) currentUser;
                        c.InsertAdToFavourites();
                        getChar.nextLine();
                    }
                   else if (choice2 == 6) { //remove add from favourites
                        User c = (User) currentUser;
                        c.RemoveFromFavourites();
                        getChar.nextLine();
                    }
                   else if (choice2 == 7) { //edit and add
                        currentUser.EditAd();
                        getChar.nextLine();
                    }
                   else if (choice2 == 8) { //view add details
                        //Website.ViewAds();
                        User c = (User) currentUser;
                        //c.ViewAdDetails();
                        
                        Scanner s2 = new Scanner(System.in);
                        System.out.print("\nEnter id of add to view :\t");
                        int id1  = s2.nextInt();
                        
                        boolean h=false;

                        for(int i=0;i<Website.userList.size();i++){
                            for(int k=0;k<Website.userList.get(i).ads.size();k++){
                                if(Website.userList.get(i).ads.get(k).id==id1){
                                    h=true;
                                    Website.userList.get(i).ads.get(k).Print();
                                   // c.ShareAdvertisement(Website.persons.get(i).ads.get(k));
                                     //c.ViewAdDetails(id1);
                                     //h=true;

                                    break;
                                }
                            }
                        }

                        if(h==false)
                        {
                            System.err.println("Wrong Entry");
                        }
                        getChar.nextLine();
                    }
                    else if (choice2 == 9) { //contact seller
                       
                        boolean h=false;
                        Scanner s2 = new Scanner(System.in);
                        System.out.print("\nEnter name/username of seller :\t");
                        String n = s2.nextLine();
                    
                        for(int i=0;i<Website.userList.size();i++){
                            for(int k=0;k<Website.userList.get(i).ads.size();k++){
                                if(Website.userList.get(i).ads.get(k).seller.UserName.equalsIgnoreCase(n)){
                                    h=true;
                                    //c.ShareAdvertisement(Website.persons.get(i).ads.get(k));
                                    currentUser.ContactSeller(n);
                                    break;
                                }
                            }
                        }

                        if(h==false){
                            System.err.println("Wrong Entry!!");

                        }
                        getChar.nextLine();
                    }
                    else if (choice2 == 10) { //report an add
                        
                        currentUser.MakeReport();
                        getChar.nextLine();
                    }
                    else if (choice2 == 11) { //provide feedback
                        
                        currentUser.ProvideFeedback();
                        getChar.nextLine();
                    }
                    else if (choice2 == 12) { //share add to social media platform

                        int id1;
                        Scanner s2 = new Scanner(System.in);
                        System.out.print("\nEnter id of add to share :\t");
                        
                        id1 = s2.nextInt();
                        String s1=s2.nextLine();

                       boolean h=false;
                      
                        for(int i=0;i<Website.userList.size();i++){
                            for(int k=0;k<Website.userList.get(i).ads.size();k++){
                                if(Website.userList.get(i).ads.get(k).id==id1){
                                    h=true;
                                    currentUser.ShareAdvertisement(Website.userList.get(i).ads.get(k));
                                    break;
                                }
                            }
                        }
                        if(h==false){
                            System.err.println("\nWrong Entry\n");
                        }
                      getChar.nextLine();
                    }
                    else if (choice2 == 13) { //add an event
                        
                        Scanner sc = new Scanner(System.in);//contacing seller to give Discounts for event!
                        System.out.println("Enter Seller name whom you want to ask for discounts:\t");
                        String sellerName = sc.nextLine();
                        currentUser.ContactSeller(sellerName);
                        
                        Admin tempAdmin = new Admin(currentUser.name, currentUser.email_address, currentUser.username, currentUser.password);
                        OLX olx = OLX.getInstance();
                        olx.admins.add(tempAdmin);
                        System.out.println("Congratulations! you are promoted to admin! Now you can create event!");
                        
                        tempAdmin.MakeEvent();//filling event details
                        getChar.nextLine();
                    }
                    else if (choice2 == 14) { //apply for installments
                      
                        int id1;
                        boolean h=false;
                        Scanner s2 = new Scanner(System.in);
                        System.out.print("\nEnter id of add to apply for Installments/Loan :\t");
                        id1 = s2.nextInt();
                        for(int i=0;i<Website.userList.size();i++){
                            for(int k=0;k<Website.userList.get(i).ads.size();k++){
                                if(Website.userList.get(i).ads.get(k).id==id1){ //verifying credentials
                                   h=true;
                                    Website.userList.get(i).ads.get(k).ApplyForInstallments(Website.userList.get(i));//requests for appointment date
                                    break;
                                }
                            }
                        }
                      
                        if(h==false){
                            System.err.println("\nWrong Entry");
                        }

                     getChar.nextLine();
                    }
                    else if (choice2 == 15) { //to edit profile
                        
                        currentUser.EditProfile();
                        getChar.nextLine();
                    }
                    else if (choice2 == 16) { //to log out
                        currentUser = null;
                        System.out.println("Logged out Successfully!");
                        getChar.nextLine();
                    }
                    else if(choice2 == 17){ //check out
                        currentUser.MakeOrder();
                        getChar.nextLine();
                    }
                    else if(choice2 == 18){ //add to cart
                        Scanner sc = new Scanner(System.in);
                        System.out.print("Enter ID of advertisement to be added to cart:\t");
                        currentUser.AddToCart(sc.nextInt());
                        getChar.nextLine();
                    }
                }
            }
            if (choice == 3) {
                Website.ViewAds();
              
            }
            clearScreen();
        }
    }
}
