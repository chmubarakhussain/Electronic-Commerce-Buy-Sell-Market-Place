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
public class Cart {
    int no_of_ads;
    List<Ad> ads;

    public Cart() {
        ads = new ArrayList<>();
    }
    void AddtoCart(Ad ad){
        ads.add(ad);
    }
    void RemoveFromCart(Ad ad){
        ads.remove(ad);
    }
}
