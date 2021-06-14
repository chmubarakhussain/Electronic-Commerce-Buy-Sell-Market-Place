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
public class User extends Person{
    String      phone_no;
    String      address;
    List<Ad>    favourites;
    Cart        cart;
    List<Order> orders;
    List<SocialMedia> plat;

    public User() {
        super();
        favourites  = new ArrayList<>();
        orders  = new ArrayList<>();
        plat    = new ArrayList<>();
        cart = new Cart();
    }

    public User(String phone_no, String address,  String name, String email_address, String username, String password) {
        super(name, email_address, username, password);
        this.phone_no = phone_no;
        this.address = address;
        favourites = new ArrayList<>();
        orders     = new ArrayList<>();
         plat    = new ArrayList<>();
        cart = new Cart();
    }

   
    void RemoveFromFavourites(){
        System.out.printf("\nEnter ID :\t");
        Scanner s = new Scanner(System.in);
        int ID    = s.nextInt();
        s.nextLine();
        for(Ad a:favourites){
            if(a.id == ID){
                favourites.remove(a);
                System.out.println("Advertisement removed from your favoutites!");
                return;
            }
        }
        System.err.println("Advertisement against this ID is NOT found!"); 
    }
    
    void AddToCart(int Id){
        OLX olx = OLX.getInstance();
         for (Ad ad :olx.listOfAdds){
            if(ad.id == Id){
                cart.AddtoCart(ad);
                System.out.println("Added to cart successfully!");
                return;
            }
        }
        System.err.println("Cannot be added to cart");
    }
    void RemoveFromCart(int Id){
        for (Ad ad :ads){
            if(ad.id == Id){
                cart.RemoveFromCart(ad);
                 System.out.println("Removed from cart successfully!");
                return;
            }
        }
        System.err.println("Cannot be removed from cart");
    }

    void ViewAdDetails(int od){
       
        for (Ad ad :ads){
            if(ad.id ==od){
                ad.Print();
                break;
            }
        }
    }
    
    void ViewAds(){
        OLX olx = OLX.getInstance();
        olx.ViewAds();
    }
    
    void SearchAdByName(){
        OLX olx = OLX.getInstance();
        System.out.printf("\nEnter Keyword of title/location :\t");
        Scanner s = new Scanner(System.in);
        String nam = s.nextLine();
        List<Ad> ads_found = olx.SearchAdbyName(nam);
        if(ads_found.isEmpty()){
            System.err.println("No Match found! Kindly be CASE SENSTIVE!");
            return;
        }
        //printing resultant adds
        for(Ad a : ads_found){
            a.Print();
        }
        
    }
    void FilterAdsByCategory(){
        OLX olx = OLX.getInstance();
        System.out.printf("\nEnter Name :\t");
        Scanner s = new Scanner(System.in);
        String nam = s.nextLine();
        List<Ad> ads_found = olx.SearchAdbyCategory(nam);
        ads_found.stream().forEach((a) -> {
            a.Print();
        });
    }
    void InsertAdToFavourites(){
        OLX olx = OLX.getInstance();
        System.out.printf("\nEnter ID :\t");
        Scanner s = new Scanner(System.in);
        int ID    = s.nextInt();
        s.nextLine();
        Ad ad = olx.GetAd(ID);
        if(ad !=null){
            for(Ad temp: favourites){
                if(temp.equals(ad)){
                    System.err.println("This advertisement in ALREADY in you favourites!");
                    return;
                }
            }
             favourites.add(ad);
             System.out.println("\nAdvertisement added to your favourites!");
        }
        else{
            System.err.println("No advertisement found against this ID");
        }
       
    }
    void ViewProfile(){
        System.out.printf("\nId :\t%d", id);
        System.out.printf("\nName :\t%s", name);
        System.out.printf("\nEmail :\t%s", email_address);
        System.out.printf("\nPhone Number :\t%s", phone_no);
        System.out.printf("\nAddress :\t%s", address);
    }
    void EditAd(){
        
        System.out.printf("\nEnter ID :\t");
        
        Scanner s = new Scanner(System.in);
        int ID    = s.nextInt();
        s.nextLine();
     
        for(Ad ad:ads){
            if(ID == ad.id){
                System.out.printf("\n--------Current Details------");
                ad.Print();
                ChangeAdDetails(ad);
                return;
            }
        }
        System.err.println("Advertisement against this ID is NOT found");
    }
    private void ChangeAdDetails(Ad ad){
        System.out.printf("\nPress 1 to change title\nPress 2 to change Picture Address\nPress 3 to change price\nPress 4 to change Description\nPress 5 to change Category\nPress 6 to change discount factor\n ");
        Scanner s = new Scanner(System.in);
        int num   = s.nextInt();
        s.nextLine();
        switch(num){
            case 1:
                System.out.printf("\nEnter New Title:\t");
                ad.title = s.nextLine();
                 System.out.printf("\nAd details changed successfully\n");
                break;
            case 2:
                System.out.printf("\nEnter New Picture Address:\t");
                ad.picture= s.nextLine();
                 System.out.printf("\nAd details changed successfully\n");
                break;
            case 3:
                System.out.printf("\nEnter New Price:\t");
                ad.price = s.nextInt();
                s.nextLine();
                 System.out.printf("\nAd details changed successfully\n");
                break;
            case 4:
                System.out.printf("\nEnter New Description:\t");
                ad.description= s.nextLine();
                 System.out.printf("\nAd details changed successfully\n");
                break;
            case 5:
                System.out.printf("\nEnter New Category:\t");
                ad.description= s.nextLine();
                 System.out.printf("\nAd details changed successfully\n");
                break;
            case 6:
                System.out.printf("\nEnter New Price:\t");
                ad.discount_factor = s.nextDouble();
                s.nextLine();
                 System.out.printf("\nAd details changed successfully\n");
                break;
            default:
                System.err.printf("\nInvalid Input!!");
                break;
        }
        
    }
    void EditProfile(){
        System.out.printf("\nCurrent Details");
        ViewProfile();
        System.out.printf("\nPress 1 to change name\nPress 2 to change Email\nPress 3 to Phone_No\nPress 4 to change Address\n");
        Scanner s = new Scanner(System.in);
        int num   = s.nextInt();
        s.nextLine();
        switch(num){
            case 1:
                System.out.printf("\nEnter New Name:\t");
                name = s.nextLine();
                System.out.println("Name updated!");
                break;
            case 2:
                System.out.printf("\nEnter New Email Address:\t");
                email_address= s.nextLine();
                System.out.println("Email updated!");
                break;
            case 3:
                System.out.printf("\nEnter New Phone Number:\t");
                phone_no= s.nextLine();
                System.out.println("Phone Number updated!");
                break;
            case 4:
                System.out.printf("\nEnter New Address:\t");
                address= s.nextLine();
                System.out.println("Address updated!");
                break;
            default:
                System.err.printf("\nInvalid Input\n");
                break;
        }
        System.out.println(this.name + "\t" + this.username + "\t" + this.phone_no + "\t" + this.address + "\t" + this.email_address);
    }
    void MakeReport(){
        Scanner s = new Scanner(System.in);
        System.out.print("\nEnter Ad Id :\t");
        int ID = s.nextInt();
        s.nextLine();
        System.out.print("\nEnter Report Type :\t");
        String reportType = s.nextLine();
        System.out.print("\nEnter Report Description :\t");
        String description = s.nextLine();
        Report r  = new Report(ID,reportType,description);
        Admin.AddReport(r);
        System.out.println("Advertisement REPORTED Successfully! We are extremely SORRY for this experience");
        
        
    }
    void ProvideFeedback(){
        Scanner s = new Scanner(System.in);
        System.out.print("\nEnter Title :\t");
        String title = s.nextLine();
        System.out.print("\nEnter Feedback Description :\t");
        String description = s.nextLine();
        OLX olx =OLX.getInstance();
        olx.AddFeedback(title, description);
        System.out.println("Your precious Feedback SUBMITTED!!");
    }



    void ContactSeller(String postedby){
        
    boolean g=true;
    
        for(int i=0;i<ads.size();i++){

            if(ads.get(i).seller.UserName.equalsIgnoreCase(postedby)){
                g=true;
            }
        }

        if(g==true) {
            Seller s1 = new Seller(postedby);
            Scanner s = new Scanner(System.in);
            System.out.print("\nEnter Message to seller :\t");
            String message = s.nextLine();
            s1.AddMessage(message);
            System.out.println("Message sent to seller");
        }

        else {

            System.err.println("\nWrong Entry!!");
        }
    }

    void ShareAdvertisement(Ad a){

        Scanner s = new Scanner(System.in);
        System.out.print("\nEnter platform to share Ad :\t");
        String platform = s.nextLine();
        if(platform.equalsIgnoreCase("FACEBOOK")){
            SocialMedia a1=new Facebook();
            a1.AddtoSocialMedia(a);
            this.plat.add(a1);}

        else if(platform.equalsIgnoreCase("WHATSAPP")){
            SocialMedia a1=new WhatsApp();
            a1.AddtoSocialMedia(a);
            plat.add(a1);}


        else if(platform.equalsIgnoreCase("INSTAGRAM")){
            SocialMedia a1=new Instagram();
            a1.AddtoSocialMedia(a);
            plat.add(a1);}

        else {
            System.err.println("\nPlatform doesn't exist");
        }
    }

    void MakeOrder(){
        
        int sum=0;
        int total_discount=0;
        
        if(cart.ads.isEmpty()){
            System.err.println("CART is empty!!");
            return;
        }
        
        for(Ad ad:cart.ads){ //fills payment info
            sum=sum+ad.price;
            total_discount += ad.price*ad.discount_factor;
           
        }
        
        Order o = new Order(sum,total_discount,cart); 
        o.AddPaymentMethod();//verified payment credentials
        orders.add(o);//payment done ie confirmation
        
         for(Ad ad:cart.ads){ //fills payment info
            this.ads.remove(ad); //marking as sold i.e deleting add
        }
        
        System.out.println("Order Placed Successfully");//returns CONFIRMATION
    }
    
    void RemoveOrder(){
        Scanner s = new Scanner(System.in);
        System.out.print("\nEnter Order Id :\t");
        int ID = s.nextInt();
        s.nextLine();
        for(Order o:orders){
            if(o.id ==ID){
                orders.remove(o);
                break;
            }
        }
    }
    
}
