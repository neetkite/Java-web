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
public class FoodingDTO implements Serializable{
    
    private String id;
    private String name;
    private float price;
    private int quantity, quantityCart;
    private String des;
    private boolean type;
    private String img;

    public FoodingDTO() {
    }

    public FoodingDTO(String id, String name, float price, int quantity, String des, boolean type, String img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.des = des;
        this.type = type;
        this.img = img;
    }

   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getQuantityCart() {
        return quantityCart;
    }

    public void setQuantityCart(int quantityCart) {
        this.quantityCart = quantityCart;
    }

    
    
    
    
    
    
}
