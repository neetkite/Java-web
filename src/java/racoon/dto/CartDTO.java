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
public class CartDTO implements Serializable {

    private String id;
    private String foodID, serviceID;
    private float total;

    public CartDTO(String id, String foodID, String serviceID, float total) {
        this.id = id;
        this.foodID = foodID;
        this.serviceID = serviceID;

        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

}
