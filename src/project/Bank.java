/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javafx.util.Pair;


public class Bank {
    String name;
    int    id;
    int    max_limit;
    List<Pair<Ad, User>> listOfApplications;

    public Bank(String name, int addid, int max_limit) {
        this.name = name;
        this.id = addid;
        this.max_limit = max_limit;
        listOfApplications = new ArrayList<>();
    }
    
    public boolean recieveInstallmentApplications(Ad _ad, User _user){
        Pair<Ad, User> p1 = new Pair(_ad, _user);
        if( listOfApplications.add(p1)){
            System.out.println("Application received, Bank will provide you further details for the interview");
            return true;
        }
        System.err.println("Application NOT registered!!");
         return false;
    }
}
