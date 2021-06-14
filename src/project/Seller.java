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
public class Seller {
    String UserName;
    List<String> messages=new ArrayList<>();
     static int id=1;
    
    Seller(){}
    
    
    Seller(String n){
    UserName=n;
    id++;
    
    }
    
    void AddMessage(String message){
        messages.add(message);
    
    }
    
}
