/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author mubar
 */
public class SocialMediaFactory {
    public SocialMedia getSocialMedia(String str){
        if(str==null){
            System.err.println("\nInvalid Social Media Platform");
            return null;
        }
        else{
            if(str.equalsIgnoreCase("FACEBOOK")){
           SocialMedia a1=new Facebook();
           return a1;
           }
           else if(str.equalsIgnoreCase("WHATSAPP")){
               SocialMedia a1=new WhatsApp();
              return a1;
           }
           else if(str.equalsIgnoreCase("INSTAGRAM")){
               SocialMedia a1=new Instagram();
               return a1;
           }
           else{
                System.err.println("\nInvalid Social Media Platform");
                return null;
           }
        }
       
    }
}
