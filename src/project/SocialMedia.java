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
 * @author l174630
 */
public abstract class SocialMedia {
    List<Ad> LA=new ArrayList<>();
    
    public abstract void AddtoSocialMedia(Ad a);
    public void notifyEvent(Event e){
        //does nothing here
    }
    
    public void attachToEvent(Event e){
        e.attachSocialMediaPlatformToEvents(this);
    }
    
}
