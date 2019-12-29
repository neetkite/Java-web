/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racoon.dto;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class CartFoodingDTO implements Serializable{
    private String id;
    private float price; 

    public CartFoodingDTO(String id, float price) {
        this.id = id;
        
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
    
    

    
}
